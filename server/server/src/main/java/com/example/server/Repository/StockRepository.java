package com.example.server.Repository;
import com.example.server.Model.Market;
import com.example.server.Model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepository{

    //SQLの実行・DB操作を行う
    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //JdbcTempateの抽出結果をjavaオブジェクトにマッピングするために使用
    private final DataClassRowMapper<Stock> mapper = new DataClassRowMapper<>(Stock.class);

    public StockRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

        //株式一覧の取得
//    jdbcTemplate.query():データを取り出す時に使う
//    query(sql, mapper, (プレースホルダー?に入る値の条件))
        public List<Stock> listAll() {
            String sql = "SELECT ticker, name, \"exchangeMarket\", shares_issued FROM stock723";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Stock stock = new Stock();
                stock.setTicker(rs.getString("ticker"));
                stock.setName(rs.getString("name"));
                stock.setExchangeMarket(Market.valueOf(rs.getString("exchangeMarket")));
                stock.setShares_issued(rs.getInt("shares_issued"));
                return stock;
            });
        }

        //株式の追加
    //jdbcはenumをSQLに変換できないので、enumは.name()する。
    public void register(Stock stock){

        String sql = "INSERT INTO stock723 (ticker, name, \"exchangeMarket\",shares_issued) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, stock.getTicker(), stock.getName(), stock.getExchangeMarket().name(), stock.getShares_issued());
    }



}

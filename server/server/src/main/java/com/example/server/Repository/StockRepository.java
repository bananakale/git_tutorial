package com.example.server.Repository;
import com.example.server.Model.Stock;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepository {

    //SQLの実行・DB操作を行う
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //JdbcTempateの抽出結果をjavaオブジェクトにマッピングするために使用
    private final DataClassRowMapper<Stock> mapper = new DataClassRowMapper<>(Stock.class);

    public StockRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

        //株式一覧の取得
//    jdbcTemplate.query():データを取り出す時に使う
//    query(sql, mapper, (プレースホルダー?に入る値の条件))
        public List<Stock> listAll(){
            return jdbcTemplate.query("SELECT * FROM stock723", mapper);
        }

        //株式の追加
    public Stock register(Stock stock){

        String sql = "INSERT INTO stock723 (ticker, name, exchange_market,shares_issued VALUES(?, ?, ?, ?))";
       //JdbcTemplate.updateの働き：データを変更(INSERT/UPDATE/DELETE)時
        //update(sql,(プレースホルダー?に入る値) )
        jdbcTemplate.update(sql, stock.getTicker(), stock.getName(), stock.getExchange_market(), stock.getShares_issued());

        return stock;

    }



}

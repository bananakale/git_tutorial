package com.example.server.Service;

import com.example.server.Model.Stock;
import com.example.server.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    //株式一覧表示
    public List<Stock> listAll(){
        return stockRepository.listAll();
    }

    //株式追加
    public void register(Stock stock){
      stockRepository.register(stock);
    }




}

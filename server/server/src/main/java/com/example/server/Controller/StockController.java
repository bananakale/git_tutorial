package com.example.server.Controller;

import com.example.server.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/innovation")
public class StockController {

    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    //株式一覧表示

    @GetMapping("/displayStocks")
    public String displayStocks(Model model){
        List<Stock> stocks = stockService.getAllStocks();
        model.addAttribute("stocks", stocks);
        return "stocks/list";
    }


    //株式追加フォーム
    @GetMapping("/addStocks")
    public String inputForm(Model model){
        model.addAttribute("stock",new Stock());
        return "stocks/input"
    }

    //株式追加POST処理
@PostMapping("/addStocks")
    public String register(@ModelAttribute Stock stock){
        stockService.register(stock);
        return "redirect:/innovation/displayStocks";
}


}

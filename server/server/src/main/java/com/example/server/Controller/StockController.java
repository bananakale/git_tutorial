package com.example.server.Controller;

import com.example.server.Model.Market;
import com.example.server.Model.Stock;
import com.example.server.Service.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/innovation")
public class StockController {

    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping
    public String home(){
        return "layouts";
    }

    //株式一覧表示
    @GetMapping("/displayStocks")
    public String displayStocks(Model model){
        List<Stock> stocks = stockService.listAll();
        model.addAttribute("stocks", stocks);
        return "stocks/list";
    }


    //株式追加フォーム

     @GetMapping("/addStock")
    public String inputForm(Model model){
        model.addAttribute("stock",new Stock());
        //enumの全ての値をリストとして渡す
         model.addAttribute("markets", Market.values());

        return "stocks/input";
    }

    //株式追加POST処理
    @PostMapping("/stocks/add")
    public String addStock(@ModelAttribute Stock stock, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "stocks/input";
        }
        try {
            stockService.register(stock);
        }catch(DuplicateTickerException e){
           bindingResult.rejectValue("ticker", "duplicate", "この銘柄コードは既に登録されています");
           return "stocks/input";
        }
        return "redirect:/displayStocks"; // ←これ大事！redirect しないとダメ
    }


}

package com.example.server.Model;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;


public class Stock {

    @Pattern(regexp="^[1-9][ACDFGHJKLMNPRSTUWXY0-9][0-9][ACDFGHJKLMNPRSTUWXY0-9]$", message="tickerの入力規則を確認してください")
    @NotBlank
    private String ticker;
    @Pattern(regexp="^[A-Za-z0-9 .()]*$")
    @NotBlank
    private String name;
    @NotNull
    private Market exchangeMarket;
    @Range(min=1, max = 999_999_999_999L,message = "1~999999999999の間で入力してください")
    private long shares_issued;


    public String getTicker() {
        return ticker;
    }


    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Market getExchangeMarket() {
        return exchangeMarket;
    }

    public void setExchangeMarket(Market exchangeMarket) {
        this.exchangeMarket = exchangeMarket;
    }

    public long getShares_issued() {
        return shares_issued;
    }

    public void setShares_issued(long shares_issued) {
        this.shares_issued = shares_issued;
    }
}

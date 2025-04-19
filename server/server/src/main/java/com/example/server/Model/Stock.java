package com.example.server.Model;

public class Stock {
    //フィールド名とデータベースのカラムが一致している必要がある
    private String ticker;
    private String name;
    private Market exchange_market;
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

    public Market getExchange_market() {
        return exchange_market;
    }

    public void setExchange_market(Market exchange_market) {
        this.exchange_market = exchange_market;
    }

    public long getShares_issued() {
        return shares_issued;
    }

    public void setShares_issued(long shares_issued) {
        this.shares_issued = shares_issued;
    }
}

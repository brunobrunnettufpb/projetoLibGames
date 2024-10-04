package br.ufpb.dcx.libGames.Models;

import java.io.Serializable;

public class Value implements Serializable {
    private double value;
    private String currency;
    private String symbol;

    public Value(double value, String currency, String symbol) {
        this.value = value;
        this.currency = currency;
        this.symbol = symbol;
    }
    public Value() {
        this(0.0, "", "");
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

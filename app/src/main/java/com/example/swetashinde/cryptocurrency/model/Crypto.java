package com.example.swetashinde.cryptocurrency.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by swetashinde on 4/23/18.
 */

public class Crypto implements Serializable{
   @SerializedName("id") String id;
   @SerializedName("name") String name;
   @SerializedName("symbol") String symbol;
   @SerializedName("rank") int rank;
   @SerializedName("price_usd") String priceUsd;
   @SerializedName("price_btc") String priceBtc;
   @SerializedName("24h_volume_usd") String twentyFourHvolumeUsd;
   @SerializedName("market_cap_usd") String marketCapUsd;
   @SerializedName("available_supply") String availableSupply;
   @SerializedName("total_supply") String totalSupply;
   @SerializedName("percent_change_1h") String percentChange1h;
   @SerializedName("percent_change_24h") String percentChange24h;
   @SerializedName("percent_change_7d") String percentChange7d;
   @SerializedName("last_updated") String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getTwentyFourHvolumeUsd() {
        return twentyFourHvolumeUsd;
    }

    public void setTwentyFourHvolumeUsd(String twentyFourHvolumeUsd) {
        this.twentyFourHvolumeUsd = twentyFourHvolumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

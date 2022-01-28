package com.serdaryigit.kline;

import android.util.Log;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.json.JSONArray;
import org.json.JSONException;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)

public class KlineModel {
 
    String openTime;                      // Opentime
   
    String open;                          // Open

    String high;                          // High
 
    String low;                           // Low
 
    String close;                         // Close
  
    String volume;                        // Volume
   
    String closeTime;                     // Close time
    
    String quoteAssetVolume;              // Quote asset volume
    
    String numberOfTrades;                // Number of trades
   
    String takerBuyBaseAssetVolume;       // Taker buy base asset volume
    
    String takerBuyQuoteAssetVolume;      // Taker buy quote asset volume
    
    String igNoreKline;                   // Ignore.
   
   

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(String quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public String getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(String numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public String getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(String takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public String getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(String takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public String getIgNoreKline() {
        return igNoreKline;
    }

    public void setIgNoreKline(String igNoreKline) {
        this.igNoreKline = igNoreKline;
    }

    public KlineModel(String openTime, String open, String high, String low, String close, String volume, String closeTime, String quoteAssetVolume, String numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume, String igNoreKline) {
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        this.igNoreKline = igNoreKline;
    }




}

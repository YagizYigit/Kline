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
    //   @SerializedName("openTime")
    String openTime;              // Opentime

    //    @SerializedName("open")
    String open;                // Open

    //    @SerializedName("high")
    String high;                // High

    //    @SerializedName("low")
    String low;                 // Low

    //     @SerializedName("close")
    String close;               // Close

    //   @SerializedName("5")
    String volume;               // Volume
    //     @SerializedName("6")
    String closeTime;             // Close time
    //     @SerializedName("7")
    String quoteAssetVolume;                 // Quote asset volume
    //     @SerializedName("8")
    String numberOfTrades;                  // Number of trades
    //     @SerializedName("9")
    String takerBuyBaseAssetVolume;                  // Taker buy base asset volume
    //     @SerializedName("10")
    String takerBuyQuoteAssetVolume;                  // Taker buy quote asset volume
    //    @SerializedName("11")
    String igNoreKline;              // Ignore.
    /**/
    String[] array = {
            "openTime",
            "open",
            "high",
            "low",
            "close",
            "volume",
            "closeTime",
            "quoteAssetVolume",
            "numberOfTrades",
            "takerBuyBaseAssetVolume",
            "takerBuyQuoteAssetVolume",
            "igNoreKline"};

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

    public void jasonParsee() {
        String jsonString = "[[1642850280000,\"35291.18000000\",\"35318.00000000\",\"35250.15000000\",\"35304.72000000\",\"114.16537000\",1642850339999,\"4027913.53985850\",1368,\"61.48630000\",\"2168980.00679440\",\"0\"],[1642850340000,\"35304.73000000\",\"35305.26000000\",\"35265.89000000\",\"35280.60000000\",\"34.95279000\",1642850399999,\"1233376.84292890\",980,\"15.87426000\",\"560150.87425420\",\"0\"]]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONArray jsonArray2 = jsonArray.getJSONArray(0);

            for (int i = 0; i < jsonArray2.length(); i++) {
                String valueString = jsonArray2.getString(i);
                Log.e("json", (" " + array[i] + " " + " : " + valueString));
                new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                        .append(array[i], i).toString();

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }


}
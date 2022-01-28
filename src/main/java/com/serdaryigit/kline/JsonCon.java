package com.serdaryigit.kline;

import com.binance.api.client.constant.BinanceApiConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonCon {


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


    public void jasonParsee () {
        String jsonString = "[[1642850280000,\"35291.18000000\",\"35318.00000000\",\"35250.15000000\",\"35304.72000000\",\"114.16537000\",1642850339999,\"4027913.53985850\",1368,\"61.48630000\",\"2168980.00679440\",\"0\"],[1642850340000,\"35304.73000000\",\"35305.26000000\",\"35265.89000000\",\"35280.60000000\",\"34.95279000\",1642850399999,\"1233376.84292890\",980,\"15.87426000\",\"560150.87425420\",\"0\"]]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONArray jsonArray2 = jsonArray.getJSONArray(0);

            for (int i = 0; i < jsonArray2.length(); i++) {
                String valueString = jsonArray2.getString(i);
                System.out.println(" " + array[i] + " " + " : " + valueString);
               // Log.e("json", (" " + array[i] + " " + " : " + valueString));
                new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                        .append(array[i], i).toString();

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return ;
    }


}

package com.serdaryigit.kline;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.binance.api.client.constant.BinanceApiConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    Retrofit retrofit;
    OkHttpClient sharedClient;
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

    private String BASE_URL = "https://api1.binance.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // jasonParsee();


        Gson gson = new Gson();


    //    Type newKline = new TypeToken<ArrayList<KlineModel>>(){}.getType();
      //  ArrayList<KlineModel> newKlineModel = gson.fromJson(jsonCon, newKline );
    //    System.out.println(newKlineModel);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(sharedClient)
                .build();

       loadData();
        //  jasonParsee();


    }

    public void loadData() {
        KriptoApi kriptoApi = retrofit.create(KriptoApi.class);
        Call<KlineModel> call = kriptoApi.getData();
        call.enqueue(new Callback<KlineModel>() {
            @Override
            public void onResponse(Call<KlineModel> call, Response<KlineModel> response) {
                KlineModel klineModel = response.body();
                System.out.println(klineModel);


            }

            @Override
            public void onFailure(Call<KlineModel> call, Throwable t) {
                System.out.println("hata var" + t);
            }
        });


    }


    public void jasonParsee () {
        String jsonString = "[[1642850280000,\"35291.18000000\",\"35318.00000000\",\"35250.15000000\",\"35304.72000000\",\"114.16537000\",1642850339999,\"4027913.53985850\",1368,\"61.48630000\",\"2168980.00679440\",\"0\"],[1642850340000,\"35304.73000000\",\"35305.26000000\",\"35265.89000000\",\"35280.60000000\",\"34.95279000\",1642850399999,\"1233376.84292890\",980,\"15.87426000\",\"560150.87425420\",\"0\"]]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONArray jsonArray2 = jsonArray.getJSONArray(0);

            for (int i = 0; i < jsonArray2.length(); i++) {
                String valueString = jsonArray2.getString(i);
                System.out.println("\"" + array[i] + "\"" + ": " +"\"" + valueString+ "\"");
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

/*
    public Converter.Factory jasonParsee() {
        String jsonString = "[[1642850280000,\"35291.18000000\",\"35318.00000000\",\"35250.15000000\",\"35304.72000000\",\"114.16537000\",1642850339999,\"4027913.53985850\",1368,\"61.48630000\",\"2168980.00679440\",\"0\"],[1642850340000,\"35304.73000000\",\"35305.26000000\",\"35265.89000000\",\"35280.60000000\",\"34.95279000\",1642850399999,\"1233376.84292890\",980,\"15.87426000\",\"560150.87425420\",\"0\"]]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONArray jsonArray2 = jsonArray.getJSONArray(0);

            for (int i = 0; i < jsonArray2.length(); i++) {
                String valueString = jsonArray2.getString(i);
                Log.e("json", ("\"" + array[i] + "\"" + ": " + "\"" + valueString + "\""));
                new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                        .append(array[i], i).toString();
                // System.out.println(i + "=" + valueString);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


 */

}

/*

   call.enqueue(new Callback<ArrayList<KlineModel>>() {
            @Override
            public void onResponse(Call<ArrayList<KlineModel>> call, Response<ArrayList<KlineModel>> response) {
                S


            }

            @Override
            public void onFailure(Call<ArrayList<KlineModel>> call, Throwable t) {

                t.printStackTrace();
                System.out.println("+++++++   " + t);
            }
        });



   Gson gson = new GsonBuilder()
                .create();


        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(sharedClient)
                .build();


        try {
            loadData();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void loadData() throws JSONException {
        KriptoApi kriptoApi = retrofit.create(KriptoApi.class);




    }

 */
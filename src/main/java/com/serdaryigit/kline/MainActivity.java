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

       


        Gson gson = new Gson().newBuilder().create();

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

       loadData();    
       


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
/* -------------------------------BU KISIM URL'DEN GELEN  DATANIN JSON HALİ  (DATA POSTMAN ÜZERİNDEN ALINMIŞTIR...)------------------------
[
    [
        1643389920000,
        "37140.00000000",
        "37141.18000000",
        "37052.17000000",
        "37054.91000000",
        "22.08144000",
        1643389979999,
        "819179.74828210",
        705,
        "9.79463000",
        "363212.47614610",
        "0"
    ],
    [
        1643389980000,
        "37054.90000000",
        "37076.85000000",
        "37029.75000000",
        "37029.75000000",
        "12.58066000",
        1643390039999,
        "466166.74746430",
        425,
        "4.74596000",
        "175883.77053670",
        "0"
    ]
]

-----------------------------------------------------------END-------------------------
*/
    
    




}







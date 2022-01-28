package com.serdaryigit.kline;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KriptoApi {
    String sembol = "FTMUSDT";

        @GET("/api/v3/klines?symbol=" + sembol + "&interval=1m")         //   kline kısmı gelen json yapısından dolayı okunmuyor

    //  @GET("/api/v3/aggTrades?symbol=" + sembol +"&limit=5")           //   aggTrades kısmı data geliyor

  Call<KlineModel> getData();


}

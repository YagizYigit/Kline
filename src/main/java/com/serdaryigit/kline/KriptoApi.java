package com.serdaryigit.kline;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KriptoApi {
    String sembol = "FTMUSDT";

  @GET("/api/v3/klines?symbol=" + sembol + "&interval=1m")
 //  @GET("/api/v3/depth?symbol=" + sembol )
   //  @GET("/api/v3/aggTrades?symbol=" + sembol +"&limit=5")

  Call<KlineModel> getData();


}

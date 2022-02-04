package com.serdaryigit.kline;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KriptoApi {
          @GET("/api/v3/klines?symbol="FTMUSDT"&interval=1m")          
  Call<KlineModel> getData();


}

package com.test.testworkpad.model;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
  @POST("tr.json/translate")
  Call<TranslateResp> translate(@Query("key") String key, @Query("text") String word, @Query
        ("lang") String lang);
}

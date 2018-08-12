package com.test.testworkpad.di;

import com.test.testworkpad.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  @Provides
  public Retrofit retrofit(OkHttpClient client,
                           GsonConverterFactory gsonConverterFactory)
  {
    return new Retrofit.Builder().client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .addConverterFactory(gsonConverterFactory)
          .build();
  }


  @Provides
  public GsonConverterFactory gsonConverterFactory() {
    return GsonConverterFactory.create();
  }


  @Provides
  @Singleton
  public OkHttpClient okHttpClient(HttpLoggingInterceptor interceptor) {
    return new OkHttpClient().newBuilder().addInterceptor(interceptor)
          .connectTimeout(30, TimeUnit.SECONDS).build();
  }


  @Provides
  public HttpLoggingInterceptor interceptor() {
    return new HttpLoggingInterceptor().setLevel
          (HttpLoggingInterceptor.Level.BODY);
  }
}

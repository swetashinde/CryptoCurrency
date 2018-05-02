package com.example.swetashinde.cryptocurrency.di;

import com.example.swetashinde.cryptocurrency.model.CoinMarketCapApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swetashinde on 4/25/18.
 */

@Module
public class NetModule {

    private static final String BASE_URL = "https://api.coinmarketcap.com/";

    @Provides
    public CoinMarketCapApi providesCoinMarketCapApi(Retrofit retrofit){
       return retrofit.create(CoinMarketCapApi.class);
    }

    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return (new Retrofit.Builder()).baseUrl(BASE_URL).addCallAdapterFactory((CallAdapter.Factory) RxJava2CallAdapterFactory
            .create()).addConverterFactory((retrofit2.Converter.Factory) GsonConverterFactory.create()).client(okHttpClient).build();
    }

    @Provides
    public OkHttpClient providesOkHttpClient(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = (new okhttp3.OkHttpClient.Builder()).addInterceptor((Interceptor)httpLoggingInterceptor).build();

        return okHttpClient;

    }

}

package com.example.swetashinde.cryptocurrency.model;

import io.reactivex.Single;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swetashinde on 4/23/18.
 */

public interface CoinMarketCapApi {

    @GET("v1/ticker/")
    @NotNull Single<List<Crypto>> getCryptoList(@Query("start") int var1, @Query("limit") int var2);
}

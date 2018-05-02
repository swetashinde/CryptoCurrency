package com.example.swetashinde.cryptocurrency.model;

import io.reactivex.Single;
import java.util.List;

/**
 * Created by swetashinde on 4/23/18.
 */

public interface CoinMarketCapRepository {

   Single<List<Crypto>> getCryptoList(int page,int limit);
}

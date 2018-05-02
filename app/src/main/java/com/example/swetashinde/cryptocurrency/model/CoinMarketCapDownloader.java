package com.example.swetashinde.cryptocurrency.model;

import io.reactivex.Single;
import java.util.List;

/**
 * Created by swetashinde on 4/23/18.
 */

public class CoinMarketCapDownloader implements CoinMarketCapRepository {

    private CoinMarketCapApi coinMarketCapApi;

    public CoinMarketCapDownloader(CoinMarketCapApi coinMarketCapApi){
        this.coinMarketCapApi = coinMarketCapApi;
    }



    @Override public Single<List<Crypto>> getCryptoList(int page, int limit) {
        return  coinMarketCapApi.getCryptoList(page,limit);
    }
}

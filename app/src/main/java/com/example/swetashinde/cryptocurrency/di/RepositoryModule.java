package com.example.swetashinde.cryptocurrency.di;

import com.example.swetashinde.cryptocurrency.model.CoinMarketCapApi;
import com.example.swetashinde.cryptocurrency.model.CoinMarketCapDownloader;
import com.example.swetashinde.cryptocurrency.model.CoinMarketCapRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 4/25/18.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public CoinMarketCapRepository providesCoinMarketCapRepository(CoinMarketCapApi coinMarketCapApi ){
        return (CoinMarketCapRepository) (new CoinMarketCapDownloader(coinMarketCapApi));
    }
}

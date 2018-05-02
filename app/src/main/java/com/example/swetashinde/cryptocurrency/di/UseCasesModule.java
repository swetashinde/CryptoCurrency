package com.example.swetashinde.cryptocurrency.di;

import com.example.swetashinde.cryptocurrency.domain.CryptoListInteractor;
import com.example.swetashinde.cryptocurrency.domain.CryptoListUseCases;
import com.example.swetashinde.cryptocurrency.model.CoinMarketCapRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 4/25/18.
 */
@Module
public class UseCasesModule {

    @Provides
    public CryptoListUseCases providesCryptoListUseCases(CoinMarketCapRepository coinMarketCapRepository){
       CryptoListUseCases cryptoListUseCases = new CryptoListInteractor(coinMarketCapRepository);
       return cryptoListUseCases;
    }
}

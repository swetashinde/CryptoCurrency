package com.example.swetashinde.cryptocurrency.domain;

import com.example.swetashinde.cryptocurrency.model.CoinMarketCapRepository;
import com.example.swetashinde.cryptocurrency.model.Crypto;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

/**
 * Created by swetashinde on 4/25/18.
 */

public class CryptoListInteractor implements CryptoListUseCases {

    public static final int LIMIT_CRYPTO_LIST = 20;
    private final CoinMarketCapRepository coinMarketCapRepository;

    public CryptoListInteractor(CoinMarketCapRepository coinMarketCapRepository) {
        this.coinMarketCapRepository = coinMarketCapRepository;
    }


    @Override public Single<List<CryptoViewModel>> getCryptoListBy(int page) {

        return this.coinMarketCapRepository.getCryptoList(page,LIMIT_CRYPTO_LIST).
            map(new Function<List<Crypto>, List<CryptoViewModel>>() {
                @Override public List<CryptoViewModel> apply(List<Crypto> cryptos)
                    throws Exception {
                    List<CryptoViewModel> list2 = new ArrayList<>();
                    for(Crypto c : cryptos){
                       list2.add(new CryptoViewModel(c.getId(),c.getName(),c.getSymbol(),c.getRank(),Float.parseFloat(c.getPriceUsd()),Float.parseFloat(c.getPriceBtc()),Float.parseFloat(c.getPercentChange24h())));
                    }

                    return list2;

                }
            });

    }


}

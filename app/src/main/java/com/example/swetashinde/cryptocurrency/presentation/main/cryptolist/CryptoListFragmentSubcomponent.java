package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {})
public interface CryptoListFragmentSubcomponent extends AndroidInjector<CryptoListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CryptoListFragment> {
    }
}

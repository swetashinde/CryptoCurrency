package com.example.swetashinde.cryptocurrency.presentation.main.di;

import android.app.Activity;
import com.example.swetashinde.cryptocurrency.presentation.main.MainActivity;
import com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListFragmentModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by swetashinde on 4/30/18.
 */
@Subcomponent(
    modules = {CryptoListFragmentModule.class}
)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

}

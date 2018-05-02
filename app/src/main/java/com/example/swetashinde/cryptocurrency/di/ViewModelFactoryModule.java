package com.example.swetashinde.cryptocurrency.di;

import android.arch.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/27/18.
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory daggerViewModelFactory);

}

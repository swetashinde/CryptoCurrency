package com.example.swetashinde.cryptocurrency.di;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListViewModel;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 4/25/18.
 */

@Module
public class ApplicationModule {

    public static final String SCHEDULER_MAIN_THREAD = "mainThread";
    public static final String SCHEDULER_IO = "io";


    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    public Scheduler provideAndroidMainThreadScheduler(){
        Scheduler scheduler = AndroidSchedulers.mainThread();
        return scheduler;
    }

    @Provides
    @Named(SCHEDULER_IO)
    public Scheduler provideIoScheduler(){
        Scheduler scheduler = Schedulers.io();
        return scheduler;
    }

    /*
    @Provides
    ViewModel provideCryptoListViewModel(CryptoListViewModel viewModel) {
        return viewModel;
    }

    @Provides
    ViewModelProvider.Factory provideCryptoListViewModelFactory(DaggerViewModelFactory factory) {
        return factory;
    }*/
}

package com.example.swetashinde.cryptocurrency.di;

import android.app.Application;
import com.example.swetashinde.cryptocurrency.CryptoApplication;
import com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListFragmentModule;
import com.example.swetashinde.cryptocurrency.presentation.main.di.MainActivityModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * Created by swetashinde on 4/25/18.
 */
@Singleton
@Component(modules = {ApplicationModule.class, AndroidSupportInjectionModule.class,MainActivityModule.class,CryptoListFragmentModule.class, NetModule.class, RepositoryModule.class, UseCasesModule.class,ViewModelModule.class})
public interface ApplicationComponent {
    void  inject(CryptoApplication cryptoApplication);
}

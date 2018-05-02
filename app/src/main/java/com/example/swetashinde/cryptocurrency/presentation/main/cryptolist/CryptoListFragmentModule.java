package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;



import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;


/**
 * Created by swetashinde on 4/30/18.
 */
@Module(
    subcomponents = {CryptoListFragmentSubcomponent.class}
)
public abstract class CryptoListFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(CryptoListFragment.class)
    public abstract AndroidInjector.Factory<? extends Fragment> bindCryptoListFragmentInjectorFactory(CryptoListFragmentSubcomponent.Builder var1);

}

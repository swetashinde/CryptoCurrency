package com.example.swetashinde.cryptocurrency.presentation.main.di;

import android.app.Activity;
import com.example.swetashinde.cryptocurrency.presentation.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/30/18.
 */


@Module(subcomponents = {MainActivitySubcomponent.class})
public abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);

}

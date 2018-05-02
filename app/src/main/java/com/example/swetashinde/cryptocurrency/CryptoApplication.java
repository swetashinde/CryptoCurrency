package com.example.swetashinde.cryptocurrency;

import android.app.Activity;
import android.app.Application;
import com.example.swetashinde.cryptocurrency.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by swetashinde on 4/25/18.
 */

public class CryptoApplication extends Application implements HasActivityInjector{
    @Inject DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().build()
            .inject(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}

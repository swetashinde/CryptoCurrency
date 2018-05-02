package com.example.swetashinde.cryptocurrency.presentation.main;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.swetashinde.cryptocurrency.CryptoApplication;
import com.example.swetashinde.cryptocurrency.R;
import com.example.swetashinde.cryptocurrency.di.ApplicationComponent;
import com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListFragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

import static com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListFragment.CRYPTO_LIST_FRAGMENT_TAG;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    private CryptoListFragment cryptoListFragment;

    public MainActivity() {
        this.cryptoListFragment = new CryptoListFragment();
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
       AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, cryptoListFragment, CRYPTO_LIST_FRAGMENT_TAG)
                .commit();
        }
    }

    @Override public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}

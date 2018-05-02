package com.example.swetashinde.cryptocurrency.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.example.swetashinde.cryptocurrency.presentation.main.cryptolist.CryptoListViewModel;
import javax.inject.Inject;

/**
 * Created by swetashinde on 4/25/18.
 */
public class DaggerViewModelFactory implements ViewModelProvider.Factory {

    private CryptoListViewModel mViewModel;

    @Inject
    public DaggerViewModelFactory(CryptoListViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CryptoListViewModel.class)) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}

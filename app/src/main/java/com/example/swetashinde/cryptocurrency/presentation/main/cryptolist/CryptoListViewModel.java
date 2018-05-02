package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.swetashinde.cryptocurrency.domain.CryptoListUseCases;
import com.example.swetashinde.cryptocurrency.domain.CryptoViewModel;
import dagger.android.ContributesAndroidInjector;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

import static com.example.swetashinde.cryptocurrency.di.ApplicationModule.SCHEDULER_IO;
import static com.example.swetashinde.cryptocurrency.di.ApplicationModule.SCHEDULER_MAIN_THREAD;

/**
 * Created by swetashinde on 4/30/18.
 */

public class CryptoListViewModel extends ViewModel {


    public MutableLiveData stateLiveData;
    private CryptoListUseCases cryptoListUseCases;
    private Scheduler subscribeOnScheduler;
    private Scheduler observeOnScheduler;


    @Inject
    public CryptoListViewModel(CryptoListUseCases cryptoListUseCases,
        @Named(SCHEDULER_IO) Scheduler subscribeOnScheduler, @Named(SCHEDULER_MAIN_THREAD) Scheduler observeOnScheduler) {
        this.stateLiveData = new MutableLiveData<CryptoListState>();
        this.cryptoListUseCases = cryptoListUseCases;
        this.subscribeOnScheduler = subscribeOnScheduler;
        this.observeOnScheduler = observeOnScheduler;
        this.stateLiveData.setValue(new DefaultState(0,false,new ArrayList()));
    }

    public final void updateCryptoList() {
        int pageNum = this.obtainCurrentPageNum();
        this.stateLiveData.setValue(pageNum == 0?(CryptoListState)(new LoadingState(pageNum, false, this.obtainCurrentData())):(CryptoListState)(new PaginatingState(pageNum, false, this.obtainCurrentData())));
        this.getCryptoList(pageNum);
    }

    public final void resetCryptoList() {
        int pageNum = 0;
        this.stateLiveData.setValue(new LoadingState(pageNum, false, CollectionsKt.emptyList()));
        this.updateCryptoList();
    }

    public final void restoreCryptoList() {
        int pageNum = this.obtainCurrentPageNum();
        this.stateLiveData.setValue(new DefaultState(pageNum, false, this.obtainCurrentData()));
    }

    private final int obtainCurrentPageNum() {
        CryptoListState state = (CryptoListState)this.stateLiveData.getValue();
        return state != null?state.pageNum():0;
    }

    private void getCryptoList(Integer page) {
            cryptoListUseCases.getCryptoListBy(page)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(cryptoList -> onCryptoListReceived(((List<CryptoViewModel>)cryptoList)),
                throwable -> onError((Throwable)throwable));
    }

    private void onCryptoListReceived(List<CryptoViewModel> cryptoList){
        List currentCryptoList = obtainCurrentData();
        int currentPageNum = this.obtainCurrentPageNum() + 1;
        boolean areAllItemsLoaded = cryptoList.size() < 20;
        currentCryptoList.addAll(cryptoList);
        this.stateLiveData.setValue(new DefaultState(currentPageNum, areAllItemsLoaded, currentCryptoList));
    }

    private void onError(Throwable error) {
        CryptoListState state = (CryptoListState)this.stateLiveData.getValue();

        int pageNum = state != null?state.pageNum():0;
        String errorMessage = error.getMessage();
        if(errorMessage == null) {
            errorMessage = "";
        }
        ErrorState errorState = new ErrorState(errorMessage,pageNum,this.obtainCurrentLoadedAllItems(),this.obtainCurrentData());

        stateLiveData.setValue(errorState);
    }

    private final List obtainCurrentData() {
        CryptoListState state = (CryptoListState)this.stateLiveData.getValue();
        List list;
        if(state != null) {
            list = state.data();
            if(list != null) {
                return list;
            }
        }

        list = new ArrayList();
        return list;
    }

    private final boolean obtainCurrentLoadedAllItems() {
        CryptoListState state = (CryptoListState)this.stateLiveData.getValue();
        return state != null?state.loadedAllItems():false;
    }


}

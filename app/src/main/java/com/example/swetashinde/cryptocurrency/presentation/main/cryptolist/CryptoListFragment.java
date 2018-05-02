package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.swetashinde.cryptocurrency.R;
import com.example.swetashinde.cryptocurrency.presentation.common.CryptoListRecyclerAdapter;
import com.example.swetashinde.cryptocurrency.presentation.widgets.paginatedRecyclerView.PaginationScrollListener;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

import static com.example.swetashinde.cryptocurrency.domain.CryptoListInteractor.LIMIT_CRYPTO_LIST;

/**
 * Created by swetashinde on 4/30/18.
 */

public class CryptoListFragment extends Fragment {


    public static final String CRYPTO_LIST_FRAGMENT_TAG = CryptoListFragment.class.getSimpleName();

    public static final String TAG = CryptoListFragment.class.getSimpleName();

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private CryptoListViewModel viewModel;
    private CryptoListRecyclerAdapter cryptoListAdapter = new CryptoListRecyclerAdapter();
    private boolean isLoading;
    private boolean isLastPage;

    private Observer<CryptoListState> stateObserver = cryptoListState -> {


        if(cryptoListState != null) {
            CryptoListFragment.this.isLastPage = cryptoListState.loadedAllItems();
            SwipeRefreshLayout swipeRefreshLayout =  (SwipeRefreshLayout)getActivity().findViewById(R.id.swipeRefreshLayout);;
            if(cryptoListState instanceof DefaultState) {
                CryptoListFragment.this.isLoading = false;
                swipeRefreshLayout.setRefreshing(false);
                CryptoListFragment.this.getCryptoListAdapter().updateData(cryptoListState.data());
            } else if(cryptoListState instanceof LoadingState) {
                swipeRefreshLayout.setRefreshing(true);
                CryptoListFragment.this.isLoading = true;
            } else if(cryptoListState instanceof PaginatingState) {
                CryptoListFragment.this.isLoading = true;
            } else if(cryptoListState instanceof ErrorState) {
                CryptoListFragment.this.isLoading = false;
                swipeRefreshLayout.setRefreshing(false);
                CryptoListFragment.this.getCryptoListAdapter().removeLoadingViewFooter();
            }
        }




    };

    public ViewModelProvider.Factory getViewModelFactory() {
        return viewModelFactory;
    }

    public CryptoListViewModel getViewModel() {
        return viewModel;
    }

    public CryptoListRecyclerAdapter getCryptoListAdapter() {
        return cryptoListAdapter;
    }



    public CryptoListFragment() {
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CryptoListViewModel.class);
        observeViewModel();
        if(savedInstanceState != null){
            viewModel.restoreCryptoList();
        }else {
            viewModel.updateCryptoList();
        }
    }

    private void observeViewModel() {
        viewModel.stateLiveData.observe(this, stateObserver);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        viewModel.stateLiveData.removeObserver(stateObserver);

    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.crypto_list_fragment, container, false);
        initializeToolbar(view);
        initializeRecyclerView(view);
        initializeSwipeToRefreshView(view);
        return view;
    }

    private void initializeRecyclerView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(getCryptoListAdapter());
        recyclerView.addOnScrollListener(new CryptoListFragment.OnScrollListener(linearLayoutManager));
    }

    private void initializeSwipeToRefreshView(View view) {

        SwipeRefreshLayout swipeRefreshLayout =  view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(() -> viewModel.resetCryptoList());

    }

    private void initializeToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
    }

    @Override public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    private void loadNextPage() {
        cryptoListAdapter.addLoadingViewFooter();
        viewModel.updateCryptoList();
    }

    class OnScrollListener extends PaginationScrollListener {

        public OnScrollListener(LinearLayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override protected void loadMoreItems(){
                CryptoListFragment.this.loadNextPage();
        }

        @Override public int getTotalPageCount() {
            return LIMIT_CRYPTO_LIST;
        }

        @Override public boolean isLastPage() {
            return CryptoListFragment.this.isLastPage;
        }

        @Override public boolean isLoading() {
            return CryptoListFragment.this.isLoading;
        }
    }
}

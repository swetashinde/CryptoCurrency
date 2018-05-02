package com.example.swetashinde.cryptocurrency.presentation.widgets.paginatedRecyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by swetashinde on 4/27/18.
 */

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener{



    private final LinearLayoutManager layoutManager;

    protected abstract void loadMoreItems();

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();

    public PaginationScrollListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if(this.allowLoadMore() && this.isNearToLastItem(this.layoutManager)) {
            this.loadMoreItems();
        }

    }

    private final boolean allowLoadMore() {
        return !this.isLoading() && !this.isLastPage();
    }

    private final boolean isNearToLastItem(LinearLayoutManager layoutManager) {
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        return visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0;
    }


    public final LinearLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

}

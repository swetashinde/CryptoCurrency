package com.example.swetashinde.cryptocurrency.presentation.widgets.paginatedRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.swetashinde.cryptocurrency.R;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/27/18.
 */

public abstract class PaginationAdapter<D> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private boolean isLoadingViewAdded;
    protected List dataList = new ArrayList<D>();
    private static final int LOADING_VIEW_TYPE = 0;
    private static final int ITEM_VIEW_TYPE = 1;

    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int viewType);

    public abstract void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position);

    public abstract void addLoadingViewFooter();

    protected final List getDataList() {
        return this.dataList;
    }

    protected final void setDataList( List var1) {
        this.dataList = var1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch(viewType) {
            case LOADING_VIEW_TYPE:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_loading_footer_item, parent, false);
                viewHolder = (RecyclerView.ViewHolder)(new LoadingViewHolder(view));
                break;
            default:
                viewHolder = this.onCreateItemViewHolder(parent, viewType);
        }

        return viewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(this.getItemViewType(position) != LOADING_VIEW_TYPE) {
            this.onBindItemViewHolder(holder, position);
        }

    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public int getItemViewType(int position) {
        return position == this.dataList.size() - 1 && this.isLoadingViewAdded?LOADING_VIEW_TYPE:ITEM_VIEW_TYPE;
    }

    public final void removeLoadingViewFooter() {
        if(this.isLoadingViewAdded && this.dataList.size() > 0) {
            this.isLoadingViewAdded = false;
            this.dataList.remove(this.dataList.size() - 1);
            this.notifyItemRemoved(this.dataList.size());
        }

    }

    protected final void addLoadingViewFooter(D emptyDataObject) {
        if(this.dataList.size() > 0) {
            this.isLoadingViewAdded = true;
            this.dataList.add(emptyDataObject);
            this.notifyItemInserted(this.dataList.size() - 1);
        }

    }

    public PaginationAdapter() {
        List var2 = (List)(new ArrayList());
        this.dataList = var2;
    }

     public  class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(@NotNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.swetashinde.cryptocurrency.presentation.common;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.swetashinde.cryptocurrency.R;
import com.example.swetashinde.cryptocurrency.common.NumberUtils;
import com.example.swetashinde.cryptocurrency.domain.CryptoViewModel;
import com.example.swetashinde.cryptocurrency.presentation.widgets.paginatedRecyclerView.PaginationAdapter;
import java.util.List;

/**
 * Created by swetashinde on 4/27/18.
 */

public class CryptoListRecyclerAdapter extends PaginationAdapter<CryptoViewModel> {

    private static final int DECIMALS_FIAT = 4;
    private static final int DECIMALS_BTC = 7;
    private static final int DECIMALS_CHANGE = 2;
    private CryptoViewModel  emptyCryptoViewModel = new CryptoViewModel("", "", "", 0, 0f, 0f, 0f);

    @Override
    public CryptoViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crypto_list_item, viewGroup, false);
        return new CryptoViewHolder(view);
    }

    @Override public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof CryptoViewHolder){
            ((CryptoViewHolder)viewHolder).bind((CryptoViewModel)dataList.get(position));
        }
    }

    @Override public void addLoadingViewFooter() {
        addLoadingViewFooter(emptyCryptoViewModel);
    }

    public void updateData(List<CryptoViewModel> newData){
        this.dataList.remove(emptyCryptoViewModel);
        int fromIndex = dataList.size();
        dataList = newData;
        notifyItemRangeInserted(fromIndex,newData.size());

    }

    public class CryptoViewHolder extends RecyclerView.ViewHolder {

        Resources resources;


        public CryptoViewHolder(View itemView) {
            super(itemView);

        }

        public void bind(CryptoViewModel cryptoViewModel){

            TextView rank = itemView.findViewById(R.id.tvPosition);
            rank.setText(String.valueOf(cryptoViewModel.getRank()));

            TextView symbol = itemView.findViewById(R.id.tvSymbol);
            symbol.setText(cryptoViewModel.getSymbol());


            TextView price = itemView.findViewById(R.id.tvPrice);
            price.setText(bindPrice(cryptoViewModel));

            TextView tvChange24h = itemView.findViewById(R.id.tvChange24h);
            tvChange24h.setText(bindChangeText(cryptoViewModel));
            tvChange24h.setTextColor(bindChangeColor(cryptoViewModel));




        }


        public String bindPrice(CryptoViewModel cryptoViewModel){

            if(null != itemView){

                resources = itemView.getContext().getResources();

                if (cryptoViewModel.isBtc())  {
                    return resources.getString(R.string.price_btc, NumberUtils.formatTo(cryptoViewModel.getPriceFiat(), DECIMALS_FIAT));
                }
                else {
                    return resources.getString(R.string.price_alts, NumberUtils.formatTo(cryptoViewModel.getPriceFiat(),DECIMALS_FIAT),  NumberUtils.formatTo(cryptoViewModel.getPriceBtc(),DECIMALS_BTC));
                }
            }

            return null;

        }


        public int bindChangeColor(CryptoViewModel cryptoViewModel){
            if(null != itemView ) {
                return ContextCompat.getColor(itemView.getContext(),
                    (cryptoViewModel.getChange() > 0) ? R.color.change_positive : R.color.change_negative);
            }

            return  R.color.change_negative;


        }


        public String bindChangeText(CryptoViewModel cryptoViewModel){

            if(null != itemView) {
                resources = itemView.getContext().getResources();
                return resources.getString(R.string.change_percent,
                    NumberUtils.formatTo(cryptoViewModel.getChange(), DECIMALS_CHANGE));
            }

            return null;

        }


    }

}

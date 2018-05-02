package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import com.example.swetashinde.cryptocurrency.domain.CryptoViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/30/18.
 */

public class PaginatingState extends CryptoListState {

    private int pageNum;
    private boolean loadedAllItems;
    private List data;

    public PaginatingState(int pageNum, boolean loadedAllItems, List data) {
        this.pageNum = pageNum;
        this.loadedAllItems = loadedAllItems;
        this.data = data;
    }

    @Override public Integer pageNum() {
        return pageNum;
    }

    @Override public Boolean loadedAllItems() {
        return loadedAllItems;
    }

    @Override public List<CryptoViewModel> data() {
        return data;
    }


}

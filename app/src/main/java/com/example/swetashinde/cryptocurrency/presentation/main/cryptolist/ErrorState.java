package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import com.example.swetashinde.cryptocurrency.domain.CryptoViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/30/18.
 */

public class ErrorState extends CryptoListState {

    private String errorMessage;
    private int pageNum;
    private boolean loadedAllItems;
    private List data;

    public ErrorState(String errorMessage, int pageNum, boolean loadedAllItems, List data) {
        this.errorMessage = errorMessage;
        this.pageNum = pageNum;
        this.loadedAllItems = loadedAllItems;
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
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

package com.example.swetashinde.cryptocurrency.presentation.main.cryptolist;

import com.example.swetashinde.cryptocurrency.domain.CryptoViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/30/18.
 */

public abstract class CryptoListState {

public abstract Integer pageNum();
public abstract Boolean loadedAllItems();
public abstract List<CryptoViewModel> data();



}

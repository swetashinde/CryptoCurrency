package com.example.swetashinde.cryptocurrency.domain;

import android.os.Parcel;
import android.os.Parcelable;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/25/18.
 */

public interface CryptoListUseCases {
    Single getCryptoListBy(int page);
}




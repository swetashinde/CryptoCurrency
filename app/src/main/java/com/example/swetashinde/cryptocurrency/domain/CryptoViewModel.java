package com.example.swetashinde.cryptocurrency.domain;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;

/**
 * Created by swetashinde on 4/25/18.
 */

public class CryptoViewModel implements Parcelable
{
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final String symbol;
    private final int rank;
    private final float priceFiat;
    private final float priceBtc;
    private final float change;

    public CryptoViewModel() {
        this("", "", "", 0, 0.0F, 0.0F, 0.0F);
    }

    public CryptoViewModel(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(),parcel.readString(), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
    }


    public CryptoViewModel(@NotNull String id, @NotNull String name, @NotNull String symbol,
        int rank, float priceFiat, float priceBtc, float change) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceFiat = priceFiat;
        this.priceBtc = priceBtc;
        this.change = change;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.symbol);
        parcel.writeInt(this.rank);
        parcel.writeFloat(this.priceFiat);
        parcel.writeFloat(this.priceBtc);
        parcel.writeFloat(this.change);

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CryptoViewModel createFromParcel(Parcel in) {
            return new CryptoViewModel(in);
        }

        public CryptoViewModel[] newArray(int size) {
            return new CryptoViewModel[size];
        }
    };

    @NotNull public String getId() {
        return id;
    }

    @NotNull public String getName() {
        return name;
    }

    @NotNull public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public float getPriceFiat() {
        return priceFiat;
    }

    public float getPriceBtc() {
        return priceBtc;
    }

    public float getChange() {
        return change;
    }

    public boolean isBtc(){
        return symbol.equals("BTC");
    }
}
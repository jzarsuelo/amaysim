package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class Product {

    private String mName;

    private long mIncludedData;

    private long mIncludedCredit;

    private long mIncludedInternationalTalk;

    private boolean mUnliText;

    private boolean mUnliTalk;

    private boolean mUnliInternationalText;

    private boolean mUnliInternationalTalk;

    private long mPrice;

    public Product() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getIncludedData() {
        return mIncludedData;
    }

    public void setIncludedData(long includedData) {
        mIncludedData = includedData;
    }

    public long getIncludedCredit() {
        return mIncludedCredit;
    }

    public void setIncludedCredit(long includedCredit) {
        mIncludedCredit = includedCredit;
    }

    public long getIncludedInternationalTalk() {
        return mIncludedInternationalTalk;
    }

    public void setIncludedInternationalTalk(long includedInternationalTalk) {
        mIncludedInternationalTalk = includedInternationalTalk;
    }

    public boolean isUnliText() {
        return mUnliText;
    }

    public void setUnliText(boolean unliText) {
        mUnliText = unliText;
    }

    public boolean isUnliTalk() {
        return mUnliTalk;
    }

    public void setUnliTalk(boolean unliTalk) {
        mUnliTalk = unliTalk;
    }

    public boolean isUnliInternationalText() {
        return mUnliInternationalText;
    }

    public void setUnliInternationalText(boolean unliInternationalText) {
        mUnliInternationalText = unliInternationalText;
    }

    public boolean isUnliInternationalTalk() {
        return mUnliInternationalTalk;
    }

    public void setUnliInternationalTalk(boolean unliInternationalTalk) {
        mUnliInternationalTalk = unliInternationalTalk;
    }

    public long getPrice() {
        return mPrice;
    }

    public void setPrice(long price) {
        mPrice = price;
    }
}

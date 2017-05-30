package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class Subscription {

    private long mDataBalance;

    private long mCreditBalance;

    private long mRolloverCreditBalance;

    private long mRolloverTalkBalance;

    private String mExpiratyDate;

    private boolean mAutoRenew;

    public Subscription() {
    }

    public long getDataBalance() {
        return mDataBalance;
    }

    public void setDataBalance(long dataBalance) {
        mDataBalance = dataBalance;
    }

    public long getCreditBalance() {
        return mCreditBalance;
    }

    public void setCreditBalance(long creditBalance) {
        mCreditBalance = creditBalance;
    }

    public long getRolloverCreditBalance() {
        return mRolloverCreditBalance;
    }

    public void setRolloverCreditBalance(long rolloverCreditBalance) {
        mRolloverCreditBalance = rolloverCreditBalance;
    }

    public long getRolloverTalkBalance() {
        return mRolloverTalkBalance;
    }

    public void setRolloverTalkBalance(long rolloverTalkBalance) {
        mRolloverTalkBalance = rolloverTalkBalance;
    }

    public String getExpiratyDate() {
        return mExpiratyDate;
    }

    public void setExpiratyDate(String expiratyDate) {
        mExpiratyDate = expiratyDate;
    }

    public boolean isAutoRenew() {
        return mAutoRenew;
    }

    public void setAutoRenew(boolean autoRenew) {
        mAutoRenew = autoRenew;
    }
}

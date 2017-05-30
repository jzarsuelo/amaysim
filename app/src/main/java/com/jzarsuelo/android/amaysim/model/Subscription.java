package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class Subscription {

    private long mDataBalance;

    private long mCreditBalance;

    private long mRolloverCreditBalance;

    private long mRolloverDataBalance;

    private long mRolloverTalkBalance;

    private String mExpiryDate;

    private boolean mAutoRenew;

    private long mInternationalTalkBalance;

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

    public long getRolloverDataBalance() {
        return mRolloverDataBalance;
    }

    public void setRolloverDataBalance(long rolloverDataBalance) {
        mRolloverDataBalance = rolloverDataBalance;
    }

    public long getRolloverTalkBalance() {
        return mRolloverTalkBalance;
    }

    public void setRolloverTalkBalance(long rolloverTalkBalance) {
        mRolloverTalkBalance = rolloverTalkBalance;
    }

    public String getExpiryDate() {
        return mExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        mExpiryDate = expiryDate;
    }

    public boolean isAutoRenew() {
        return mAutoRenew;
    }

    public void setAutoRenew(boolean autoRenew) {
        mAutoRenew = autoRenew;
    }

    public long getInternationalTalkBalance() {
        return mInternationalTalkBalance;
    }

    public void setInternationalTalkBalance(long internationalTalkBalance) {
        mInternationalTalkBalance = internationalTalkBalance;
    }
}

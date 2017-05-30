package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class Service {

    private String mMsn;

    private double mCredit;

    private String mCreditExpiry;

    private boolean mDataUsageThreshold;

    public Service() {
    }

    public String getMsn() {
        return mMsn;
    }

    public void setMsn(String msn) {
        mMsn = msn;
    }

    public double getCredit() {
        return mCredit;
    }

    public void setCredit(double credit) {
        mCredit = credit;
    }

    public String getCreditExpiry() {
        return mCreditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        mCreditExpiry = creditExpiry;
    }

    public boolean isDataUsageThreshold() {
        return mDataUsageThreshold;
    }

    public void setDataUsageThreshold(boolean dataUsageThreshold) {
        mDataUsageThreshold = dataUsageThreshold;
    }
}

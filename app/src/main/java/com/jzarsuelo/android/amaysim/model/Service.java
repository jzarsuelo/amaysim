package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class Service {

    private String mMsn;

    private float mCredit;

    private String mCreditExpiry;

    public Service() {
    }

    public String getMsn() {
        return mMsn;
    }

    public void setMsn(String msn) {
        mMsn = msn;
    }

    public float getCredit() {
        return mCredit;
    }

    public void setCredit(float credit) {
        mCredit = credit;
    }

    public String getCreditExpiry() {
        return mCreditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        mCreditExpiry = creditExpiry;
    }
}

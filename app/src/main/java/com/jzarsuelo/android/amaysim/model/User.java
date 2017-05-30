package com.jzarsuelo.android.amaysim.model;

/**
 * Created by Pao on 30/5/17.
 */

public class User {

    private String mPaymentType;

    private String mNextBillingDate;

    private String mUnbilledCharges;

    private String mTitle;

    private String mFirstName;

    private String mLastName;

    private String mDateOfBirth;

    private String mContactNumber;

    private String mEmailAddress;

    private boolean mEmailVerified;

    private Service mService;

    private Subscription mSubscription;

    private Product mProduct;

    public String getPaymentType() {
        return mPaymentType;
    }

    public void setPaymentType(String paymentType) {
        mPaymentType = paymentType;
    }

    public String getNextBillingDate() {
        return mNextBillingDate;
    }

    public void setNextBillingDate(String nextBillingDate) {
        mNextBillingDate = nextBillingDate;
    }

    public String getUnbilledCharges() {
        return mUnbilledCharges;
    }

    public void setUnbilledCharges(String unbilledCharges) {
        mUnbilledCharges = unbilledCharges;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        mContactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return mEmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        mEmailAddress = emailAddress;
    }

    public boolean isEmailVerified() {
        return mEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        mEmailVerified = emailVerified;
    }

    public Service getService() {
        return mService;
    }

    public void setService(Service service) {
        mService = service;
    }

    public Subscription getSubscription() {
        return mSubscription;
    }

    public void setSubscription(Subscription subscription) {
        mSubscription = subscription;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }

}

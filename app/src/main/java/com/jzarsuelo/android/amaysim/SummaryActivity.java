package com.jzarsuelo.android.amaysim;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jzarsuelo.android.amaysim.loader.UserDataLoader;
import com.jzarsuelo.android.amaysim.model.Product;
import com.jzarsuelo.android.amaysim.model.Subscription;
import com.jzarsuelo.android.amaysim.model.User;
import com.jzarsuelo.android.amaysim.util.FormatTextUtil;

public class SummaryActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<User>{

    private static final int USER_LOADER_ID = 1;
    private static final String LOG_TAG = SummaryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        setTitle(getString(R.string.account_summary));

        getLoaderManager().initLoader(USER_LOADER_ID, null, this);
    }

    @Override
    public Loader<User> onCreateLoader(int id, Bundle args) {
        return new UserDataLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<User> loader, User data) {
        populateAccountInfoView(data);
        populateSubscriptionView(data);
        populateProductView(data);
    }

    @Override
    public void onLoaderReset(Loader<User> loader) {

    }

    private void populateSubscriptionView(User data) {
        Subscription subscription = data.getSubscription();

        String dataBalance = FormatTextUtil.convertToGb(subscription.getDataBalance());
        dataBalance = String.format(getString(R.string.subscription_data_balance), dataBalance);
        TextView tvDataBalance = (TextView) findViewById(R.id.tv_data_balance);
        tvDataBalance.setText(dataBalance);

        String creditBalance = FormatTextUtil.covertToDollar(subscription.getCreditBalance());
        creditBalance = String.format(
                getString(R.string.subscription_credit_balance),
                creditBalance);
        TextView tvCreditBalance = (TextView) findViewById(R.id.tv_credit_balance);
        tvCreditBalance.setText(creditBalance);

        String rolloverCreditBalance = FormatTextUtil.covertToDollar(subscription.getRolloverCreditBalance());
        rolloverCreditBalance = String.format(
                getString(R.string.subscription_rollover_credit_balance),
                rolloverCreditBalance);
        TextView tvRolloverCreditBalance = (TextView) findViewById(R.id.tv_rollover_credit_balance);
        tvRolloverCreditBalance.setText(rolloverCreditBalance);

        String rolloverDataBalance = FormatTextUtil.convertToGb(subscription.getRolloverCreditBalance());
        rolloverDataBalance = String.format(
                getString(R.string.subscription_rollover_data_balance),
                rolloverDataBalance);
        TextView tvRolloverDataBalance = (TextView) findViewById(R.id.tv_rollover_data_balance);
        tvRolloverDataBalance.setText(rolloverDataBalance);

        String internationalTalkBalance = String.format(
                getString(R.string.subscription_international_talk_balance),
                String.valueOf(subscription.getRolloverCreditBalance()));
        TextView tvInternationalTalkBalance = (TextView) findViewById(R.id.tv_international_talk_balance);
        tvInternationalTalkBalance.setText(internationalTalkBalance);

        String expiryDate = String.format(
                getString(R.string.subscription_expiry_date),
                subscription.getExpiryDate());
        TextView tvExpiryDate = (TextView) findViewById(R.id.tv_expiry_date);
        tvExpiryDate.setText( expiryDate );

        String autoRenew = String.format(
                getString(R.string.subscription_auto_renewal),
                FormatTextUtil.getUserFriendlyBoolean( subscription.isAutoRenew() ));
        TextView tvAutoRenewal = (TextView) findViewById(R.id.tv_auto_renewal);
        tvAutoRenewal.setText( autoRenew );

        String primarySubscription = String.format(
                getString(R.string.primary_subscription),
                FormatTextUtil.getUserFriendlyBoolean( subscription.isAutoRenew() ));
        TextView tvPrimarySubscription = (TextView) findViewById(R.id.tv_primary_subscription);
        tvPrimarySubscription.setText( primarySubscription );

    }

    private void populateProductView(User userData) {
        Product product = userData.getProduct();

        TextView tvName = (TextView) findViewById(R.id.tv_product_name);
        tvName.setText( product.getName() );


        TextView tvData = (TextView) findViewById(R.id.tv_data);
        long data = product.getIncludedData();
        if ( data == 0) {

            tvData.setVisibility(View.GONE );

        } else {

            String strData = String.format(getString(R.string.product_data), String.valueOf(data));
            tvData.setText(strData);
        }


        TextView tvCredit = (TextView) findViewById(R.id.tv_credit);
        long credit = product.getIncludedCredit();
        if (credit == 0) {

            tvCredit.setVisibility(View.GONE );

        } else {

            String strCredit = FormatTextUtil.covertToDollar(credit);
            strCredit = String.format(getString(R.string.product_credit), strCredit);
            tvCredit.setText(strCredit);
        }


        TextView tvInternationalTalk = (TextView) findViewById(R.id.tv_international_talk);
        long internationalTalk = product.getIncludedInternationalTalk();
        if (internationalTalk == 0) {

            tvInternationalTalk.setVisibility(View.GONE);

        } else {

            String strInternationalTalk = String.format(
                    getString(R.string.product_international_talk),
                    String.valueOf(internationalTalk));

            tvInternationalTalk.setText( strInternationalTalk );
        }


        String unlimitedText = FormatTextUtil.getUserFriendlyBoolean( product.isUnliText() );
        unlimitedText = String.format(getString(R.string.product_unlimited_text), unlimitedText);
        TextView tvUnlimitedText = (TextView) findViewById(R.id.tv_unlimited_text);
        tvUnlimitedText.setText(unlimitedText);


        String unlimitedTalk = FormatTextUtil.getUserFriendlyBoolean( product.isUnliTalk() );
        unlimitedTalk = String.format(getString(R.string.product_unlimited_talk), unlimitedTalk);
        TextView tvUnlimitedTalk = (TextView) findViewById(R.id.tv_unlimited_talk);
        tvUnlimitedTalk.setText(unlimitedTalk);


        String unliIntlText = FormatTextUtil.getUserFriendlyBoolean( product.isUnliInternationalText() );
        unliIntlText = String.format( getString(R.string.product_unlimited_international_text),
                unliIntlText);
        TextView tvUnliIntlText = (TextView) findViewById(R.id.tv_unlimited_international_text);
        tvUnliIntlText.setText(unliIntlText);


        String unliIntlTalk = FormatTextUtil.getUserFriendlyBoolean( product.isUnliInternationalTalk() );
        unliIntlTalk = String.format( getString(R.string.product_unlimited_international_talk),
                unliIntlTalk);
        TextView tvUnliIntlTalk = (TextView) findViewById(R.id.tv_unlimited_international_talk);
        tvUnliIntlTalk.setText(unliIntlTalk);

        String price = FormatTextUtil.covertToDollar( product.getPrice() );
        price = String.format( getString(R.string.product_price), price);
        TextView tvPrice = (TextView) findViewById(R.id.tv_price);
        tvPrice.setText(price);
    }

    private void populateAccountInfoView(User user) {

        String name = user.getLastName() + ", " + user.getFirstName();
        name = String.format(getString(R.string.acct_name), name);

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(name);



        String paymentType = user.getPaymentType();
        paymentType = String.format(getString(R.string.acct_payment_type), paymentType);

        TextView tvPaymentType = (TextView) findViewById(R.id.tv_payment_type);
        tvPaymentType.setText(paymentType);



        String unbilledCharges = FormatTextUtil.covertToDollar( user.getUnbilledCharges() );
        unbilledCharges = String.format(getString(R.string.acct_unbilled_charges), unbilledCharges);

        TextView tvUnbilledCharges = (TextView) findViewById(R.id.tv_unbilled_charges);
        tvUnbilledCharges.setText(unbilledCharges);



        String nextBillingDate = user.getNextBillingDate();
        TextView tvNextBillingDate = (TextView) findViewById(R.id.tv_next_billing_date);

        if ( nextBillingDate == null ) {

            tvNextBillingDate.setVisibility(View.GONE);

        } else {

            nextBillingDate = String.format( getString(R.string.acct_next_billing_date), nextBillingDate );
            tvNextBillingDate.setText(nextBillingDate);
        }



        String contactNo = user.getContactNumber();
        contactNo = String.format(getString(R.string.acct_contact_no), contactNo);

        TextView tvContactNo = (TextView) findViewById(R.id.tv_contact_no);
        tvContactNo.setText(contactNo);


        String email = user.getEmailAddress();
        email = String.format(getString(R.string.acct_email_address), email);

        TextView tvEmail = (TextView) findViewById(R.id.tv_email_address);
        tvEmail.setText(email);
    }
}

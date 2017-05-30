package com.jzarsuelo.android.amaysim;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jzarsuelo.android.amaysim.loader.UserDataLoader;
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
        populateSubscription(data);
    }

    @Override
    public void onLoaderReset(Loader<User> loader) {

    }

    private void populateSubscription(User data) {
        Subscription subscription = data.getSubscription();

        String dataBalance = FormatTextUtil.convertToGb(subscription.getDataBalance());
        dataBalance = String.format(getString(R.string.subscription_data_balance), dataBalance);
        TextView tvDataBalance = (TextView) findViewById(R.id.tv_data_balance);
        tvDataBalance.setText(dataBalance);

        String creditBalance = FormatTextUtil.covertToDollar(subscription.getCreditBalance());
        creditBalance = String.format(
                getString(R.string.subscription_credit_balance), creditBalance);
        TextView tvCreditBalance = (TextView) findViewById(R.id.tv_credit_balance);
        tvCreditBalance.setText(creditBalance);

        String rolloverCreditBalance = FormatTextUtil.covertToDollar(subscription.getRolloverCreditBalance());
        rolloverCreditBalance = String.format(
                getString(R.string.subscription_rollover_credit_balance), rolloverCreditBalance);
        TextView tvRolloverCreditBalance = (TextView) findViewById(R.id.tv_rollover_credit_balance);
        tvRolloverCreditBalance.setText(rolloverCreditBalance);

        String rolloverDataBalance = FormatTextUtil.convertToGb(subscription.getRolloverCreditBalance());
        rolloverDataBalance = String.format(
                getString(R.string.subscription_rollover_data_balance), rolloverDataBalance);
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
}

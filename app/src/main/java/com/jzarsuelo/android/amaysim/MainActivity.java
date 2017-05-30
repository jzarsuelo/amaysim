package com.jzarsuelo.android.amaysim;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.jzarsuelo.android.amaysim.loader.AuthLoader;
import com.jzarsuelo.android.amaysim.util.ConnectivityUtil;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Boolean> {

    private static final int AUTH_LOADER_ID = 0;

    private TextInputEditText mEditMsn;

    private TextInputEditText mEditPassword;

    private AppCompatButton mButtonLogin;

    private RelativeLayout mLayoutProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mEditMsn = (TextInputEditText) findViewById(R.id.tiet_msn);
        mEditPassword = (TextInputEditText) findViewById(R.id.tiet_password);
        mButtonLogin = (AppCompatButton) findViewById(R.id.button_login);
        mLayoutProgress = (RelativeLayout) findViewById(R.id.layout_progress);
    }

    protected void onLogin(View v) {

        if ( ConnectivityUtil.isConnected(this) ) {
            getLoaderManager().restartLoader(AUTH_LOADER_ID, null, this)
                    .forceLoad();
        } else {
            showNoNetworkError();
        }


    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        toggleProgressVisibility(true);

        return new AuthLoader(this,
                mEditMsn.getText().toString(),
                mEditPassword.getText().toString());
    }

    @Override
    public void onLoadFinished(Loader loader, Boolean isLoginSuccessful) {

        if (isLoginSuccessful) {

            Intent i = new Intent(this, SummaryActivity.class);
            startActivity(i);

        } else {

            toggleProgressVisibility(false);
            showInvalidCredential();

        }
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    private void toggleProgressVisibility(boolean isVisible) {
        final int progressBarVisibility = isVisible ? View.VISIBLE : View.GONE;
        final int formVisibility = isVisible ? View.GONE : View.VISIBLE;

        mLayoutProgress.setVisibility(progressBarVisibility);

        mEditMsn.setVisibility(formVisibility);
        mEditPassword.setVisibility(formVisibility);
        mButtonLogin.setVisibility(formVisibility);
    }

    private void showInvalidCredential() {
        Snackbar.make(mLayoutProgress, R.string.failed_login, Snackbar.LENGTH_LONG).show();
    }

    private void showNoNetworkError() {
        Snackbar.make(mLayoutProgress, R.string.error_no_connection, Snackbar.LENGTH_LONG).show();
    }
}

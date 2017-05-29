package com.jzarsuelo.android.amaysim.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.jzarsuelo.android.amaysim.util.AuthUtil;

/**
 * Created by Pao on 29/5/17.
 */

public class AuthLoader extends AsyncTaskLoader<Boolean> {

    private String mMsn;

    private String mPassword;

    public AuthLoader(Context context, String msn, String password) {
        super(context);
        mMsn = msn;
        mPassword = password;
    }

    @Override
    public Boolean loadInBackground() {
        Log.d(AuthLoader.class.getSimpleName(), "sdfsadf " + mMsn);
        return AuthUtil.auth(mMsn, mPassword);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

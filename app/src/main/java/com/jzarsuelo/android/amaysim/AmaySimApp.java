package com.jzarsuelo.android.amaysim;

import android.app.Application;
import android.content.Context;

/**
 * Created by Pao on 29/5/17.
 */

public class AmaySimApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        if (sContext == null) {
            sContext = this;
        }
    }

    public static Context getContext() {
        return sContext;
    }
}

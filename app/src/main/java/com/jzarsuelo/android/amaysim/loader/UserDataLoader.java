package com.jzarsuelo.android.amaysim.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.jzarsuelo.android.amaysim.model.User;
import com.jzarsuelo.android.amaysim.util.AuthUtil;
import com.jzarsuelo.android.amaysim.util.DataSourceUtil;
import com.jzarsuelo.android.amaysim.util.JsonParserUtil;

import org.json.JSONObject;

/**
 * Created by Pao on 29/5/17.
 */

public class UserDataLoader extends AsyncTaskLoader<User> {

    public UserDataLoader(Context context) {
        super(context);
    }

    @Override
    public User loadInBackground() {
        JSONObject jsonResponse = DataSourceUtil.loadData();

        User user = JsonParserUtil.parse(jsonResponse);
        return user;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

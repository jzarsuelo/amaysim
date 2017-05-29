package com.jzarsuelo.android.amaysim.util;

import android.util.Log;

import com.jzarsuelo.android.amaysim.AmaySimApp;
import com.jzarsuelo.android.amaysim.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility class for loading the data source fomr the API
 */
public class DataSourceUtil {

    private final static String LOG_TAG = DataSourceUtil.class.getSimpleName();

    private final static String API_URL;

    /**
     * Cached data from the API
     */
    private static JSONObject sData;

    static {
        API_URL = AmaySimApp.getContext().getString(R.string.api_url);
    }

    private DataSourceUtil() {}

    /**
     * Load the data from the API
     * @param isForceLoad true, execute HTTP Request to the API. Otherwise false, return the cached data
     * @return
     */
    public static JSONObject loadData(boolean isForceLoad) {
        if (sData != null && !isForceLoad) {
            return sData;
        }

        URL url = createUrl();

        String stringResponse = executeHttpRequest(url);
        try {
            sData = new JSONObject(stringResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sData;
    }

    public static JSONObject loadData() {
        return loadData(false);
    }

    private static URL createUrl() {
        URL url = null;
        try {
             url = new URL(API_URL);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Invalid API_URL format.\n" + Log.getStackTraceString(e));
        }

        return url;
    }

    private static String executeHttpRequest(URL url) {
        String stringResponse = null;

        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(30000);

            connection.connect();

            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();

                stringResponse = readInputStream(inputStream);
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Running executeHttpRequest(URL) failed.\n" + Log.getStackTraceString(e));
        }

        return stringResponse;
    }

    private static String readInputStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = bufferedReader.readLine();
            while(line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }
        return stringBuilder.toString();
    }

}

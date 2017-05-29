package com.jzarsuelo.android.amaysim.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility class for validating the user credentials
 */
public class AuthUtil {
    private AuthUtil() {}

    public static boolean auth(String msn, String password) {
        JSONObject jsonData = DataSourceUtil.loadData();
        return validateUser(msn, password, jsonData);
    }

    private static boolean validateUser(String msn, String password, JSONObject jsonData) {
        try {
            JSONArray jsonIncluded = jsonData.getJSONArray("included");

            // parse JSON data
            for (int i = 0; i < jsonIncluded.length(); i++) {

                JSONObject jsonIncludedObj = jsonIncluded.getJSONObject(i);
                if (jsonIncludedObj.getString("type").equals("services")) {

                    JSONObject jsonAttr = jsonIncludedObj.getJSONObject("attributes");
                    String dataMsn = jsonAttr.getString("msn");
                    // password is not used

                    if (msn.equals(dataMsn)) {
                        return true;
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}

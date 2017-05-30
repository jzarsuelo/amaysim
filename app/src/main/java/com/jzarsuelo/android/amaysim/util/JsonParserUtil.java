package com.jzarsuelo.android.amaysim.util;

import android.util.Log;

import com.jzarsuelo.android.amaysim.model.Product;
import com.jzarsuelo.android.amaysim.model.Service;
import com.jzarsuelo.android.amaysim.model.Subscription;
import com.jzarsuelo.android.amaysim.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility class for parsing {@link User} data from JSON
 */
public class JsonParserUtil {

    private static final String LOG_TAG = JsonParserUtil.class.getSimpleName();

    private JsonParserUtil() {
    }

    /**
     * Read {@link User} data from JSON
     */
    public static User parse(JSONObject jsonRoot) {
        User user = new User();

        try {
            parseUserData(user, jsonRoot);
            parseServiceData(user, jsonRoot);
            parseSubscription(user, jsonRoot);
            parseProduct(user, jsonRoot);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem in parsing User data from JSON.\n"
                    + Log.getStackTraceString(e));
        }

        return user;
    }

    private static void parseUserData(User user, JSONObject jsonRoot) throws JSONException {
        JSONObject jsonData = jsonRoot.getJSONObject("data");
        JSONObject jsonAttr = jsonData.getJSONObject("attributes");

        user.setPaymentType( jsonAttr.getString("payment-type") );
        user.setUnbilledCharges( jsonAttr.optString("unbilled-charges") );
        user.setNextBillingDate( jsonAttr.optString("next-billing-date") );
        user.setTitle( jsonAttr.getString("title") );
        user.setFirstName( jsonAttr.getString("first-name") );
        user.setLastName( jsonAttr.getString("last-name") );
        user.setDateOfBirth( jsonAttr.getString("date-of-birth") );
        user.setContactNumber( jsonAttr.getString("contact-number") );
        user.setEmailAddress( jsonAttr.getString("email-address") );
        user.setEmailVerified( jsonAttr.getBoolean("email-address-verified") );
    }

    private static void parseServiceData(User user, JSONObject jsonRoot) throws JSONException {
        JSONObject jsonData = getDataFromIncluded(jsonRoot, "services");
        JSONObject jsonAttr = jsonData.getJSONObject("attributes");

        Service service = new Service();
        service.setMsn( jsonAttr.getString("msn") );
        service.setCredit( jsonAttr.getDouble("credit") );
        service.setCreditExpiry( jsonAttr.getString("credit-expiry") );
        service.setDataUsageThreshold( jsonAttr.getBoolean("data-usage-threshold") );

        user.setService( service );
    }

    private static void parseSubscription(User user, JSONObject jsonRoot) throws JSONException {
        JSONObject jsonData = getDataFromIncluded(jsonRoot, "subscriptions");
        JSONObject jsonAttr = jsonData.getJSONObject("attributes");

        Subscription subscription = new Subscription();
        subscription.setDataBalance( jsonAttr.optLong("included-data-balance") );
        subscription.setCreditBalance( jsonAttr.optLong("included-credit-balance") );
        subscription.setRolloverCreditBalance( jsonAttr.optLong("included-rollover-credit-balance") );
        subscription.setRolloverDataBalance( jsonAttr.optLong("included-rollover-data-balance") );
        subscription.setInternationalTalkBalance( jsonAttr.optLong("included-international-talk-balance", 0) );
        subscription.setExpiryDate( jsonAttr.optString("expiry-date") );
        subscription.setAutoRenew( jsonAttr.getBoolean("auto-renewal") );

        user.setSubscription(subscription);

    }

    private static void parseProduct(User user, JSONObject jsonRoot) throws JSONException {
        JSONObject jsonData = getDataFromIncluded(jsonRoot, "products");
        JSONObject jsonAttr = jsonData.getJSONObject("attributes");

        Product product = new Product();
        product.setName( jsonAttr.optString("name") );
        product.setIncludedData( jsonAttr.optLong("included-data") );
        product.setIncludedInternationalTalk( jsonAttr.optLong("included-international-talk") );
        product.setUnliText( jsonAttr.getBoolean("unlimited-text") );
        product.setUnliTalk( jsonAttr.getBoolean("unlimited-talk") );
        product.setUnliInternationalText( jsonAttr.getBoolean("unlimited-international-text") );
        product.setUnliInternationalTalk( jsonAttr.getBoolean("unlimited-international-talk") );
        product.setPrice( jsonAttr.optLong("price") );

        user.setProduct(product);
    }


    /**
     * Helper method to get the {@link JSONObject} inside <code>included</code> {@link JSONArray}
     */
    private static JSONObject getDataFromIncluded(JSONObject jsonRoot, String findDataType)
            throws JSONException {
        JSONArray jsonIncluded = jsonRoot.getJSONArray("included");

        for (int i = 0; i < jsonIncluded.length(); i++) {
            JSONObject jsonData = jsonIncluded.getJSONObject(i);

            String type = jsonData.getString("type");
            if ( type.equals(findDataType) ) {
                return jsonData;
            }
        }

        return null;
    }

}

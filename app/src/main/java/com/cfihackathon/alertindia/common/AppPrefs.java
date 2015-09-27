package com.cfihackathon.alertindia.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by someshk on 9/27/15.
 */
public class AppPrefs {
    private static final String PREF_USER_SIGNED_IN = "user_sign_in";

    public static boolean getUserSignInStatus (final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_USER_SIGNED_IN, false);
    }

    public static void setUserSignInStatus (final Context context, boolean status) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_USER_SIGNED_IN, status).apply();
    }

}

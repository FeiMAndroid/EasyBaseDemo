package com.feim.easybaselib.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@link EasyPreferencesUtil} is a utility that is used to manage the preferences.
 */
public class EasyPreferencesUtil {

    private static SharedPreferences mSharedPreferences;

    /**
     * Initial the instance of the preferences manager.
     */
    private static void init() {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ActivityStackManager.getInstance().getTopActivity());
        }
    }

    /**
     * Put a String value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putString(String key, String value) {
        init();
        Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Retrieval a String value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static String getString(String key, String defValue) {
        init();
        return mSharedPreferences.getString(key, defValue);
    }

    /**
     * Retrieval a String value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static String getString(String key) {
        return getString(key, "");
    }

    /**
     * Put a set of String values in the preferences editor.
     *
     * @param key    The name of the preference to modify.
     * @param values The set of new values for the preference.
     */
    public static void putStringSet(String key, Set<String> values) {
        init();

        Editor editor = mSharedPreferences.edit();
        editor.putStringSet(key, values);
        editor.apply();
    }

    /**
     * Retrieval a set of String values from the preferences.
     *
     * @param key       The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static Set<String> getStringSet(String key, Set<String> defValues) {
        init();
        return mSharedPreferences.getStringSet(key, defValues);
    }

    /**
     * Retrieval a set of String values from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static Set<String> getStringSet(String key) {
        return getStringSet(key, new HashSet<String>());
    }

    /**
     * Put an int value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putInt(String key, int value) {
        init();

        Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }


    /**
     * Retrieval an int value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static int getInt(String key, int defValue) {
        init();
        return mSharedPreferences.getInt(key, defValue);
    }

    /**
     * Retrieval an int value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * Put a float value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putFloat(String key, float value) {
        init();

        Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Retrieval a float value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static float getFloat(String key, float defValue) {
        init();
        return mSharedPreferences.getFloat(key, defValue);
    }

    /**
     * Retrieval a float value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static float getFloat(String key) {
        return getFloat(key, 0);
    }

    /**
     * Put a long value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putLong(String key, long value) {
        init();

        Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Retrieval a long value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static long getLong(String key, long defValue) {
        init();
        return mSharedPreferences.getLong(key, defValue);
    }

    /**
     * Retrieval a long value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static long getLong(String key) {
        return getLong(key, 0);
    }

    /**
     * Put a boolean value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putBoolean(String key, boolean value) {
        init();

        Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Retrieval a boolean value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static boolean getBoolean(String key, boolean defValue) {
        init();
        return mSharedPreferences.getBoolean(key, defValue);
    }

    /**
     * Retrieval a boolean value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * Remove a preference from the preferences editor.
     *
     * @param key The name of the preference to remove.
     */
    public static void remove(String key) {
        init();
        mSharedPreferences.edit().remove(key).apply();
    }

    /**
     * Remove all values from the preferences editor.
     */
    public static void clear() {
        init();
        mSharedPreferences.edit().clear().apply();
    }

    /**
     * Registers a callback to be invoked when a change happens to a preference.
     *
     * @param listener The callback that will run.
     */
    public static void registerOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        init();
        mSharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    /**
     * Unregisters a previous callback.
     *
     * @param listener The callback that should be unregistered.
     */
    public static void unregisterOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        init();
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

}

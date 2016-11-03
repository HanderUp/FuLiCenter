package cn.ucai.fulicenter.dao;


import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefrenceUtils {
    private static final String SHARE_NAEM="saveUserInfo";
    private static SharePrefrenceUtils intance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String SHARE_KEY_USER_NAME = "share_key_user_name";

    public SharePrefrenceUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARE_NAEM, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static SharePrefrenceUtils getInstance(Context context) {
        if (intance == null) {
            intance = new SharePrefrenceUtils(context);
        }
        return intance;
    }

    public void saveUser(String username) {
        mEditor.putString(SHARE_KEY_USER_NAME, username);
        mEditor.commit();
    }

    public String getUser() {
        return mSharedPreferences.getString(SHARE_KEY_USER_NAME, null);
    }

    public void removeUser() {
        mEditor.remove(SHARE_KEY_USER_NAME);
        mEditor.commit();
    }
}

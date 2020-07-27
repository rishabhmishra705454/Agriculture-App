package com.rishabh.companyproject.Database;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context context;

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_FULLNAME = "fullName";
    public static final String KEY_PHONENO = "phoneNo";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PINCODE = "pinCode";
    public static final String KEY_ADDRESS = "address";

    public SessionManager(Context _context) {
        context = _context;
        userSession = context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);
        editor = userSession.edit();
    }

    public void createLoginSession(String fullName, String phoneNo, String email, String pinCode, String address) {

        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_FULLNAME, fullName);
        editor.putString(KEY_PHONENO, phoneNo);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PINCODE, pinCode);
        editor.putString(KEY_ADDRESS, address);

        editor.commit();

    }

    public HashMap<String, String> getUserDetailFromSession() {
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put(KEY_FULLNAME, userSession.getString(KEY_FULLNAME, null));
        userData.put(KEY_PHONENO, userSession.getString(KEY_PHONENO, null));
        userData.put(KEY_EMAIL, userSession.getString(KEY_EMAIL, null));
        userData.put(KEY_PINCODE, userSession.getString(KEY_PINCODE, null));
        userData.put(KEY_ADDRESS, userSession.getString(KEY_ADDRESS, null));

        return userData;
    }

    public boolean checkLogin() {
        if (userSession.getBoolean(IS_LOGIN, false)) {
            return true;
        } else {
            return false;
        }

    }

    public void logoutUserFromSession() {
        editor.clear();
        editor.commit();
    }


}

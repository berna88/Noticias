package com.example.berna.noticias;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by BERNA on 13/12/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public static final String TAG = "NOTICIAS";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"token: "+ token);
    }
}

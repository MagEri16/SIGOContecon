package com.calymayor.sigoContecon.interactors;

import android.content.Context;

/**
 * Created by etorres on 28/12/16.
 */

public interface LoginInteractor {

        interface OnLoginFinishedListener {

            void onUsernameError();

            void onPasswordError();

            void onInvalidCredentials();

            void onUnavailableNetwork();

            void onSuccess();


        }

        //void login(String username, String password, OnLoginFinishedListener listener);
        void login(String username, String password, OnLoginFinishedListener listener, Context context);
        boolean isOnline(Context context, OnLoginFinishedListener listener);
        void initApp(Context context);
}
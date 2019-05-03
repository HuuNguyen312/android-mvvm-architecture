/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.login;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void openMainActivity();
}

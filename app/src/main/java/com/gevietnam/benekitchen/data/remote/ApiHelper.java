/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.remote;

import com.gevietnam.benekitchen.data.model.api.LoginResponse;
import com.gevietnam.benekitchen.data.model.api.LogoutResponse;
import com.gevietnam.benekitchen.data.model.api.BlogResponse;
import com.gevietnam.benekitchen.data.model.api.LoginRequest;
import com.gevietnam.benekitchen.data.model.api.OpenSourceResponse;
import io.reactivex.Single;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}

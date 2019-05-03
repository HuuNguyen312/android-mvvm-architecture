/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.gevietnam.benekitchen.BR;
import com.gevietnam.benekitchen.ui.base.BaseActivity;
import com.gevietnam.benekitchen.ui.feed.opensource.OpenSourceActivity;
import com.gevietnam.benekitchen.ui.login.LoginActivity;
import com.gevietnam.benekitchen.R;
import com.gevietnam.benekitchen.databinding.ActivitySplashBinding;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = OpenSourceActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.startSeeding();
    }
}

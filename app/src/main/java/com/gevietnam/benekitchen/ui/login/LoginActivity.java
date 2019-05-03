/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.gevietnam.benekitchen.BR;
import com.gevietnam.benekitchen.R;
import com.gevietnam.benekitchen.databinding.ActivityLoginBinding;
import com.gevietnam.benekitchen.ui.base.BaseActivity;
import com.gevietnam.benekitchen.ui.feed.opensource.OpenSourceActivity;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void login() {
        String email = mViewDataBinding.etEmail.getText().toString();
        String password = mViewDataBinding.etPassword.getText().toString();
        if (mViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            mViewModel.login(email, password);
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void openMainActivity() {
        Intent intent = OpenSourceActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
    }
}

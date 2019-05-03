/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.di.builder;

import com.gevietnam.benekitchen.ui.login.LoginActivity;
import com.gevietnam.benekitchen.ui.feed.opensource.OpenSourceActivity;
import com.gevietnam.benekitchen.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract OpenSourceActivity bindOpenSourceActivity();
}

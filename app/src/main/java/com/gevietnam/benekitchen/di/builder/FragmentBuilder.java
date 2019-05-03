/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.di.builder;

import com.gevietnam.benekitchen.ui.feed.opensource.OpenSourceFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract OpenSourceFragment openSourceFragment();
}

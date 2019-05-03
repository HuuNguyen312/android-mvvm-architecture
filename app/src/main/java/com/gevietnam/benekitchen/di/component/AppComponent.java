/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.di.component;

import android.app.Application;

import com.gevietnam.benekitchen.GeApp;
import com.gevietnam.benekitchen.di.builder.ActivityBuilder;
import com.gevietnam.benekitchen.di.builder.FragmentBuilder;
import com.gevietnam.benekitchen.di.module.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class, FragmentBuilder.class})
public interface AppComponent {

    void inject(GeApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

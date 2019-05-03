/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.di.module;

import android.app.Application;
import androidx.room.Room;
import android.content.Context;

import com.gevietnam.benekitchen.di.PreferenceInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gevietnam.benekitchen.BuildConfig;
import com.gevietnam.benekitchen.R;
import com.gevietnam.benekitchen.data.AppDataManager;
import com.gevietnam.benekitchen.data.DataManager;
import com.gevietnam.benekitchen.data.local.db.AppDatabase;
import com.gevietnam.benekitchen.data.local.db.AppDbHelper;
import com.gevietnam.benekitchen.data.local.db.DbHelper;
import com.gevietnam.benekitchen.data.local.prefs.AppPreferencesHelper;
import com.gevietnam.benekitchen.data.local.prefs.PreferencesHelper;
import com.gevietnam.benekitchen.data.remote.ApiHeader;
import com.gevietnam.benekitchen.data.remote.ApiHelper;
import com.gevietnam.benekitchen.data.remote.AppApiHelper;
import com.gevietnam.benekitchen.di.ApiInfo;
import com.gevietnam.benekitchen.di.DatabaseInfo;
import com.gevietnam.benekitchen.utils.AppConstants;
import com.gevietnam.benekitchen.utils.rx.AppSchedulerProvider;
import com.gevietnam.benekitchen.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}

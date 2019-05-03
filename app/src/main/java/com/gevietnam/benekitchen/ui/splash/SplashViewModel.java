/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.splash;

import com.gevietnam.benekitchen.data.DataManager;
import com.gevietnam.benekitchen.ui.base.BaseViewModel;
import com.gevietnam.benekitchen.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    @Inject
    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startSeeding() {
        getCompositeDisposable().add(getDataManager()
                .seedDatabaseQuestions()
                .flatMap(aBoolean -> getDataManager().seedDatabaseOptions())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    decideNextActivity();
                }, throwable -> {
                    decideNextActivity();
                }));
    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openMainActivity();
        }
    }
}

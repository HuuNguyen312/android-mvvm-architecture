/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.feed.opensource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gevietnam.benekitchen.data.DataManager;
import com.gevietnam.benekitchen.data.model.api.OpenSourceResponse;
import com.gevietnam.benekitchen.ui.base.BaseViewModel;
import com.gevietnam.benekitchen.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class OpenSourceViewModel extends BaseViewModel<OpenSourceNavigator> {

    private final MutableLiveData<List<OpenSourceItemViewModel>> openSourceItemsLiveData;

    @Inject
    public OpenSourceViewModel(DataManager dataManager,
                               SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        openSourceItemsLiveData = new MutableLiveData<>();
        fetchRepos();
    }

    public void fetchRepos() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getOpenSourceApiCall()
                .map(openSourceResponse -> openSourceResponse.getData())
                .flatMap(this::getViewModelList)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(openSourceResponse -> {
                    openSourceItemsLiveData.setValue(openSourceResponse);
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<OpenSourceItemViewModel>> getOpenSourceItemsLiveData() {
        return openSourceItemsLiveData;
    }

    private Single<List<OpenSourceItemViewModel>> getViewModelList(List<OpenSourceResponse.Repo> repoList) {
        return Observable.fromIterable(repoList)
                .map(repo -> new OpenSourceItemViewModel(
                        repo.getCoverImgUrl(), repo.getTitle(),
                        repo.getDescription(), repo.getProjectUrl())).toList();
    }
}

/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.feed.opensource;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class OpenSourceEmptyItemViewModel {

    private final OpenSourceEmptyItemViewModelListener mListener;

    public OpenSourceEmptyItemViewModel(OpenSourceEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface OpenSourceEmptyItemViewModelListener {

        void onRetryClick();
    }
}

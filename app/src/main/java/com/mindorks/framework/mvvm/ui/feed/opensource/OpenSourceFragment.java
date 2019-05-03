/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.mindorks.framework.mvvm.ui.feed.opensource;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mindorks.framework.mvvm.BR;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.databinding.FragmentOpenSourceBinding;
import com.mindorks.framework.mvvm.ui.base.BaseFragment;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class OpenSourceFragment extends BaseFragment<FragmentOpenSourceBinding, OpenSourceViewModel>
        implements OpenSourceNavigator, OpenSourceAdapter.OpenSourceAdapterListener {

    LinearLayoutManager mLayoutManager;
    OpenSourceAdapter mOpenSourceAdapter;

    public static OpenSourceFragment newInstance() {
        Bundle args = new Bundle();
        OpenSourceFragment fragment = new OpenSourceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_open_source;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mOpenSourceAdapter = new OpenSourceAdapter();
        mOpenSourceAdapter.setListener(this);
    }

    @Override
    public void onRetryClick() {
        mViewModel.fetchRepos();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mViewDataBinding.openSourceRecyclerView.setLayoutManager(mLayoutManager);
        mViewDataBinding.openSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mViewDataBinding.openSourceRecyclerView.setAdapter(mOpenSourceAdapter);
    }
}

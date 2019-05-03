/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.feed.opensource;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gevietnam.benekitchen.BR;
import com.gevietnam.benekitchen.databinding.FragmentOpenSourceBinding;
import com.gevietnam.benekitchen.ui.base.BaseFragment;
import com.gevietnam.benekitchen.R;

/**
 * Created by HuuNguyen on 05/03/2019
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

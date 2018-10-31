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

package com.mindorks.framework.mvvm.ui.feed.blogs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mindorks.framework.mvvm.data.model.api.BlogResponse;
import com.mindorks.framework.mvvm.databinding.ItemBlogViewBinding;
import com.mindorks.framework.mvvm.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BlogResponse.Blog> mBlogResponseList;

    BlogAdapter(List<BlogResponse.Blog> blogResponseList) {
        this.mBlogResponseList = blogResponseList;
    }

    @Override
    public int getItemCount() {
        return mBlogResponseList == null ? 0 : mBlogResponseList.size();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBlogViewBinding blogViewBinding = ItemBlogViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new BlogViewHolder(blogViewBinding);
    }

    public void addItems(List<BlogResponse.Blog> blogList) {
        mBlogResponseList = blogList;
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogResponseList.clear();
    }

    public class BlogViewHolder extends BaseViewHolder {

        private ItemBlogViewBinding mBinding;

        BlogViewHolder(ItemBlogViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            mBinding.setBlog(mBlogResponseList.get(position));

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }
    }
}
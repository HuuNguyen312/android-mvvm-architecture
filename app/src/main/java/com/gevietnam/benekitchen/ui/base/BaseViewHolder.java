/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.base;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}

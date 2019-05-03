/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.gevietnam.benekitchen.R;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public final class AppUtils {

    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }
}

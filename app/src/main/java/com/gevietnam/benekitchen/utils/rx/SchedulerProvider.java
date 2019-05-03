/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}

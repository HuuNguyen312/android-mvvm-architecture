/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.ui.login;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.gevietnam.benekitchen.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by HuuNguyen on 05/03/2019
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkViewsDisplay() {

        onView(withId(R.id.etEmail))
                .check(matches(isDisplayed()));

        onView(withId(R.id.etPassword))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btnServerLogin))
                .check(matches(isDisplayed()));

        onView(withText(R.string.login))
                .check(matches(isDisplayed()));

        onView(withId(R.id.ibGoogleLogin))
                .check(matches(isDisplayed()));

        onView(withId(R.id.ibFbLogin))
                .check(matches(isDisplayed()));
    }
}

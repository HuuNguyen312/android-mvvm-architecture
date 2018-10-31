package com.mindorks.framework.mvvm.di.builder;

import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragment;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = BlogFragmentModule.class)
    abstract BlogFragment provideBlogFragmentFactory();

}

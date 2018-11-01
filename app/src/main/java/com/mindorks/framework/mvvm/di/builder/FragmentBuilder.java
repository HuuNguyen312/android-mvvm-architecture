package com.mindorks.framework.mvvm.di.builder;

import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragment;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragmentModule;
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceFragment;
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = BlogFragmentModule.class)
    abstract BlogFragment provideBlogFragmentFactory();

    @ContributesAndroidInjector(modules = OpenSourceFragmentModule.class)
    abstract OpenSourceFragment provideOpenSourceFragmentFactory();
}

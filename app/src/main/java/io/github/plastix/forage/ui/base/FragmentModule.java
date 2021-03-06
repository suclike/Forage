package io.github.plastix.forage.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import io.github.plastix.forage.ui.FragmentScope;

@Module
public abstract class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Fragment provideFragment() {
        return fragment;
    }

    @Provides
    @FragmentScope
    public Context provideContext() {
        return fragment.getContext();
    }
}

package io.github.plastix.forage;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final ForageApplication app;

    public ApplicationModule(ForageApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    public Context provideApplicationContext() {
        return app.getApplicationContext();
    }
}
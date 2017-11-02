package com.example.igor.myapplication.di.modules;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public String get() {
        return "Hello";
    }
}


package com.example.igor.myapplication.di;

import com.example.igor.myapplication.di.modules.AppModule;

import dagger.Component;

@Component (modules = AppModule.class)
public interface AppComponentBuilder {
    String get();
}

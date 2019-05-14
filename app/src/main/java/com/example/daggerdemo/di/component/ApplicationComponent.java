package com.example.daggerdemo.di.component;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.data.local.DatabaseService;
import com.example.daggerdemo.data.remote.NetworkService;
import com.example.daggerdemo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    NetworkService provideNetworkService();
    DatabaseService provideDatabaseService();
}

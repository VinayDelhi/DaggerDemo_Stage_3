package com.example.daggerdemo.di.module;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.data.local.DatabaseService;
import com.example.daggerdemo.data.remote.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication myApplication;

    public ApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    NetworkService provideNetworkService(){
        return new NetworkService(myApplication, "xyz");
    }

    @Singleton
    @Provides
    DatabaseService provideDatabaseService(){

        return new DatabaseService(myApplication, "abc", 1);
    }
}

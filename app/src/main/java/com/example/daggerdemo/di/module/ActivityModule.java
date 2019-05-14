package com.example.daggerdemo.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.daggerdemo.data.local.DatabaseService;
import com.example.daggerdemo.data.remote.NetworkService;
import com.example.daggerdemo.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    MainViewModel getMainViewModel(NetworkService networkService, DatabaseService databaseService){

        return new MainViewModel(databaseService, networkService);
    }
}

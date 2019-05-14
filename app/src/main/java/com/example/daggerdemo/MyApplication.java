package com.example.daggerdemo;

import android.app.Application;
import android.util.Log;

import com.example.daggerdemo.data.local.DatabaseService;
import com.example.daggerdemo.data.remote.NetworkService;
import com.example.daggerdemo.di.component.ApplicationComponent;
import com.example.daggerdemo.di.module.ApplicationModule;
import com.example.daggerdemo.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

public class MyApplication extends Application {

    public ApplicationComponent applicationComponent;

    @Inject
    DatabaseService databaseService;

    @Inject
    NetworkService networkService;

    @Inject
    NetworkService networkService2;

    @Override
    public void onCreate() {
        super.onCreate();
        getDependencies();
    }

    private void getDependencies(){

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        Log.d("DEBUG", networkService.toString());

        Log.d("DEBUG", databaseService.toString());
    }
}

package com.example.daggerdemo.di.component;

import com.example.daggerdemo.di.module.ActivityModule;
import com.example.daggerdemo.di.scope.ActivityScope;
import com.example.daggerdemo.ui.MainActivity;

import dagger.Component;
@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}

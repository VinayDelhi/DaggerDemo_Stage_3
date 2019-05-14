package com.example.daggerdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.R;
import com.example.daggerdemo.di.component.DaggerActivityComponent;
import com.example.daggerdemo.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication)getApplication()).applicationComponent)
                .build()
                .inject(this);

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(mainViewModel.getSomeData());
    }
}

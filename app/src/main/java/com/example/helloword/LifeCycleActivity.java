package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LifeCycleActivity extends AppCompatActivity {


    public LifeCycleActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("生命周期LifeCycleActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);

    }

    public void tiao(View v) {
        Log.i("LifeCycleActivity", "按钮被点击了");
        Intent it = new Intent();
        it.setClass(LifeCycleActivity.this, MyRecycleViewActivity.class);
        //执行跳转 很关键
        startActivity(it);
    }

    @Override
    protected void onStart() {
        Log.i("生命周期LifeCycleActivity", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("生命周期LifeCycleActivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("生命周期LifeCycleActivity", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i("生命周期LifeCycleActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i("生命周期LifeCycleActivity", "onResume");
        super.onResume();
    }

}

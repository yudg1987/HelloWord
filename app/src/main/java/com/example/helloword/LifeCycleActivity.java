package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.helloword.model.User;

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
        String url="http://36.7.109.47:8801/lhjf/h5/index.html#/pages/login/index";
        Log.i("LifeCycleActivity", "按钮被点击了");
        Intent it = new Intent();
        it.setClass(LifeCycleActivity.this, MyRecycleViewActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        it.putExtra("url", url);

        //使用Bundle传递数据
        Bundle bundle=new Bundle();
        bundle.putInt("x",100);
        it.putExtras(bundle);

        //自定义传值：使用对象
        User user=new User("张三","123456",20);
        it.putExtra("user",user);


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

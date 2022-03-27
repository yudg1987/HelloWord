package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        //addFlags此属性设置后有坑：startActivityForResult() 后直接调用 onActivityResult()，返回后不执行
        //这与 Activity 的加载模式（launchMode）有关，该属性可以在 AndroidManifest.xml 中设置
        //原先将其设为 launchmode="SingleTask"，经测试，所有需要传递或接收的 Activity 不允许设置该属性
        //或只能设为标准模式，否则系统将在 startActivityForResult() 后直接调用 onActivityResult()
        //https://blog.csdn.net/sbvfhp/article/details/26858441?_t=t
        //it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        it.putExtra("url", url);

        //使用Bundle传递数据
        Bundle bundle=new Bundle();
        bundle.putInt("x",100);
        it.putExtras(bundle);

        //自定义传值：使用对象
        User user=new User("张三","123456",20);
        it.putExtra("user",user);
        //执行跳转 很关键
        //startActivity(it);

        //MyRecycleViewActivity返回来的数据 重写了onActivityResult方法
        startActivityForResult(it,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("LifeCycleActivity","onActivityResult");
        switch (requestCode){
            case 100:
                String msg=null == data ? null:data.getStringExtra("msg");
                Log.i("LifeCycleActivity.requestCode","requestCode:"+requestCode+"，resultCode:"+resultCode+",Intent.data:"+msg);
                break;
        }
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

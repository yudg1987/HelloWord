package com.example.helloword;

import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private Button btn2;
    private EditText ed01;
    private EditText et02;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_button);
        //匿名函數增加btn2点击事件
        btn2=findViewById(R.id.btn2);

        final List<String> arrs= Arrays.asList("111","2222");


        btn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Log.i("MainActivity","按钮2被点击了");
                et02=findViewById(R.id.et02);
                Log.i("et02",et02.getText().toString());
                arrs.forEach(s->{
                    Log.i("foreach",s);
                });
            }
        });

        rg=findViewById(R.id.rg);
        //添加切换事件监听
        rg.setOnCheckedChangeListener(this);

    }

    /**
     * 按钮点击方法
     * @param v
     */
    public void login(View v){
        Log.i("MainActivity","按钮被点击了");
        EditText et01=findViewById(R.id.et01);
        Log.i("et01",et01.getText().toString());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.i("checkedId",checkedId+"");
        switch (checkedId){
            case R.id.male:
                Log.i("性别","选择了男");
                break;
            case R.id.female:
                Log.i("性别","选择了女");
                break;
        }
    }
}

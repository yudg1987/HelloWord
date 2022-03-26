package com.example.helloword;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayoutActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private CheckBox cb;
    private Button btn;
    private Button btnsingle;
    private Button btncustom;
    private ListView lv;
    private ListView lv2;
    private ListView lv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.layout);
        cb = findViewById(R.id.changge);
        cb.setOnCheckedChangeListener(this);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        btnsingle = findViewById(R.id.btn_single);
        btnsingle.setOnClickListener(this);

        btncustom = findViewById(R.id.btn_custom);
        btncustom.setOnClickListener(this);

        lv = findViewById(R.id.lv);
        //lv.setOnClickListener(this);
        //ListView数据源
        List<Map<String, String>> names = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", i + "");
            names.add(map);
        }
        //使用SimpleAdapter
        SimpleAdapter sa = new SimpleAdapter(this, names, android.R.layout.simple_list_item_1, new String[]{"name"}, new int[]{android.R.id.text1});
        //给ListView设置适配器
        lv.setAdapter(sa);

        //ArrayAdapter
        String[] nameArray = new String[]{"张三", "李四"};
        lv2 = findViewById(R.id.lv2);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, nameArray);
        lv2.setAdapter(aa);

        //BaseAdapter
        List<Map<String, String>> namesMap = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "张" + i);
            map.put("phone", "1736883730" + i);
            namesMap.add(map);
        }
        PhoneAdapter pa = new PhoneAdapter(namesMap, LayoutActivity.this);
        lv3 = findViewById(R.id.lv3);
        lv3.setAdapter(pa);

    }

    //checkox监听事件
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.i("onCheckedChanged", buttonView.getText().toString() + (isChecked ? "被选中了" : "被取消选中了"));
        Toast.makeText(LayoutActivity.this, "选中Toast消息提示", Toast.LENGTH_LONG).show();
    }

    //button监听事件，实现AlertDialog功能
    @Override
    public void onClick(View v) {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        switch (v.getId()) {
            case R.id.btn:
                build.setTitle("对话框");
                build.setIcon(R.mipmap.ic_launcher);
                build.setMessage("今晚一起喝酒吗？");
                build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LayoutActivity.this, "好的今晚你请客", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LayoutActivity.this, "不行今晚没空", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            //单选框
            case R.id.btn_single:
                //Toast.makeText(LayoutActivity.this,"单选框",Toast.LENGTH_SHORT).show();
                build.setTitle("单选框");
                build.setIcon(R.mipmap.ic_launcher);
                build.setSingleChoiceItems(new String[]{"111", "222", "333"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LayoutActivity.this, "选中的是" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            //自定义对话框
            case R.id.btn_custom:
                build.setTitle("自定义对话框").setIcon(R.mipmap.ic_launcher).setView(R.layout.custom);
                break;
        }
        AlertDialog ad = build.create();
        ad.show();
    }
}

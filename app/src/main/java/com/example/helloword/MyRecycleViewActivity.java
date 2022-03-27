package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloword.model.User;

import java.util.ArrayList;
import java.util.List;

public class MyRecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private MyRecycleViewAdapter mAdapter;//适配器
    private LinearLayoutManager mLinearLayoutManager;//布局管理器
    private List mList;

    public MyRecycleViewActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("生命周期RecycleActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);

        mList = new ArrayList<>();
        mRecycleView = findViewById(R.id.rv_list);
        //初始化数据
        initData(mList);
        //创建布局管理器，垂直设置LinearLayoutManager.VERTICAL，水平设置LinearLayoutManager.HORIZONTAL
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //创建适配器，将数据传递给适配器
        mAdapter = new MyRecycleViewAdapter(mList);
        //设置布局管理器
        mRecycleView.setLayoutManager(mLinearLayoutManager);
        //设置适配器adapter
        mRecycleView.setAdapter(mAdapter);

        //接收Lifecycle传来的值
        Intent it=getIntent();
        int x=it.getIntExtra("x",0);
        String url=it.getStringExtra("url");
        Log.i("x",x+"");
        Log.i("url",url);

        //接收自定义传值：对象
        User user=(User)it.getSerializableExtra("user");
        Log.i("user",user.toString());


    }

    public void initData(List list) {
        for (int i = 1; i <= 40; i++) {
            list.add("第" + i + "条数据");
        }
    }

    @Override
    protected void onStart() {
        Log.i("生命周期RecycleActivity", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("生命周期RecycleActivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("生命周期RecycleActivity", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i("生命周期RecycleActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i("生命周期RecycleActivity", "onResume");
        super.onResume();
    }

    public static class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyHolder> {
        private List mList;//数据源

        MyRecycleViewAdapter(List<String> list) {
            mList = list;
        }

        //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //将我们自定义的item布局R.layout.recycle_view_item转换为View
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_view_item, parent, false);
            //将view传递给我们自定义的ViewHolder
            MyHolder holder = new MyHolder(view);
            //返回这个MyHolder实体
            return holder;
        }

        //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.textView.setText(mList.get(position).toString());
        }

        //获取数据源总的条数
        @Override
        public int getItemCount() {
            return mList.size();
        }

        /**
         * 自定义的ViewHolder
         */
        class MyHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public MyHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_content);
            }
        }
    }
}

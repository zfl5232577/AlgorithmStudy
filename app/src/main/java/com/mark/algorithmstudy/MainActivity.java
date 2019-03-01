package com.mark.algorithmstudy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mark.algorithmstudy.search.BinarySearch;
import com.mark.algorithmstudy.search.SearchActivity;
import com.mark.algorithmstudy.sort.OptimizationInsertionSort;
import com.mark.algorithmstudy.sort.SortActivity;
import com.mark.algorithmstudy.sort.SortHelper;
import com.mark.algorithmstudy.tree.BinarySearchTree;
import com.mark.algorithmstudy.union.UnionFindHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("mark", "onCreate: ==================================");
        setContentView(R.layout.activity_main);
        String[] names = {"排序算法", "数据结构相关", "查找算法"};
        Class[] classs = new Class[]{SortActivity.class, SortActivity.class, SearchActivity.class};
        final List<ItemBean> data = new ArrayList<>();
        for (int i = 0, size = names.length; i < size; i++) {
            ItemBean bean = new ItemBean(names[i], classs[i]);
            data.add(bean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.item_mainactivity, data);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sortAdapter);
        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (data.get(position).getName().equals("数据结构相关")) {
                    UnionFindHelper.test4(1000000);
                    UnionFindHelper.test5(1000000);
                    UnionFindHelper.test6(1000000);
                } else if (data.get(position).getName().equals("排序算法")) {
                    startActivity(new Intent(MainActivity.this, data.get(position).getActivity()));
                } else if (data.get(position).getName().equals("查找算法")) {
                    startActivity(new Intent(MainActivity.this, data.get(position).getActivity()));
                }
            }
        });
    }

    public static class ItemBean {
        private String name;
        private Class<? extends Activity> mActivity;

        public ItemBean(String name, Class<? extends Activity> activity) {
            this.name = name;
            mActivity = activity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class<? extends Activity> getActivity() {
            return mActivity;
        }

        public void setActivity(Class<? extends Activity> activity) {
            mActivity = activity;
        }
    }

    public static class MyAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<ItemBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ItemBean item) {
            helper.setText(R.id.tv_name, item.getName());
        }
    }
}

package com.mark.algorithmstudy.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mark.algorithmstudy.R;
import com.mark.algorithmstudy.sort.BubbleSort;
import com.mark.algorithmstudy.sort.HeapSort;
import com.mark.algorithmstudy.sort.ISort;
import com.mark.algorithmstudy.sort.InsertionSort;
import com.mark.algorithmstudy.sort.MergeSort;
import com.mark.algorithmstudy.sort.OptimizationHeapSort;
import com.mark.algorithmstudy.sort.OptimizationInsertionSort;
import com.mark.algorithmstudy.sort.QuickSort;
import com.mark.algorithmstudy.sort.SelectionSort;
import com.mark.algorithmstudy.sort.SortFactory;
import com.mark.algorithmstudy.sort.SortHelper;
import com.mark.algorithmstudy.sort.ThreeWayQuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        String[] names = {"BinarySearch"};
        Class[] classes = new Class[]{BinarySearch.class};
        List<ItemBean> data = new ArrayList();
        for (int i =0,size = names.length;i<size;i++){
            ItemBean bean = new ItemBean(names[i],classes[i]);
            data.add(bean);
        }
        SortAdapter sortAdapter = new SortAdapter(R.layout.item_sortactivity,data);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sortAdapter);
    }

    public static class ItemBean{
        private String name;
        private Class<? extends ISort> mClass;

        public ItemBean(String name, Class<? extends ISort> aClass) {
            this.name = name;
            mClass = aClass;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class<? extends ISort> getBeanClass() {
            return mClass;
        }

        public void setClass(Class<? extends ISort> aClass) {
            mClass = aClass;
        }
    }

    public static class SortAdapter extends BaseQuickAdapter<ItemBean,BaseViewHolder>{
        public SortAdapter(int layoutResId, @Nullable List<ItemBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final ItemBean item) {
            helper.setText(R.id.tv_name,item.getName());
            helper.getView(R.id.tv1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] strings ={"SelectionSort","InsertionSort","BubbleSort","OptimizationInsertionSort"};
                    List list = Arrays.asList(strings);
                    int n;
                    if (list.contains(item.getName())) {
                        n = 100000;
                    }else {
                        n= 1000000;
                    }
                    ISort sort = SortFactory.creat(item.getBeanClass());
                    int[] ary = SortHelper.genereteRandomArray(n,0,n);
                    sort.sort(ary,0,ary.length-1);
                    Log.e("Sort " + n + "个数据", "onCreate: "+SortHelper.isSorted(ary) );
                }
            });

            helper.getView(R.id.tv2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] strings ={"SelectionSort","InsertionSort","BubbleSort","OptimizationInsertionSort"};
                    List list = Arrays.asList(strings);
                    int n;
                    if (list.contains(item.getName())) {
                        n = 100000;
                    }else {
                        n= 1000000;
                    }
                    ISort sort = SortFactory.creat(item.getBeanClass());
                    int[] ary = SortHelper.genereteNearlyOrderedArray(n,100);
                    sort.sort(ary,0,ary.length-1);
                    Log.e("Sort " + n + "个数据", "onCreate: "+SortHelper.isSorted(ary) );
                }
            });

            helper.getView(R.id.tv3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] strings ={"SelectionSort","InsertionSort","BubbleSort","OptimizationInsertionSort"};
                    List list = Arrays.asList(strings);
                    int n;
                    if (list.contains(item.getName())) {
                        n = 100000;
                    }else {
                        n= 1000000;
                    }
                    ISort sort = SortFactory.creat(item.getBeanClass());
                    int[] ary = SortHelper.genereteRandomArray(n,0,100);
                    sort.sort(ary,0,ary.length-1);
                    Log.e("Sort " + n + "个数据", "onCreate: "+SortHelper.isSorted(ary) );
                }
            });
        }
    }
}

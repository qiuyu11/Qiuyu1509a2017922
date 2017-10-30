package com.bawei.qiuyu1509a2017922;
/**

 * 事件:2017/09/22
 * 主类,执行工程的主入口
 *
 * */
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.bawei.adapter.Myadapter;

import java.util.ArrayList;
import java.util.List;

import fragment.Fragment01;
import fragment.Fragment02;
import fragment.Fragment03;
import fragment.Fragment04;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private RadioGroup rag;
    private ListView lv;
    private List<Fragment> list = new ArrayList<Fragment>();
    private List<String> list2 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//获取id

        pager = (ViewPager) findViewById(R.id.pag);
        rag = (RadioGroup) findViewById(R.id.rag);
        lv = (ListView) findViewById(R.id.lv);
        //设置默认按钮
         rag.check(R.id.btn1);
        //添加数据
        list2.add("客服热线");
        list2.add("营业部网点");
        list2.add("系统设置");
        list2.add("换肤");
        //实例化适配器
        Myadapter myadapter = new Myadapter(MainActivity.this,list2);
        //关联适配器
        lv.setAdapter(myadapter);
        //实例化fragment
        Fragment01 fragment01 = new Fragment01();
        Fragment02 fragment02 = new Fragment02();
        Fragment03 fragment03 = new Fragment03();
        Fragment04 fragment04 = new Fragment04();
        //添加fragment
        list.add(fragment01);
        list.add(fragment02);
        list.add(fragment03);
        list.add(fragment04);
//viewpage适配器及关联
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
//viewpage滑动监听
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据viewpage页数设置radiobutton按钮
                switch (position)
                {
                    case 0:
                        rag.check(R.id.btn1);
                        break;
                    case 1:
                        rag.check(R.id.btn2);
                        break;
                    case 2:
                        rag.check(R.id.btn3);
                        break;
                    case 3:
                        rag.check(R.id.btn4);
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//radiogroup按钮切换监听
        rag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //根据选中按钮设置切换viewpage页面
                switch (checkedId)
                {
                    case R.id.btn1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.btn4:
                        pager.setCurrentItem(3);
                        break;



                }
            }
        });

    }
}

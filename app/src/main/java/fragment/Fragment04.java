package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bawei.qiuyu1509a2017922.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class Fragment04 extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] channels = {"数据新闻","快讯","头条","精编公告","美股","港股","基金","理财"};
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<ChangFragment> mViewList = new ArrayList<ChangFragment>();//页卡视图集合

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<channels.length;i++){
            //创建栏目的fragment
            ChangFragment fragment = new ChangFragment();
            Bundle b = new Bundle();
            b.putString("name", channels[i]);//传递名字

            fragment.setArguments(b);
            //收集fragment
            mViewList.add(fragment);
            //给tablayout添加tab选项卡
            //mTabLayout.addTab(mTabLayout.newTab().setText(channels[i]));//添加tab选项卡


        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取视图
        View view = inflater.inflate(R.layout.fragment04,container,false);
        //获取id
        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout)view.findViewById(R.id.tabs);
        mInflater = LayoutInflater.from(getActivity());

//设置tablayout标签属性
        for(int i=0;i<channels.length;i++){
//            //创建栏目的fragment
//            ChangFragment fragment = new ChangFragment();
//            Bundle b = new Bundle();
//            b.putString("name", channels[i]);//传递名字
//
//            fragment.setArguments(b);
//            //收集fragment
//            mViewList.add(fragment);
//            给tablayout添加tab选项卡
            mTabLayout.addTab(mTabLayout.newTab().setText(channels[i]));//添加tab选项卡


        }
        //开启事务
        FragmentManager fm =getActivity().getSupportFragmentManager();
        MyFragmentPagerAdapter mAdapter = new MyFragmentPagerAdapter(fm, mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器


        return view;
    }
    //适配器
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<ChangFragment> mViewList;


        public MyFragmentPagerAdapter(FragmentManager fm, List<ChangFragment> mViewList) {
            super(fm);
            this.mViewList = mViewList;
        }


        @Override
        public Fragment getItem(int position) {
            return mViewList.get(position);
        }


        @Override
        public int getCount() {
            return mViewList.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {


            return channels[position];//页卡标题
        }
    }
    }

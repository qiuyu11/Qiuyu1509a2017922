package fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.adapter.MyAdapter02;
import com.bawei.beans.Bean;
import com.bawei.beans.Newslist;
import com.bawei.qiuyu1509a2017922.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import utils.HttpUtil;

/**
 * Created by Administrator on 2017/9/22.
 */

public class ChangFragment extends Fragment {
    private String Url = "https://api.tianapi.com/wxnew/?key=8d6e3228d25298f13af4fc40ce6c9679&num=10";
    private String Url01 = "https://api.tianapi.com/wxnew/?key=8d6e3228d25298f13af4fc40ce6c9679&num=";
    private PullToRefreshListView listView;
    private  List<Newslist> newslist;
    private MyAdapter02 ada2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取传过来的标题栏的值
        Bundle bundle = getArguments();

        String name = bundle.getString("name");
        Toast.makeText(getActivity(),"切换到"+name,Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取视图
        View view = inflater.inflate(R.layout.changfragment,container,false);
        //获取id
        listView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
        //初始化组件
        initView();
        //初始化加载数据
        initData();
        return view;
    }
    private void initData() {
        pullToRefreshData();
    }
    //下拉刷新
    private void pullToRefreshData() {
        new AsyncTask<String,Integer,String>(){

            @Override
            protected String doInBackground(String... params) {
                String s = new HttpUtil().getHttp(Url);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //解析json
                Bean bean = new Gson().fromJson(s, Bean.class);
                 newslist = bean.getNewslist();
                ada2 = new MyAdapter02(getActivity(),newslist);
               listView.setAdapter(ada2);

                listView.onRefreshComplete();//停止刷新
            }

        }.execute();
    }

    int index = 10;
    //上拉加载
    private void loadMoreData() {
        new AsyncTask<String,Integer,String>(){

            @Override
            protected String doInBackground(String... params) {
                index++;
                HttpUtil util = new HttpUtil();
                String http = util.getHttp(Url01 + index);
                return http;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //解析json
                Bean bean = new Gson().fromJson(s, Bean.class);
                newslist.addAll(bean.getNewslist());
               ada2.notifyDataSetChanged();

            }

        }.execute();
    }



    private void initView() {

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //当下拉刷新，进入此方法
                Toast.makeText(getActivity(),"下拉刷新",Toast.LENGTH_SHORT).show();
                //加载新数据，刷新显示
                pullToRefreshData();
            }
        });
        listView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                Toast.makeText(getActivity(),"上拉显示出listview的最后一行",Toast.LENGTH_SHORT).show();
                loadMoreData();
            }
        });
    }
}

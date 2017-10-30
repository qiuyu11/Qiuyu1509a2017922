package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.qiuyu1509a2017922.R;


/**
 * Created by Administrator on 2017/9/22.
 */

public class Fragment02 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取视图
        View view = inflater.inflate(R.layout.fragment02,container,false);
        return view;
    }
}

package test.bawei.com.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import test.bawei.com.tablayout.Bean.Mysupclass;
import test.bawei.com.tablayout.adapter.HomeAdapter;
import test.bawei.com.tablayout.utils.GsonObjectCallback;
import test.bawei.com.tablayout.utils.OkHttp3Utils;

/**
 * Created by lenovo on 2017/10/25.
 */

public class FragemntOne extends Fragment {

    private XRecyclerView xRecyclerView;
    private int curr=1;
    private String url="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type="+curr+"&size=10&offset=0";
    private List<Mysupclass.SongListBean> list;
    private HomeAdapter homeAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragmentone_layout, null);

        list=new ArrayList<Mysupclass.SongListBean>();
        xRecyclerView=view.findViewById(R.id.xr_view);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr=1;
                list.clear();
                getData(curr);
                xRecyclerView.refreshComplete();
            }



            @Override
            public void onLoadMore() {
                curr++;

                getData(curr);
                xRecyclerView.refreshComplete();
            }

        });
        curr=1;
        getData(curr);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public void getData(int curr){

        OkHttp3Utils.getInstance().doGet(url, new GsonObjectCallback<Mysupclass>() {
            @Override
            public void onUi(Mysupclass mysupclass) {

                for (int i=0; i<mysupclass.getSong_list().size();i++){
                    list.add(mysupclass.getSong_list().get(i));

                }

//                Toast.makeText(getActivity(),"ssss"+list,Toast.LENGTH_SHORT).show();
                homeAdapter = new HomeAdapter(list,getActivity());
                xRecyclerView.setAdapter(homeAdapter);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }


}

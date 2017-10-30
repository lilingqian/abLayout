package test.bawei.com.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import test.bawei.com.tablayout.Bean.Mysupclass;
import test.bawei.com.tablayout.adapter.FourAdapter;
import test.bawei.com.tablayout.adapter.OnItemClickLitener;
import test.bawei.com.tablayout.utils.GsonObjectCallback;
import test.bawei.com.tablayout.utils.OkHttp3Utils;

/**
 * Created by lenovo on 2017/10/25.
 */

public class Fragmentfour extends Fragment {


    private RecyclerView recyclerView;
    private String url="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=1";
    private List<Mysupclass.SongListBean> list;
    private FourAdapter fourAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragmentthree, null);

        recyclerView = view.findViewById(R.id.recyclerview);

        getData();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        return view;
    }
    public void getData(){
        OkHttp3Utils.getInstance().doGet(url, new GsonObjectCallback<Mysupclass>() {
            @Override
            public void onUi(Mysupclass mysupclass) {
                list = mysupclass.getSong_list();
                fourAdapter = new FourAdapter(getActivity(), list);
                recyclerView.setAdapter(fourAdapter);
                fourAdapter.setOnItemClickLitener(new OnItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int position) {Intent intent = new Intent(getActivity(), Succes_Activity.class);
                       String si_proxycompany = list.get(position).getSi_proxycompany();
                       String country = list.get(position).getCountry();
                       intent.putExtra("si",si_proxycompany);
                       intent.putExtra("country",country);
                        startActivity(intent);

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                    }
                });
            }
            @Override
            public void onFailed(Call call, IOException e) {
            }
        });
    }

}

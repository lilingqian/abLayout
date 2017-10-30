package test.bawei.com.tablayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import test.bawei.com.tablayout.Bean.Mysupclass;
import test.bawei.com.tablayout.Myapp.GlideImaGlideImageLoader;
import test.bawei.com.tablayout.R;
import test.bawei.com.tablayout.utils.Imageloderll;

/**
 * Created by lenovo on 2017/10/25.
 */

public class HomeAdapter extends RecyclerView.Adapter{

    private List<Mysupclass.SongListBean> list;
    private Context context;

    public HomeAdapter(List<Mysupclass.SongListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){

            case 0:
                bannerViewholder holder1 = new bannerViewholder(LayoutInflater.from(
                        context).inflate(R.layout.item_banner, parent, false));
                return holder1;
            case 1:
                MaxViewholder holder2 = new MaxViewholder(LayoutInflater.from(
                        context).inflate(R.layout.item_max, parent, false));
                return holder2;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case 0:
                bannerViewholder bannerholder= (bannerViewholder) holder;
                ArrayList<String> mlist = new ArrayList<>();
                for (int i=0;i<list.size();i++){

                    String img = list.get(i).getPic_big();
                    mlist.add(img);
                }
                bannerholder.banner.setImageLoader(new GlideImaGlideImageLoader());
                bannerholder.banner.setImages(mlist);
                bannerholder.banner.start();
                break;
            case 1:
                MaxViewholder maxholder= (MaxViewholder) holder;
                maxholder.tv_title.setText(list.get(position).getAlbum_title());
                String img = list.get(position).getPic_small();
           //     ImageLoader.getInstance().displayImage(img,((MaxViewholder) holder).imgshow);
                Imageloderll.setimage(img,context,((MaxViewholder) holder).imgshow);
                break;

        }

    }


    class MaxViewholder extends RecyclerView.ViewHolder{


        TextView tv_title;
        ImageView imgshow;
        public MaxViewholder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            imgshow = itemView.findViewById(R.id.imgshow);
        }
    }
    class bannerViewholder extends RecyclerView.ViewHolder{
        private Banner banner;
        public bannerViewholder(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.mybanner);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return 0;
        }else{
            return 1;
        }

    }
}

package test.bawei.com.tablayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import test.bawei.com.tablayout.Bean.Mysupclass;
import test.bawei.com.tablayout.R;


public class FourAdapter extends RecyclerView.Adapter<FourAdapter.MyViewHolder>
{

    private Context context;
    private List<Mysupclass.SongListBean> list;



    public FourAdapter(Context context, List<Mysupclass.SongListBean> list) {
        this.context = context;
        this.list = list;
    }
    public OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

    MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_grid, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        String pic_small = list.get(position).getPic_small();
        ImageLoader.getInstance().displayImage(pic_small,holder.img_grid);


        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }


    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img_grid;

        public MyViewHolder(View view)
        {
            super(view);
             img_grid=view.findViewById(R.id.img_grid);
        }
    }
}


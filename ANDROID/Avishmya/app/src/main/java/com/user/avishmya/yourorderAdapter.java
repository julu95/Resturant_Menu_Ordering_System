package com.user.avishmya;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 24-03-2017.
 */
public class yourorderAdapter extends RecyclerView.Adapter<yourorderAdapter.ViewHolderr> {

    public String[] imageurl,name,price,sl,qnty;
    public Context context;
    public CustomAdapter.ViewHolder vh;
    public yourorderAdapter(Context context, String[] sl, String[] name, String[] imageurl, String[] qnty, String[] price) {
        this.imageurl=imageurl;
            this.name=name;
            this.price=price;
            this.context=context;
            this.sl=sl;
            this.qnty=qnty;
        }
    @Override
    public yourorderAdapter.ViewHolderr onCreateViewHolder(ViewGroup parent, final int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.your_order_list_layout,parent,false);
        return new ViewHolderr(v);
    }

    @Override
    public void onBindViewHolder(final yourorderAdapter.ViewHolderr holder, final int position) {
        new DownloadImageTask(holder.imageView).execute(Data.URL+imageurl[position]);
        holder.sl.setText(sl[position]);
        holder.lname.setText(name[position]);
        holder.lqnty.setText(qnty[position]);
        holder.lprice.setText("Rs "+price[position]+"/- ");
    }
    @Override
    public int getItemCount() {
        return imageurl.length;
    }

    public class ViewHolderr extends RecyclerView.ViewHolder {
        public TextView sl,lname,lqnty,lprice;
        public ImageView imageView;
        public ViewHolderr(View itemView) {
            super(itemView);
            sl=(TextView)itemView.findViewById(R.id.lsl);
            lname=(TextView)itemView.findViewById(R.id.lname);
            lqnty=(TextView)itemView.findViewById(R.id.lqnty);
            lprice=(TextView)itemView.findViewById(R.id.lprice);
            imageView=(ImageView)itemView.findViewById(R.id.limage);
        }
    }
}

package com.user.avishmya;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 23-02-2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    public String[] imageurl,name,price,id;
    public Context context;
    public  ViewHolder vh;
    public CustomAdapter(Context context,String[] id, String[] name, String[] price,  String[] imageurl){
       this.imageurl=imageurl;
       this.name=name;
       this.price=price;
        this.context=context;
        this.id=id;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_item,parent,false);
        vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, final int position) {
        new DownloadImageTask(holder.imageView).execute(Data.URL+imageurl[position]);
        holder.textView.setText(name[position]);
        holder.textView1.setText("Rs "+price[position]+"/- only");
        holder.item_id.setText(id[position]);
        if(Data.params.containsKey(id[position])) {
            String qnty = Data.params.get(id[position]).toString();
            if (Integer.parseInt(qnty) > 0) {
                holder.card.setBackgroundColor(Color.parseColor("#FFFBF5C1"));
            }
        }
        if(Data.params.containsKey(id[position])) {
            holder.item_no.setText(Data.params.get(id[position]).toString());
        }
        holder.plase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no=Integer.parseInt(holder.item_no.getText().toString());
                no=no+1;
                holder.item_no.setText(""+no);
                if(no>0) {
                    holder.card.setBackgroundColor(Color.parseColor("#FFFBF5C1"));
                }
                Data.params.put(id[position],""+no);
            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no=Integer.parseInt(holder.item_no.getText().toString());
                if(no!=0){
                    no=no-1;
                    holder.item_no.setText(""+no);
                    if(no==0){
                        holder.card.setBackgroundColor(Color.WHITE);
                    }
                    Data.params.put(id[position],""+no);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageurl.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView,textView1,item_id,item_no;
        public ImageView imageView,plase,sub;
        public LinearLayout card;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=(TextView)itemView.findViewById(R.id.name);
            textView1=(TextView)itemView.findViewById(R.id.price);
            item_id=(TextView)itemView.findViewById(R.id.item_id);
            item_no=(TextView)itemView.findViewById(R.id.item_no);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            plase=(ImageView)itemView.findViewById(R.id.pluse);
            sub=(ImageView)itemView.findViewById(R.id.sub);
            card=(LinearLayout)itemView.findViewById(R.id.card);

        }

        @Override
        public void onClick(View v) {
            /*int position=getAdapterPosition();
            Intent intent=new Intent();
            intent.setClass(context,Show_item_details.class);
            intent.putExtra("product_name",name[position]);
            intent.putExtra("product_img_url",imageurl[position]);
            intent.putExtra("product_id",id[position]);
            context.startActivity(intent);*/
        }
    }
}

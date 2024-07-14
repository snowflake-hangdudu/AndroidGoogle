package com.example.list2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public List<Item> itemList;

    public Adapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static class  ViewHolder  extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public ImageView imageView2;
        public TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);

            imageView2 = (ImageView) itemView.findViewById(R.id.icon);
            textView2 = (TextView) itemView.findViewById(R.id.num);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.list_item, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageId());
        holder.imageView2.setImageResource(R.drawable.ic_grain);
        holder.textView.setText(item.getTitle());
        holder.textView2.setText(item.getNum());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



}

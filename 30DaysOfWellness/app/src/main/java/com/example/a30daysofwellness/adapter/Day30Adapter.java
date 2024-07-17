package com.example.a30daysofwellness;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a30daysofwellness.model.Day30;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Day30Adapter extends RecyclerView.Adapter<Day30Adapter.Day30ViewHolder> {

    private Context context;
    private List<Day30> day30List;

    public Day30Adapter(Context context, List<Day30> day30List) {
        this.context = context;
        this.day30List = day30List;
    }

    @NonNull
    @Override
    public Day30ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_day30, parent, false);
        return new Day30ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Day30ViewHolder holder, int position) {
        Day30 day30 = day30List.get(position);
        holder.itemImage.setImageResource(day30.getImgid());
        holder.itemName.setText(day30.getName());
        holder.itemDesc.setText(day30.getDesc());
        holder.itemLongDesc.setText(day30.getLongdesc());



        // 设置点击监听器
        holder.itemImage.setOnClickListener(view -> {
            if (holder.itemLongDesc.getVisibility() == VISIBLE) {
                // 淡出动画
                holder.itemLongDesc.animate()
                        .alpha(0f)
                        .setDuration(300)
                        .withEndAction(() -> holder.itemLongDesc.setVisibility(GONE))
                        .setListener(null);
            } else {
                // 淡入动画
                holder.itemLongDesc.setAlpha(0f);
                holder.itemLongDesc.setVisibility(VISIBLE);
                holder.itemLongDesc.animate()
                        .alpha(1f)
                        .setDuration(300)
                        .setListener(null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return day30List.size();
    }

    public static class Day30ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemDesc;
        TextView itemLongDesc;

        public Day30ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.image);
            itemName = itemView.findViewById(R.id.name);
            itemDesc = itemView.findViewById(R.id.desc);
            itemLongDesc = itemView.findViewById(R.id.long_desc);
        }
    }
}


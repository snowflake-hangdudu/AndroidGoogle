package com.example.superhero.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superhero.R;
import com.example.superhero.model.Superhero;

import java.util.List;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder> {

    private List<Superhero> superheroList;

    public SuperheroAdapter(List<Superhero> superheroList) {
        this.superheroList = superheroList;
    }

    @NonNull
    @Override
    public SuperheroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.superhero, parent, false);
        return new SuperheroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroViewHolder holder, int position) {
        Superhero superhero = superheroList.get(position);
        holder.imgSuperhero.setImageResource(superhero.getImgId());
        holder.tvName.setText(superhero.getName());
        holder.tvDescription.setText(superhero.getDescription());
    }

    @Override
    public int getItemCount() {
        return superheroList.size();
    }

    static class SuperheroViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSuperhero;
        TextView tvName;
        TextView tvDescription;

        public SuperheroViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSuperhero = itemView.findViewById(R.id.ava);
            tvName = itemView.findViewById(R.id.title);
            tvDescription = itemView.findViewById(R.id.description);
        }
    }
}


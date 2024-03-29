package com.example.testinterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testinterface.Entity.Film;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Film>films;
    Context context;

    public MyAdapter(List<Film> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =View.inflate(context,R.layout.single_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(films.get(position).getName());
        holder.picture.setText(films.get(position).getPoster());
        holder.cinema.setText(films.get(position).getCinema());

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,picture,cinema;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.name);
            picture = itemView.findViewById(R.id.picture);
            cinema=itemView.findViewById(R.id.cinema);
        }
    }
}

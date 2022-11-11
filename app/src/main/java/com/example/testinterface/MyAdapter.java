package com.example.testinterface;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
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
        Intent intent = new Intent(context,DetailsUserActivity.class);
        holder.name.setText(films.get(position).getName());
        holder.picture.setImageURI(Uri.parse(films.get(position).getPoster()));
        holder.cinema.setText(films.get(position).getCinema());

        holder.itemView.setOnClickListener(e->{
            intent.putExtra("name",films.get(position).getName());
            intent.putExtra("cinema",films.get(position).getCinema());
            intent.putExtra("picture",films.get(position).getPoster());
            intent.putExtra("description",films.get(position).getDescription());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,cinema;
        ImageView picture;
        Button detailsfilm;
        AutoCompleteTextView autoCompleteTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            detailsfilm=itemView.findViewById(R.id.detailsButton);
            name= itemView.findViewById(R.id.name);
            picture = itemView.findViewById(R.id.picture);
            cinema=itemView.findViewById(R.id.cinema);
            autoCompleteTextView= itemView.findViewById(R.id.auto_complete_text);
        }
    }
}

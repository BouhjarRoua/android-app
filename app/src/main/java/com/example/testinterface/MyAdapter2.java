package com.example.testinterface;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.PathUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;

import java.io.InputStream;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    List<Film> films;
    Context context;


    public MyAdapter2(List<Film> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.test_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.id.setText((String.valueOf(films.get(position).getId())));
        holder.name.setText(films.get(position).getName());
       //Bitmap bitmap = BitmapFactory.decodeStream(openInputStream(holder.picture.setImageURI(Uri.parse(films.get(position).getPoster()))));
       /* String data = String.valueOf(films.get(2));
        Uri dataUri = Uri.parse(films.get(position).getPoster() + data);
        Bitmap bb = Bitmap.createBitmap(dataUri.)*/
       // holder.picture.setImageBitmap(films.get(position).getPoster().);
        holder.picture.setImageURI(Uri.parse(films.get(position).getPoster()));
        holder.deletebtn.setOnClickListener(v->{

            AppDataBase  database = AppDataBase.getAppDatabase(holder.deletebtn.getContext() );

            database.filmDAO().deleteById(films.get(position).getId());
            films.remove(position);
            notifyDataSetChanged();
        });
      // holder.cinema.setText(films.get(position).getCinema());

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,id;
        ImageView picture;
        ImageButton deletebtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.filmid);
            name = itemView.findViewById(R.id.textViewdis);
            picture = itemView.findViewById(R.id.imageViewdis);
            deletebtn=itemView.findViewById(R.id.deletebtn);
            //cinema = itemView.findViewById(R.id.cinema);
        }
    }
}

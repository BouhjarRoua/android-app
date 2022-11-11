package com.example.testinterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.Entity.User;
import com.example.testinterface.database.AppDataBase;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =View.inflate(context,R.layout.listuser_item,null);
        return new UserAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.userid.setText((String.valueOf(users.get(position).getId())));
        holder.lastname.setText(users.get(position).getLastname());
        holder.firstname.setText(users.get(position).getFirstname());
        holder.email.setText(users.get(position).getEmail());
        holder.deleteuserbtn.setOnClickListener(v->{

            AppDataBase database = AppDataBase.getAppDatabase(holder.deleteuserbtn.getContext() );

            database.filmDAO().deleteById(users.get(position).getId());
            users.remove(position);
            notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView lastname,firstname,email,userid;
        ImageButton deleteuserbtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lastname=itemView.findViewById(R.id.lastnameuser);
            firstname= itemView.findViewById(R.id.firstnameuser);
            email = itemView.findViewById(R.id.emailuser);
            userid=itemView.findViewById(R.id.userid);
            deleteuserbtn=itemView.findViewById(R.id.deletebtnuser);
        }
    }
}

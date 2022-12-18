
package com.example.appfood.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appfood.Domain.CatogryDomain;
import com.example.appfood.Domain.FoodDomain;
import com.example.appfood.R;
import com.example.appfood.ShowDetailActivity;

import java.util.ArrayList;


public class PoplurarAdapter extends RecyclerView.Adapter<PoplurarAdapter.ViewHolder> {
    ArrayList<FoodDomain> popularFood;

    public PoplurarAdapter(ArrayList<FoodDomain> catogryDomains) {
        this.popularFood = catogryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from (parent.getContext ()).inflate (R.layout.viewholder_popular, parent, false);
        return new ViewHolder (inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PoplurarAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        holder.free.setText (String.valueOf (popularFood.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext ().getResources ().getIdentifier (popularFood.get (position).getPic (), "drawable", holder.itemView.getContext ().getPackageName ());


        Glide.with (holder.itemView.getContext ())
                .load (drawableResourceId)
                .into (holder.pic);


        holder.addbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v ){
        Intent intent = new Intent (holder.itemView.getContext (),ShowDetailActivity.class);
        intent.putExtra ("object", popularFood.get (position));
        holder.itemView.getContext ().startActivity (intent);
           }
        });
}

    @Override
    public int getItemCount() {
        return popularFood.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,free;
        ImageView pic;
        TextView addbtn;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);
            title=itemView.findViewById(R.id.title);
            free=itemView.findViewById (R.id.free);
            pic=itemView.findViewById(R.id.pic);
            addbtn=itemView.findViewById(R.id.addbtn);
        }
    }
}
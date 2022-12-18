
package com.example.appfood.Adaptor;
import com.bumptech.glide.Glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Domain.CatogryDomain;
import com.example.appfood.R;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CatogryDomain> catogryDomains;

    public CategoryAdapter(ArrayList<CatogryDomain> catogryDomains) {
        this.catogryDomains = catogryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from (parent.getContext ()).inflate (R.layout.viewholder_category, parent, false);
        return new ViewHolder (inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.catagaryName.setText (catogryDomains.get (position).getTitle ());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "cato_1";
                holder.mainLayout.setBackground (ContextCompat.getDrawable (holder.itemView.getContext (), R.drawable.cat_background1));
                break;
            }
            case 1: {
                picUrl = "cato_2";
                holder.mainLayout.setBackground (ContextCompat.getDrawable (holder.itemView.getContext (), R.drawable.cat_background2));
                break;
            }
            case 2: {
                picUrl = "cato_3";
                holder.mainLayout.setBackground (ContextCompat.getDrawable (holder.itemView.getContext (),R.drawable.cat_background3));
                break;
            }
            case 3: {
                picUrl = "cato_4";
                holder.mainLayout.setBackground (ContextCompat.getDrawable (holder.itemView.getContext (),R.drawable.cat_background4));
                break;
            }
            case 4: {
                picUrl = "cato_5";
                    holder.mainLayout.setBackground (ContextCompat.getDrawable (holder.itemView.getContext (),R.drawable.cat_background5));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext ().getResources ().getIdentifier (picUrl, "drawable", holder.itemView.getContext ().getPackageName ());


        Glide.with (holder.itemView.getContext ())
                .load (drawableResourceId)
                .into (holder.catagaryPic);
    }
    @Override
    public int getItemCount() {
        return catogryDomains.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView catagaryName;
        ImageView catagaryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);
            catagaryName = itemView.findViewById (R.id.catogeyName);
            catagaryPic = itemView.findViewById (R.id.catogryPic);
            mainLayout = itemView.findViewById (R.id.mainLayout);

        }
    }
}
package com.example.gourmetegypt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {
    int[] picList;
    String[] titleList;
    String[] detailList;

    public RecipeListAdapter(int[] picList, String[] titleList, String[] detailList) {
        this.picList = picList;
        this.titleList = titleList;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_recipe, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.ViewHolder holder, int position) {
        Integer pics = picList[position];
        String titles = titleList[position];
        String details = detailList[position];
        holder.pic.setImageResource(pics);
        holder.title.setText(titles);
        holder.detail.setText(details);
    }

    @Override
    public int getItemCount() {
        return picList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView title, detail, addToCartButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);
            detail = itemView.findViewById(R.id.detail);
            //addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}

package com.example.gourmetegypt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OfferListAdapter extends RecyclerView.Adapter<OfferListAdapter.ViewHolder> {
    int[] imageList;
    String[] offerNameList;
    double[] offerPriceList;

    public OfferListAdapter(int[] imageList, String[] offerNameList, double[] offerPriceList) {
        this.imageList = imageList;
        this.offerNameList = offerNameList;
        this.offerPriceList = offerPriceList;
    }

    @NonNull
    @Override
    public OfferListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_offer, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferListAdapter.ViewHolder holder, int position) {
        Integer images = imageList[position];
        String names = offerNameList[position];
        Double prices = offerPriceList[position];
        holder.thumbImage.setImageResource(images);
        holder.offerName.setText(names);
        holder.offerPrice.setText("EGP " + prices);
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbImage;
        TextView offerName, offerPrice, addToCartButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbImage = itemView.findViewById(R.id.thumbImage);
            offerName = itemView.findViewById(R.id.offerName);
            offerPrice = itemView.findViewById(R.id.offerPrice);
            //addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}

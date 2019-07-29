package com.example.appscheflogin.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appscheflogin.Model.Product;
import com.example.appscheflogin.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    List<Product> mProductList;

    public ProductAdapter(List<Product> mProductList) {
        this.mProductList = mProductList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list, viewGroup, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextViewId.setText(mProductList.get(position).getId());
        holder.mTextViewNama.setText(mProductList.get(position).getName());
        Picasso.get().load(mProductList.get(position).getImage()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewId, mTextViewNama;
        public ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.id_product);
            mTextViewNama = (TextView) itemView.findViewById(R.id.name_product);
            mImageView = (ImageView) itemView.findViewById(R.id.image_product);
        }
    }
}

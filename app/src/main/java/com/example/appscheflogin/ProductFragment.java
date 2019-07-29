package com.example.appscheflogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appscheflogin.Adapter.ProductAdapter;
import com.example.appscheflogin.Model.GetProduct;
import com.example.appscheflogin.Model.Product;
import com.example.appscheflogin.Rest.ApiClient;
import com.example.appscheflogin.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    ApiInterface mApiInterface;
    FragmentActivity ma;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_product);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=getActivity();
        refresh();

        return view;
    }

    public void refresh() {
        Call<GetProduct> productCall = mApiInterface.getProduct("page", "2", "3");
        productCall.enqueue(new Callback<GetProduct>() {
            @Override
            public void onResponse(Call<GetProduct> call, Response<GetProduct>
                    response) {
                List<Product> ProductList = response.body().getProductList();
                Log.d("Retrofit Get", "Jumlah data Product: " +
                        String.valueOf(ProductList.size()));
                mAdapter = new ProductAdapter(ProductList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetProduct> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}

package com.example.appscheflogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appscheflogin.Adapter.ProductAdapter;
import com.example.appscheflogin.Model.GetProduct;
import com.example.appscheflogin.Model.GetProfile;
import com.example.appscheflogin.Model.Product;
import com.example.appscheflogin.Model.Profile;
import com.example.appscheflogin.Rest.ApiClient;
import com.example.appscheflogin.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    ApiInterface mApiInterface;
    FragmentActivity ma;

    TextView comment, email, birthdate, gender, height, weight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        comment = (TextView) view.findViewById(R.id.textViewComment);
        email = (TextView) view.findViewById(R.id.textViewEmail);
        birthdate = (TextView) view.findViewById(R.id.textViewBirthdate);
        gender = (TextView) view.findViewById(R.id.textViewGender);
        height = (TextView) view.findViewById(R.id.textViewHeight);
        weight = (TextView) view.findViewById(R.id.textViewWeight);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=getActivity();
        refresh();
        return view;
    }

    public void refresh() {
        Call<GetProfile> productCall = mApiInterface.getProfile();
        productCall.enqueue(new Callback<GetProfile>() {
            @Override
            public void onResponse(Call<GetProfile> call, Response<GetProfile>
                    response) {
                comment.setText(response.body().getProfile().getComment());
                email.setText(response.body().getProfile().getEmail());
                birthdate.setText(response.body().getProfile().getBirthdate());
                gender.setText(response.body().getProfile().getGender());
                height.setText(response.body().getProfile().getHeight());
                weight.setText(response.body().getProfile().getWeight());

            }

            @Override
            public void onFailure(Call<GetProfile> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}

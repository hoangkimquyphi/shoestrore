package com.plvAndroid.shoestore.ui.constract;

import android.content.Context;
import android.util.Log;

import com.plvAndroid.shoestore.data.dao.DatabaseDao;
import com.plvAndroid.shoestore.data.dao.DatabaseSQlite;
import com.plvAndroid.shoestore.data.remote.RetrofitContrller;
import com.plvAndroid.shoestore.data.remote.WebService;
import com.plvAndroid.shoestore.data.remote.entity.Category;
import com.plvAndroid.shoestore.data.remote.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter implements  HomeFragmentConstract.IPresenter{
    private HomeFragmentConstract.IView mView;

    public HomeFragmentPresenter(Context context){

    }
    @Override
    public void setView(HomeFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategoryList() {
        WebService service = RetrofitContrller.service();
        service.categoryList().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mView.setCategoryListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("homepresenter", t.toString());
            }
        });
    }

    @Override
    public void getHotProducts() {
        WebService service = RetrofitContrller.service();
        service.hotProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setHotProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

}

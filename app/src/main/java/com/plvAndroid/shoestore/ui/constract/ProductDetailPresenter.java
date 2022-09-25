package com.plvAndroid.shoestore.ui.constract;

import com.plvAndroid.shoestore.data.remote.RetrofitContrller;
import com.plvAndroid.shoestore.data.remote.entity.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailPresenter implements ProductDetailConstract.IPresenter{
    private ProductDetailConstract.IView mView;
    @Override
    public void setView(ProductDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProduct(int productId) {
        Call<Product> call = RetrofitContrller.service().product(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                mView.setProductToView(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}

package com.plvAndroid.shoestore.ui.constract;

import com.plvAndroid.shoestore.data.remote.entity.Product;

public interface ProductDetailConstract {
    interface IView{
        void setProductToView(Product product);
    }

    interface IPresenter{
        void setView(IView view);
        void getProduct(int productId);
    }
}

package com.plvAndroid.shoestore.ui.constract;

import com.plvAndroid.shoestore.data.remote.entity.Category;
import com.plvAndroid.shoestore.data.remote.entity.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);
        void setHotProductsToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getHotProducts();
    }
}

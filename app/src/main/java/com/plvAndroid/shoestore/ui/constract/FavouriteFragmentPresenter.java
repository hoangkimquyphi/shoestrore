package com.plvAndroid.shoestore.ui.constract;

import com.plvAndroid.shoestore.data.dao.DatabaseDao;
import com.plvAndroid.shoestore.data.dao.model.Favourite;

import java.util.List;

public class FavouriteFragmentPresenter implements FavouriteFragmentConstract.IPresenter{
    private FavouriteFragmentConstract.IView mView;

    @Override
    public void setView(FavouriteFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getFavouriteList() {
        List<Favourite> favouriteList = DatabaseDao.getInstance().getProductDao().all();
        mView.setFavouriteListToView(favouriteList);
    }
}

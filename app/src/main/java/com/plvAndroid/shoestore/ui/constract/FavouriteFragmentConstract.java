package com.plvAndroid.shoestore.ui.constract;

import com.plvAndroid.shoestore.data.dao.model.Favourite;

import java.util.List;

public interface FavouriteFragmentConstract {
    interface IView{
        void setFavouriteListToView(List<Favourite> favouriteList);
    }

    interface IPresenter{
        void setView(IView view);
        void getFavouriteList();
    }
}

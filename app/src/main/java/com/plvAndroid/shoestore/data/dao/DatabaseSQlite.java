package com.plvAndroid.shoestore.data.dao;

import android.content.Context;


import com.plvAndroid.shoestore.data.dao.implement.FavouriteDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }
    @Override
    public FavouriteDao getProductDao() {
        return new FavouriteDaoImplement(context);
    }
}

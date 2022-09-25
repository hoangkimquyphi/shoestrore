package com.plvAndroid.shoestore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.plvAndroid.shoestore.data.dao.DatabaseDao;
import com.plvAndroid.shoestore.data.dao.DatabaseSQlite;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseDao.init(new DatabaseSQlite(this));
    }
}

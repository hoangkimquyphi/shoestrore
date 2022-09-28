package com.plvAndroid.shoestore;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.plvAndroid.shoestore.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.plvAndroid.shoestore.ui.fragment.FavouriteFragment;
import com.plvAndroid.shoestore.ui.fragment.HomeFragment;
import com.plvAndroid.shoestore.ui.fragment.OrderFragment;
import com.plvAndroid.shoestore.ui.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
    }
    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        return true;
                    case R.id.order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                        return true;
                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                        return true;
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }

}
package com.plvAndroid.shoestore;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.plvAndroid.shoestore.BaseActivity;
import com.plvAndroid.shoestore.data.remote.entity.Category;
import com.plvAndroid.shoestore.data.remote.entity.Product;
import com.plvAndroid.shoestore.ui.adapter.ProductAdapter;
import com.plvAndroid.shoestore.ui.constract.CategoryConstract;
import com.plvAndroid.shoestore.ui.constract.CategoryPresenter;
import com.plvAndroid.shoestore.utils.Constants;
import com.squareup.picasso.Picasso;
import com.plvAndroid.shoestore.R;
import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryConstract.IView{
    private CategoryConstract.IPresenter mPresenter;
    private RecyclerView rcCategory;

    private ImageView ivCategoryImage;
    private TextView tvCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initGUI();
        initData();
    }

    private void initGUI(){
        ivCategoryImage = findViewById(R.id.iv_category_image);
        tvCategoryName = findViewById(R.id.tv_category_name);
        rcCategory = findViewById(R.id.rc_category);
    }

    private void initData() {
        int categoryId = getIntent().getIntExtra(Constants.CATEGORY_ID, 1);

        mPresenter = new CategoryPresenter();
        mPresenter.setView(this);
        mPresenter.getProductListByCategory(categoryId);
        mPresenter.getCategory(categoryId);
    }

    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(this, productList);
        rcCategory.setLayoutManager(new LinearLayoutManager(this));
        rcCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCategoryToView(Category category) {
        Picasso.get().load(category.image).into(ivCategoryImage);
        tvCategoryName.setText(category.name);
    }
}
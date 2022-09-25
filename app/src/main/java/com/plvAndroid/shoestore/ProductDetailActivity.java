package com.plvAndroid.shoestore;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.plvAndroid.shoestore.R;
import com.plvAndroid.shoestore.data.dao.DatabaseDao;
import com.plvAndroid.shoestore.data.dao.model.Favourite;
import com.plvAndroid.shoestore.data.remote.entity.Product;
import com.plvAndroid.shoestore.ui.constract.ProductDetailConstract;
import com.plvAndroid.shoestore.ui.constract.ProductDetailPresenter;
import com.plvAndroid.shoestore.utils.Constants;
import com.plvAndroid.shoestore.utils.StringHelper;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends BaseActivity implements ProductDetailConstract.IView {
    private ProductDetailConstract.IPresenter mPresenter;

    private ImageView imgProduct;
    private TextView tvName;
    private TextView tvPrice;

    private ImageButton ibBtnBack;
    private ImageButton ibBtnFavourite;

    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        initGUI();
        initData();
    }

    private void initGUI() {
        imgProduct = findViewById(R.id.img_detail);
        tvName = findViewById(R.id.tv_product_name);
        tvPrice = findViewById(R.id.tv_product_price);

        ibBtnBack = findViewById(R.id.ib_btn_back);
        ibBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ibBtnFavourite = findViewById(R.id.ib_btn_favourite);
        ibBtnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Favourite favourite = new Favourite(
                        mProduct.id,
                        mProduct.name,
                        mProduct.quantity,
                        mProduct.price,
                        mProduct.image,
                        mProduct.categoryId
                );
                DatabaseDao.getInstance().getProductDao().insert(favourite);
            }
        });
    }

    private void initData() {
        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);

        mPresenter = new ProductDetailPresenter();
        mPresenter.setView(this);
        mPresenter.getProduct(productId);
    }

    @Override
    public void setProductToView(Product product) {
        mProduct = product;
        Picasso.get().load(product.image).into(imgProduct);
        tvName.setText(product.name);
        tvPrice.setText(StringHelper.currencyFormat(product.price));
    }
}
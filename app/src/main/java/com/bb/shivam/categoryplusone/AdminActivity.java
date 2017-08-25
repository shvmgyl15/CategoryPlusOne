package com.bb.shivam.categoryplusone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bAddCategory, bAddSubCategory, bAddProduct, bModifyCategoryName, bModifyProduct, bRemoveCategory, bRemoveProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bAddCategory = (Button) findViewById(R.id.bAddCategory);
        bAddSubCategory = (Button) findViewById(R.id.bAddSubCategory);
        bAddProduct = (Button) findViewById(R.id.bAddProduct);
        bModifyCategoryName = (Button) findViewById(R.id.bModifyCategoryName);
        bModifyProduct = (Button) findViewById(R.id.bModifyProduct);
        bRemoveCategory = (Button) findViewById(R.id.bRemoveCategory);
        bRemoveProduct = (Button) findViewById(R.id.bRemoveProduct);

        bAddCategory.setOnClickListener(this);
        bAddSubCategory.setOnClickListener(this);
        bAddProduct.setOnClickListener(this);
        bModifyCategoryName.setOnClickListener(this);
        bModifyProduct.setOnClickListener(this);
        bRemoveCategory.setOnClickListener(this);
        bRemoveProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.bAddCategory:
                intent = new Intent(this, AddCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.bAddSubCategory:
                intent = new Intent(this, AddSubCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.bAddProduct:
                intent = new Intent(this, AddProductActivity.class);
                startActivity(intent);
                break;
            case R.id.bModifyCategoryName:
                intent = new Intent(this, ModifyCategoryNameActivity.class);
                startActivity(intent);
                break;
            case R.id.bModifyProduct:
                intent = new Intent(this, ModifyProductActivity.class);
                startActivity(intent);
                break;
            case R.id.bRemoveCategory:
                intent = new Intent(this, RemoveCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.bRemoveProduct:
                intent = new Intent(this, RemoveProductActivity.class);
                startActivity(intent);
                break;
        }
    }
}

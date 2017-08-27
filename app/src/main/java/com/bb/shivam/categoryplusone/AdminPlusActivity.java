package com.bb.shivam.categoryplusone;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bb.shivam.categoryplusone.model.Category;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdminPlusActivity extends AppCompatActivity{

    private RecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;
//    private DatabaseReference mDatabase;
    private ArrayList<Category> mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_plus);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mCategories = new ArrayList<>();

        mCategories.add(new Category("Category", "root", 0));
        mCategories.add(new Category("Men", "Category", 1));
        mCategories.add(new Category("Dresses", "Men", 2));
        mCategories.add(new Category("Women", "Category", 1));

        mAdapter = new RecyclerAdapter(mCategories);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

//    private void addCategory(){
//        mDatabase = FirebaseDatabase.getInstance().getReference("Category");
//
//    }

}

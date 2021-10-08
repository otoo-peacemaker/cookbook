package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<Item_model_class> model_classesArrList = new ArrayList<>();
    private RecyclerAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);

        mAdapter = new RecyclerAdapter(model_classesArrList);//passing the arrayList into the Adapter

        //managing the items inside the recyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareRecyclerListItem();
    }

    private void prepareRecyclerListItem() {
        //instantiate the model class by passing item to it and adding it to the arrayList variable
        Item_model_class model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);
        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);
        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);
        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        model_class = new Item_model_class("Mad Max: Fury Road", "Action & Adventure", "2015");
        model_classesArrList.add(model_class);

        mAdapter.notifyDataSetChanged();
    }
}
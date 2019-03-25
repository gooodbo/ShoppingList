package com.example.shoppinglist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import com.example.shoppinglist.adapters.AdapterShopList;

import java.util.ArrayList;
import java.util.List;

public class FragmentMain extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdapterShopList adapterShopList;
    private List<ShopList> shopList;
    private Button addField;
    private int i = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        shopList = new ArrayList<>();
        addField = view.findViewById(R.id.addField);

        final ShopList shopListObj = new ShopList();
        shopListObj.setText("1");
        shopList.add(shopListObj);
        shopList.add(shopListObj);
        shopList.add(shopListObj);
        shopList.add(shopListObj);
        shopList.add(shopListObj);
        addField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopList.add(shopListObj);
                recyclerView.refreshDrawableState();
                adapterShopList.notifyDataSetChanged();
            }
        });
        recyclerView = view.findViewById(R.id.recyclerShopLIst);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterShopList = new AdapterShopList(getContext(), shopList);
        recyclerView.setAdapter(adapterShopList);
        return view;

    }
}

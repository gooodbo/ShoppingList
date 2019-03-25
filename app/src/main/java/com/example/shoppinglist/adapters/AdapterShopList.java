package com.example.shoppinglist.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.shoppinglist.R;
import com.example.shoppinglist.ShopList;

import java.util.ArrayList;
import java.util.List;

public class AdapterShopList extends RecyclerView.Adapter<AdapterShopList.ShoppingListViewHolder> {
    private Button addField;
    private List<ShopList> shopList = new ArrayList<>();
    private LayoutInflater mInflater;

    public AdapterShopList(Context context, List<ShopList> shopList) {
        this.shopList = shopList;
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mInflater.inflate(R.layout.custom_edittext, viewGroup, false);
        return new ShoppingListViewHolder(v);
    }

    public static class ShoppingListViewHolder extends RecyclerView.ViewHolder {

        EditText text;
        CheckBox checkBox;
        ImageButton deletBtn;

        public ShoppingListViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.editText1);
            checkBox = itemView.findViewById(R.id.checkBox1);
            deletBtn = itemView.findViewById(R.id.imageButton1);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder shoppingListViewHolder, @SuppressLint("RecyclerView") final int i) {

        shoppingListViewHolder.text.setText(shopList.get(i).getText());
        shoppingListViewHolder.deletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopList.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }


}

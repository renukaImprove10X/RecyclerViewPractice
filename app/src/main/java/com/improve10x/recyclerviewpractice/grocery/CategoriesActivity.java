package com.improve10x.recyclerviewpractice.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {
    ArrayList<Grocery> groceries;
    private ActivityCategoriesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Dunzo");
        setupData();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView groceriesRv = binding.groceriesRv;
        groceriesRv.setLayoutManager(new GridLayoutManager(this, 3));
        GroceriesAdapter groceriesAdapter = new GroceriesAdapter();
        groceriesAdapter.setData(groceries);
        groceriesRv.setAdapter(groceriesAdapter);
    }

    private void setupData() {
        groceries = new ArrayList<Grocery>();
        Grocery grocery = new Grocery("1", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-fresh-fruits-3b26c10dc05d15fbe45ceb3d0eaa816d.png", "Fresh Fruits");
        groceries.add(grocery);
        Grocery grocery1 = new Grocery("2", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-onions-and-tomatos-1986e0017a966f57a20fce08853c25ad.png", "Onions & Tomatoes");
        groceries.add(grocery1);
        Grocery grocery2 = new Grocery("3", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-fresh-vegetables-9799bef8ba92fd03c53f0546ae404a55.png", "Fresh Vegetables");
        groceries.add(grocery2);
        Grocery grocery3 = new Grocery("4", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-exotic-fruits-d5fb208beef0323598ebd4e0c676d2b8.png", "Exotic Fruits");
        groceries.add(grocery3);
        Grocery grocery4 = new Grocery("5", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-mangoes-5dec36e3d054464908f125421f2748c2.png", "Mangoes");
        groceries.add(grocery4);
        Grocery grocery5 = new Grocery("6", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-dairy-91f031697f2e433799e567f021460f9b.png", "Dairy");
        groceries.add(grocery5);
        Grocery grocery6 = new Grocery("7", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-bread-and-buns-ea6fc0dcbc8cd860c88cc1310c64e8d6.png", "Bread & Buns");
        groceries.add(grocery6);
        Grocery grocery7 = new Grocery("8", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-cereal-and-oats-4578a048785cef3231ce946e0385e320.png", "Cereals & Oats");
        groceries.add(grocery7);
        Grocery grocery8 = new Grocery("9", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-horlicks-25492b5096ad52bcd21607c6fc3f03d9.png", "Health Drinks");
        groceries.add(grocery8);
        Grocery grocery9 = new Grocery("10", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-ready-to-eat-9f44b2f69ef008732be5de955293bfe5.png", "Ready-to-eat");
        groceries.add(grocery9);
        Grocery grocery10 = new Grocery("11", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-biscuits-and-cookies-ee0423b9d3478a4c7499cf7f1d32e4bf.png", "Biscuits & Cookies");
        groceries.add(grocery10);
        Grocery grocery11 = new Grocery("12", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-chips-and-namkeen-e3d8b0e18b4b6721cc565d03922ca3d5.png", "Chips & Namkeen");
        groceries.add(grocery11);
        Grocery grocery12 = new Grocery("13", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-tea-and-coffee-683381e7427398452e760dfb6c816e1e.png", "Tea & Coffee");
        groceries.add(grocery12);
        Grocery grocery13 = new Grocery("14", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-softdrinks-and-juice-09a3e724b1b1851ffe9747d4c03eb3b7.png", "Soft Drinks & Juice");
        groceries.add(grocery13);
        Grocery grocery14 = new Grocery("15", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-energy-and-sportsdrinks-8dc82b984a9a536206aa8685dce463b8.png", "Energy & Sports Drinks");
        groceries.add(grocery14);
        Grocery grocery15 = new Grocery("16", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-atta-and-flours-b85c359a33d1a017df2ddc830dbb3172.png", "Atta & Flours");
        groceries.add(grocery15);
        Grocery grocery16 = new Grocery("17", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-baking-essentials-5b3a70840b2f29a6bfd8f08bbc62c339.png", "Baking Essentials");
        groceries.add(grocery16);
        Grocery grocery17 = new Grocery("18", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-cooking-pastes-75b2e7ccc1255261d1a277d63209b1ae.png", "Cooking Pastes");
        groceries.add(grocery17);
        Grocery grocery18 = new Grocery("19", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-masala-and-spices-985e3e74c25545edecc6e13b3f3728fb.png", "Masala & Spices");
        groceries.add(grocery18);
        Grocery grocery19 = new Grocery("20", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-canned-fruit-and-vegetables-c6adef7534b8faa7100c671daab54e2f.png", "Canned Fruits & Vegetables");
        groceries.add(grocery19);
        Grocery grocery20 = new Grocery("21", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-chicken-8883976089fb7016f8b1e0f058fcdd8a.png", "Chicken");
        groceries.add(grocery20);
        Grocery grocery21 = new Grocery("22", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-fish-and-seafood-b692e65b128c6dc49d42a4c39b8dac92.png", "Fish & Seafood");
        groceries.add(grocery21);
        Grocery grocery22 = new Grocery("23", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-mutton-af19fffe878f5d0e057cc44865967cb5.png", "Mutton");
        groceries.add(grocery22);
        Grocery grocery23 = new Grocery("24", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-marinated-cuts-daf965857a0904ab3cc263e2e3c1f672.png", "Marinated Cuts");
        groceries.add(grocery23);
        Grocery grocery24 = new Grocery("25", "https://resources.dunzo.com/web-assets/prod/_next/static/images/dunzo-daily-eggs-e1f42bcafd6d5cd04084de21bad9c494.png", "Eggs");
        groceries.add(grocery24);


    }
}
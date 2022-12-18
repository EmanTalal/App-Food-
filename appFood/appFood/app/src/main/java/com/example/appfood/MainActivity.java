package com.example.appfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Adaptor.CategoryAdapter;
import com.example.appfood.Adaptor.PoplurarAdapter;
import com.example.appfood.Domain.CatogryDomain;
import com.example.appfood.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopulerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerViewCategory();
        recyclerViwePopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager (this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById (R.id.recyclerView4);
        recyclerViewCategoryList.setLayoutManager (linearLayoutManager);

        ArrayList<CatogryDomain> catogry=new ArrayList<> ();
        catogry.add (new CatogryDomain ("Pizza","cat_11"));
        catogry.add (new CatogryDomain ("Burger","cat_22"));
        catogry.add (new CatogryDomain ("Hotdog","cat_33"));
        catogry.add (new CatogryDomain ("Drink","cat_44"));
        catogry.add (new CatogryDomain ("Donut","cato_5"));

        adapter= new CategoryAdapter(catogry);
        recyclerViewCategoryList.setAdapter (adapter);
    }
    private void recyclerViwePopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager (this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopulerList=findViewById(R.id.cartBtn);
        recyclerViewPopulerList.setLayoutManager (linearLayoutManager);


        ArrayList<FoodDomain> foodList=new ArrayList<> ();
        foodList.add (new FoodDomain ("Pepperoni pizza","pop_1","slices pepperoni,mozzerella cheese ,fresh oregano,ground black pepper sauce",9.76));
        foodList.add (new FoodDomain ("cheese Burger","pop_2","beef, Gouda Cheese,Special Sauce, Lettuce,tomato",8.79));
        foodList.add (new FoodDomain ("Vegetable pizza","pop_3", "olive oil,Vegetable oil , pitted Kalamate ,Cherry tomatoes,fresh oregon,basil",8.5));

        adapter2 =new PoplurarAdapter (foodList);
        recyclerViewPopulerList.setAdapter (adapter2);
    }
}
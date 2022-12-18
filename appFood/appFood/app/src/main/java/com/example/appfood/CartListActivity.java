package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.appfood.Activity.IntroActivity;
import com.example.appfood.Adaptor.CartListAdapter;
import com.example.appfood.helper.ManagementCart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
        private RecyclerView.Adapter adapter;
        private RecyclerView recyclerViewList;
        private ManagementCart managementCart;
        TextView totalFreeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
        private double tax;
        private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cart_list);



        managementCart=new ManagementCart (this);

        intiView();
        initList();
        Calculated();
        bottamNavigation();

    }

    private void bottamNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (CartListActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (CartListActivity.this, MainActivity.class));
            }
        });
    }

    private void  intiView(){
        recyclerViewList=findViewById(R.id.recyclerView4);
        totalFreeTxt=findViewById(R.id.totalFreeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewList=findViewById(R.id.vartView);


    }

    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager (this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter (managementCart.getListCart (), this, new ChangeNumberitemListener () {
            @Override
            public void changed() {
                Calculated();

            }
        });
        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
                emptyTxt.setVisibility (View.GONE);
                scrollView.setVisibility (View.VISIBLE);

        }

    }
        private  void Calculated(){
        double precentTax=0.02;
        double delivery=10;

        tax=Math.round((managementCart.getTotalFee()*precentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round((managementCart.getTotalFee ()*100)/100);

        totalFreeTxt.setText("ر.س"+itemTotal);
        taxTxt.setText ("ر.س"+tax);
        deliveryTxt.setText("ر.س"+delivery);
        totalTxt.setText ("ر.س"+total);
        }
}
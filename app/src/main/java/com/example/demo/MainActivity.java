package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo danh sách sản phẩm
        productList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            productList.add(new Product("Product " + i, "Description " + i));
        }

        productAdapter = new ProductAdapter(productList, this::onBuyNowClicked, this::onDeleteClicked);
        recyclerView.setAdapter(productAdapter);
    }

    private void onBuyNowClicked(Product product) {
        Toast.makeText(this, "Buy Now: " + product.getName(), Toast.LENGTH_SHORT).show();
    }

    private void onDeleteClicked(Product product) {
        productList.remove(product);
        productAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted: " + product.getName(), Toast.LENGTH_SHORT).show();
    }
}
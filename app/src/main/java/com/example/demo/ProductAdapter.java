package com.example.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;
    private final OnProductClickListener buyNowListener;
    private final OnProductClickListener deleteListener;

    public ProductAdapter(List<Product> productList, OnProductClickListener buyNowListener, OnProductClickListener deleteListener) {
        this.productList = productList;
        this.buyNowListener = buyNowListener;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductDescription.setText(product.getDescription());

        holder.btnBuyNow.setOnClickListener(v -> buyNowListener.onClick(product));
        holder.btnDelete.setOnClickListener(v -> deleteListener.onClick(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductDescription;
        Button btnBuyNow;
        ImageView btnDelete;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
            btnBuyNow = itemView.findViewById(R.id.btnBuyNow);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    public interface OnProductClickListener {
        void onClick(Product product);
    }
}

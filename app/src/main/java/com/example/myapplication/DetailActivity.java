package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences; //
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImageView;
    private TextView detailTextView;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImageView = findViewById(R.id.detailImageView);
        detailTextView = findViewById(R.id.detailTextView);
        orderButton = findViewById(R.id.orderButton);

        // Nhận đối tượng Food từ Intent
        Food food = getIntent().getParcelableExtra("foodItem");

        if (food != null) {
            detailImageView.setImageResource(food.getImageResId());
            detailTextView.setText("Tên: " + food.getName() +
                    "\nMô tả: " + food.getDescription() +
                    "\nGiá: " + food.getPrice() + " VND");


            SharedPreferences prefsLastViewed = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
            SharedPreferences.Editor editorLastViewed = prefsLastViewed.edit();
            editorLastViewed.putString("lastFoodName", food.getName());
            editorLastViewed.apply();

            // Xử lý sự kiện cho nút "Gọi món"
            orderButton.setOnClickListener(v -> {
                Toast.makeText(this, "Bạn đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();

                // CÂU 2: Lưu món ăn đã gọi vào SharedPreferences [cite: 8, 32]
                SharedPreferences prefsOrdered = getSharedPreferences("OrderedFood", MODE_PRIVATE);
                SharedPreferences.Editor editorOrdered = prefsOrdered.edit();
                editorOrdered.putString("orderedFoodName", food.getName());
                editorOrdered.apply();
            });
        }
    }
}
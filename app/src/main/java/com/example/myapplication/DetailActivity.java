package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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


        Food food = getIntent().getParcelableExtra("foodItem");

        if (food != null) {
            detailImageView.setImageResource(food.getImageResId());
            detailTextView.setText("Tên: " + food.getName() +
            "\nMô tả: " + food.getDescription() +
            "\nGiá: " + food.getPrice() + " VND");


            orderButton.setOnClickListener(v -> {
                Toast.makeText(this, "Bạn đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}
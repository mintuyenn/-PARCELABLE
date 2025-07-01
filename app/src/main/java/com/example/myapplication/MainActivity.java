package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;
    private TextView lastViewedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastViewedTextView = findViewById(R.id.lastViewedTextView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu mẫu
        foodList = new ArrayList<>();
        foodList.add(new Food("Phở Bò", R.drawable.phobo, "Phở truyền thống Việt Nam.", 50000));
        foodList.add(new Food("Bún Chả", R.drawable.buncha, "Bún chả Hà Nội nổi tiếng.", 45000));
        foodList.add(new Food("Gỏi Cuốn", R.drawable.goicuon, "Gỏi cuốn tươi ngon.", 30000));

        foodAdapter = new FoodAdapter(this, foodList);
        recyclerView.setAdapter(foodAdapter);

        // Hiển thị món vừa xem (nếu có)
        SharedPreferences prefsLastViewed = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
        String lastFood = prefsLastViewed.getString("lastFoodName", "Bạn chưa xem món ăn nào");
        lastViewedTextView.setText("Bạn vừa xem: " + lastFood);

        // Kiểm tra món đã gọi (nếu có)
        SharedPreferences prefsOrdered = getSharedPreferences("OrderedFood", MODE_PRIVATE);
        String orderedFood = prefsOrdered.getString("orderedFoodName", null);
        if (orderedFood != null) {
            Toast.makeText(this, "Bạn đã gọi món: " + orderedFood, Toast.LENGTH_LONG).show();
        }
    }
}

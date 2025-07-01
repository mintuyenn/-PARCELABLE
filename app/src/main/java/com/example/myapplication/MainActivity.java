package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();

        foodList.add(new Food("Phở Bò", R.drawable.phobo, "Món phở truyền thống của Việt Nam với thịt bò và nước dùng đậm đà.", 50000));
        foodList.add(new Food("Bún Chả", R.drawable.buncha, "Bún chả Hà Nội nổi tiếng với thịt nướng thơm lừng và nem rán.", 45000));
        foodList.add(new Food("Gỏi Cuốn", R.drawable.goicuon, "Gỏi cuốn tươi ngon với tôm, thịt và rau sống, chấm nước mắm chua ngọt.", 30000));


        foodAdapter = new FoodAdapter(this, foodList);
        recyclerView.setAdapter(foodAdapter);
    }
}
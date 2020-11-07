package com.example.ltts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class WinnersActivity extends AppCompatActivity {
    RecyclerView winnersRecyclerView;
    String s1[],s2[];
    int images[]={R.drawable.music_male,
            R.drawable.music_female,
            R.drawable.dance_win,
            R.drawable.sketching_win,
            R.drawable.specialentries_win,
            R.drawable.graphics_win,
            R.drawable.photography_win,
            R.drawable.craft,
            R.drawable.poetry_win};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);
        winnersRecyclerView = findViewById(R.id.winnersRecyclerView);
        s1 = getResources().getStringArray(R.array.Winners_List);
        s2 = getResources().getStringArray(R.array.Description);
        WinnersAdapter winnersAdapter=new WinnersAdapter(this,s1,s2,images);
        winnersRecyclerView.setAdapter(winnersAdapter);
        winnersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
package com.makeup.garbagesorter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);



        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button:
                Toast.makeText(this, "All", Toast.LENGTH_SHORT).show();
                Intent int1 = new Intent(MainActivity.this, All.class);
                startActivity(int1);
                break;
            case R.id.button1:
                Toast.makeText(this, "Recycle", Toast.LENGTH_SHORT).show();
                Intent int2 = new Intent(MainActivity.this, Recycle.class);
                startActivity(int2);
                break;
            case R.id.button2:
                Toast.makeText(this, "Compost", Toast.LENGTH_SHORT).show();
                Intent int3 = new Intent(MainActivity.this, Compost.class);
                startActivity(int3);
                break;
            case R.id.button3:
                Toast.makeText(this, "Waste", Toast.LENGTH_SHORT).show();
                Intent int4 = new Intent(MainActivity.this, Waste.class);
                startActivity(int4);
                break;
            case R.id.button4:
                Toast.makeText(this, "Hazard", Toast.LENGTH_SHORT).show();
                Intent int5 = new Intent(MainActivity.this, Hazardous.class);
                startActivity(int5);
                break;
        }
    }
}

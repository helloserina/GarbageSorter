package com.makeup.garbagesorter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class Hazardous extends AppCompatActivity {

    ListView search_hazard;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazardous);

        search_hazard = (ListView) findViewById(R.id.my_hazardous);

        ArrayList<String> arrayGarbage = new ArrayList<>();
        arrayGarbage.addAll(Arrays.asList(getResources().getStringArray(R.array.my_hazardous)));

        adapter = new ArrayAdapter<String>(
                Hazardous.this,
                android.R.layout.simple_list_item_1,
                arrayGarbage
        );

        search_hazard.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hazard, menu);
        MenuItem item = menu.findItem(R.id.my_hazardous);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}

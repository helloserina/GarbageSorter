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

public class All extends AppCompatActivity {

    ListView search_all;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        search_all = (ListView) findViewById(R.id.my_all);

        ArrayList<String> arrayGarbage = new ArrayList<>();
        arrayGarbage.addAll(Arrays.asList(getResources().getStringArray(R.array.my_all)));

        adapter = new ArrayAdapter<String>(
                All.this,
                android.R.layout.simple_list_item_1,
                arrayGarbage
        );

        search_all.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_all, menu);
        MenuItem item = menu.findItem(R.id.my_all);
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

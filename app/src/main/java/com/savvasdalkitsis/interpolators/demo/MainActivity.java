package com.savvasdalkitsis.interpolators.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static com.savvasdalkitsis.interpolators.demo.HardCodedInterpolators.INTERPOLATORS;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.column_count)));
        recyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.card_spacing)));
        recyclerView.setAdapter(new InterpolatorsAdapter(INTERPOLATORS));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.play_all) {
            int childCount = recyclerView.getChildCount();
            for (int i=0; i< childCount; i++) {
                View view = recyclerView.getChildAt(i).findViewById(R.id.interpolation_view);
                if (view != null) {
                    view.performClick();
                }
            }
            return true;
        }
        return false;
    }
}

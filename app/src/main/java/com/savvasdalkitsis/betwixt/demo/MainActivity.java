/*
 * Copyright (C) 2016 Savvas Dalkitsis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savvasdalkitsis.betwixt.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.savvasdalkitsis.butterknifeaspects.aspects.BindLayout;
import com.shazam.android.aspects.base.activity.AspectAppCompatActivity;

import butterknife.Bind;

import static com.savvasdalkitsis.betwixt.demo.HardCodedInterpolators.INTERPOLATORS;

@BindLayout(R.layout.activity_main)
public class MainActivity extends AspectAppCompatActivity {

    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        switch (item.getItemId()) {
            case R.id.play_all:
                playAllVisibleInterpolators();
                return true;
            case R.id.about:
                showAboutDialog();
                return true;
        }
        return false;
    }

    private void showAboutDialog() {
        new AboutDialog().show(getSupportFragmentManager(), "about");
    }

    private void playAllVisibleInterpolators() {
        int childCount = recyclerView.getChildCount();
        for (int i=0; i< childCount; i++) {
            View view = recyclerView.getChildAt(i).findViewById(R.id.interpolation_view);
            if (view != null) {
                view.performClick();
            }
        }
    }
}

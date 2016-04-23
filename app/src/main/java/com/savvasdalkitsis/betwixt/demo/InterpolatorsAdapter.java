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

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import static android.view.LayoutInflater.from;

class InterpolatorsAdapter extends RecyclerView.Adapter<InterpolatorsAdapter.ItemHolder> {

    private final Pair<Interpolator, String>[] interpolators;

    public InterpolatorsAdapter(Pair<Interpolator, String>[] interpolators) {
        this.interpolators = interpolators;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        InterpolatorView view = (InterpolatorView)
                from(parent.getContext()).inflate(R.layout.view_interpolator, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        InterpolatorView interpolatorView = holder.interpolatorView;
        interpolatorView.setInterpolator(interpolators[position].first);
        interpolatorView.setDescription(interpolators[position].second);
    }

    @Override
    public int getItemCount() {
        return interpolators.length;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        private final InterpolatorView interpolatorView;

        public ItemHolder(View interpolationView) {
            super(card(interpolationView));
            this.interpolatorView = (InterpolatorView) interpolationView;
        }

        @NonNull
        private static CardView card(View itemView) {
            CardView cardView = new CardView(itemView.getContext());
            cardView.setCardElevation(itemView.getResources().getDimensionPixelSize(R.dimen.card_elevation));
            cardView.addView(itemView);
            return cardView;
        }
    }
}

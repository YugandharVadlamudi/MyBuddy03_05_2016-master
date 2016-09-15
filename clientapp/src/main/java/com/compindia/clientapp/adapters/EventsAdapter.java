package com.compindia.clientapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kiran on 30-08-2016.
 */
public class EventsAdapter extends RecyclerView.Adapter {
    public EventsAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class EventsPostViewHolder extends RecyclerView.ViewHolder {
        public EventsPostViewHolder(View itemView) {
            super(itemView);
        }
    }
}

package com.compindia.googlemusicplayerapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.compindia.googlemusicplayerapp.HideToolBarActivity;
import com.compindia.googlemusicplayerapp.R;
import com.compindia.googlemusicplayerapp.utils.AppInfoClass;
import com.compindia.googlemusicplayerapp.utils.FontAwesomeIcion;
import com.compindia.googlemusicplayerapp.utils.TextVIewRobotoLight;

import java.util.List;

/**
 * Created by Kiran on 29-08-2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DemoViewHolder> implements RecyclerView.OnItemTouchListener {
    List<AppInfoClass> listAppInfoClass;
    AppInfoClass appInfoClass;
    Context context;

    private String TAG = RecyclerAdapter.class.getSimpleName();

    public RecyclerAdapter(Context applicationContext, List<AppInfoClass> listAppInfoClass) {
        this.listAppInfoClass = listAppInfoClass;
        context=applicationContext;
        Log.d(TAG, "RecyclerAdapter: size->" + this.listAppInfoClass.size());
    }

    @Override
    public RecyclerAdapter.DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder:");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycleritem
                , parent, false);
        Log.d(TAG, "onCreateViewHolder: view->"+view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "item click->"+view, Snackbar.LENGTH_SHORT).show();
                view.getContext().startActivity(new Intent(context, HideToolBarActivity.class));
            }
        });
        DemoViewHolder viewHolder = new DemoViewHolder(view);
        return viewHolder;
//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.DemoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: position->" + position);
        appInfoClass = listAppInfoClass.get(position);
        holder.textView.setText(appInfoClass.getAppName());
        holder.imageView.setImageDrawable(appInfoClass.getDrawable());
        holder.fontAwesomeIcion.setText(Html.fromHtml("\ue134"));
    }

    @Override
    public int getItemCount() {

        return this.listAppInfoClass.size();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        TextVIewRobotoLight textView;
        ImageView imageView;
        FontAwesomeIcion fontAwesomeIcion;
        public DemoViewHolder(View itemView) {
            super(itemView);
            textView = (TextVIewRobotoLight) itemView.findViewById(R.id.tv_recycleritem_appname);
            imageView = (ImageView) itemView.findViewById(R.id.iv_recycleritem_appicon);
            fontAwesomeIcion = (FontAwesomeIcion) itemView.findViewById(R.id.fai_show);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "the position->" + getAdapterPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}

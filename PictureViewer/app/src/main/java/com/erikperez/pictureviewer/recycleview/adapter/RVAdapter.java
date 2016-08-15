package com.erikperez.pictureviewer.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.erikperez.pictureviewer.R;
import com.erikperez.pictureviewer.recycleview.model.RowInformation;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by GoreT on 8/13/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVViewHolder> {

    private LayoutInflater inflater;
    private List<RowInformation> data = Collections.emptyList();
    private Context context;

    public RVAdapter(Context context, List<RowInformation> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        RVViewHolder viewHolder = new RVViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        RowInformation current = data.get(position);
        holder.titleView.setText(current.getTitle());
        holder.descriptionView.setText(current.getDescription());
        holder.icon.setImageResource(current.getIconId());

        Picasso.with(context).load(current.getImagelink()).into(holder.picassoImageView);

        setAnimation(holder.container);
    }

    private void setAnimation(View viewToAnimate) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

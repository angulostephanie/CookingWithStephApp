package com.example.stephanieangulo.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class RecipeAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Recipe> mRecipeList;
    private LayoutInflater mInflater;

    // constructor
    public RecipeAdapter(Context mContext, ArrayList<Recipe> mRecipeList) {
        // initialize instance variables
        this.mContext = mContext;
        this.mRecipeList = mRecipeList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mRecipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRecipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null) {
        /*
            view = mInflater.inflate(R.layout.recipe_list_item, viewGroup, false);

            holder = new ViewHolder();

            holder.titleTextView = view.findViewById(R.id.recipe_list_item_title);
            holder.thumbnailImageView = view.findViewById(R.id.recipe_list_img);
            holder.servingTextView = view.findViewById(R.id.recipe_list_item_servings);

            view.setTag(holder);
         */

        } else {
            /*
            holder = (ViewHolder) view.getTag();

            TextView titleTextView = holder.titleTextView;
            TextView servingTextView = holder.servingTextView;
            ImageView thumbnailImageView = holder.thumbnailImageView;

            Recipe recipe = (Recipe) getItem(i);
            titleTextView.setText(recipe.title);

            titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            titleTextView.setTextSize(18);

            servingTextView.setText(recipe.servings + " servings");
            servingTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
            servingTextView.setTextSize(14);
            Picasso.with(mContext).load(recipe.imageURL).into(thumbnailImageView);

             */
         }

        return view;
    }
    private static class ViewHolder {
        public TextView titleTextView;
        public TextView servingTextView;
        public ImageView thumbnailImageView;

    }
}

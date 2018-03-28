package com.example.stephanieangulo.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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

            view = mInflater.inflate(R.layout.activity_result_item, viewGroup, false);

            holder = new ViewHolder();

            holder.titleTextView = view.findViewById(R.id.recipe_item_title);
            holder.thumbnailImageView = view.findViewById(R.id.recipe_item_image);
            holder.servingTextView = view.findViewById(R.id.recipe_item_servings);
            holder.prepTimeTextView = view.findViewById(R.id.recipe_item_prep_time);
            holder.dietLabelTextView = view.findViewById(R.id.recipe_item_diet_label);
            holder.cookBtn = view.findViewById(R.id.recipe_item_cook_btn);

            view.setTag(holder);
            view.setEnabled(false);
            view.setOnClickListener(null);


        } else {

            holder = (ViewHolder) view.getTag();
        }
            TextView titleTextView = holder.titleTextView;
            TextView servingTextView = holder.servingTextView;
            TextView prepTimeTextView = holder.prepTimeTextView;
            TextView dietLabelTextView = holder.dietLabelTextView;
            ImageView thumbnailImageView = holder.thumbnailImageView;
            Button cookBtn = holder.cookBtn;

            Recipe recipe = (Recipe) getItem(i);
            titleTextView.setText(recipe.title);
            String servings = recipe.servings + " servings";
            servingTextView.setText(servings);
            prepTimeTextView.setText(recipe.prepTime);
            prepTimeTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            dietLabelTextView.setText(recipe.dietLabel);
            dietLabelTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));

            //Picasso.with(mContext).load(recipe.imageURL).into(thumbnailImageView);


        return view;
    }
    private static class ViewHolder {
        public TextView titleTextView;
        public TextView servingTextView;
        public TextView prepTimeTextView;
        public TextView dietLabelTextView;
        public ImageView thumbnailImageView;
        public Button cookBtn;

    }
}

package com.example.stephanieangulo.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class ResultActivity extends AppCompatActivity {
    ListView mListView;
    Context mContext;
    //Map<String, Integer> servings = Map.of("Less than 4", 4);//new HashMap<>();
//    Map<String, >
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mContext = this;
        final ArrayList<Recipe> recipes =  Recipe.getRecipesFromJSON("recipes.json", mContext);

        RecipeAdapter adapter = new RecipeAdapter(mContext, filterResults(recipes, new ArrayList<String>()));

        mListView = findViewById(R.id.resultListView);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
            }
        });
    }
    private ArrayList<Recipe> filterResults(ArrayList<Recipe> recipes, ArrayList<String> parameters) {
        if(parameters.isEmpty())
            return recipes;

        for(int i = 0; i < parameters.size(); i++) {

        }
        return null;
    }

    private void orderResults(ArrayList<Recipe> results) {

    }

}

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mContext = this;
        final ArrayList<Recipe> recipes =  Recipe.getRecipesFromJSON("recipes.json", this);
        RecipeAdapter adapter = new RecipeAdapter(this, recipes);
        mListView = findViewById(R.id.resultListView);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
            }
        });
    }

}

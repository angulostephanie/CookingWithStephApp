package com.example.stephanieangulo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class SearchActivity extends AppCompatActivity {
    Spinner dietSpinner;
    Spinner servingSpinner;
    Spinner prepSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final ArrayList<Recipe> recipes =  Recipe.getRecipesFromJSON("recipes.json", this);
        dietSpinner = findViewById(R.id.dietSpinner);
        servingSpinner = findViewById(R.id.servingSpinner);
        prepSpinner = findViewById(R.id.prepSpinner);

        Set<String> dietItems = new HashSet<>();
        Set<Integer> servingItems = new HashSet<>();
        Set<String> prepItems = new HashSet<>();

        for(int i = 0; i< recipes.size(); i++) {
            dietItems.add(recipes.get(i).dietLabel);
            servingItems.add(recipes.get(i).servings);
            prepItems.add(recipes.get(i).prepTime);
        }
        orderOptions(dietItems);
        ArrayAdapter<String> dietAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(dietItems));
        dietSpinner.setAdapter(dietAdapter);

        ArrayAdapter<Integer> servingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(servingItems));
        servingSpinner.setAdapter(servingAdapter);

        ArrayAdapter<String> prepAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(prepItems));
        prepSpinner.setAdapter(prepAdapter);

    }

    public void orderOptions(Set set) {
        System.out.println(set.getClass().getSimpleName());
        if(set.getClass().getSimpleName().equals("String")) {
            System.out.println("DJFAKLSJFAL;KSFK");
        }
        //Collections.sort(new ArrayList(set), String.CASE_INSENSITIVE_ORDER);
    }
}

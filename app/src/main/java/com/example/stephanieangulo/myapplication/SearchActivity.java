package com.example.stephanieangulo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final ArrayList<Recipe> recipes =  Recipe.getRecipesFromJSON("recipes.json", this);
        dietSpinner = findViewById(R.id.dietSpinner);
        servingSpinner = findViewById(R.id.servingSpinner);
        prepSpinner = findViewById(R.id.prepSpinner);
        searchBtn = findViewById(R.id.get_results_btn);

        Set<String> dietItems = new HashSet<>();
        Set<Integer> servingItems = new HashSet<>();
        Set<String> prepItems = new HashSet<>();

        for(int i = 0; i< recipes.size(); i++) {
            dietItems.add(recipes.get(i).dietLabel);
            servingItems.add(recipes.get(i).servings);
            prepItems.add(recipes.get(i).prepTime);
        }

        ArrayAdapter<String> dietAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(dietItems));
        ArrayAdapter<Integer> servingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(servingItems));
        ArrayAdapter<String> prepAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(prepItems));

        dietSpinner.setAdapter(dietAdapter);
        servingSpinner.setAdapter(servingAdapter);
        prepSpinner.setAdapter(prepAdapter);


        dietSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        servingSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        prepSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println();
            }
        });

    }

    private ArrayList<String> condenseOptions() {
    /*
    Serving Restriction: you need to have the following options: “less than 4”, “4-6”, “7-9”, “more than 10”.
    Preparation Time is stored as a String in the JSON file so you need to parse each string to get the number and
    the unit. You need to have the following options for the dropdown menu: “30 minutes or less”, “less than 1 hour”,
    “more than 1 hour”. Note that the “less than 1 hour” option also contains the results of “30 minutes or less”.
     */
        return null;
    }

}

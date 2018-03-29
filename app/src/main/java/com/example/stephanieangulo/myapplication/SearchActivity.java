package com.example.stephanieangulo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class SearchActivity extends AppCompatActivity {
    Spinner dietSpinner;
    Spinner servingSpinner;
    Spinner prepSpinner;
    Button searchBtn;
    String dietLabel = " ";
    String servings = " ";
    String prepTime = " ";
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = this;
        Recipe recipe = new Recipe();

        dietSpinner = findViewById(R.id.dietSpinner);
        servingSpinner = findViewById(R.id.servingSpinner);
        prepSpinner = findViewById(R.id.prepSpinner);
        searchBtn = findViewById(R.id.get_results_btn);

        final String[] servingItems = {" ", "Less than 4", "4-6", "7-9", "More than 10"};
        String[] prepItems = {" ","30 min or less", "Less than 1 hour", "More than 1 hour"};
        ArrayList<String> dietItems = recipe.getAllDietLabels(this);

        ArrayAdapter<String> dietAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dietItems);
        ArrayAdapter<String> servingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(Arrays.asList(servingItems)));
        ArrayAdapter<String> prepAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>(Arrays.asList(prepItems)));

        dietSpinner.setAdapter(dietAdapter);
        servingSpinner.setAdapter(servingAdapter);
        prepSpinner.setAdapter(prepAdapter);

        dietSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dietLabel = dietSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dietLabel = " ";
            }
        });

        servingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                servings = servingSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                servings = " ";
            }
        });

        prepSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prepTime = prepSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                prepTime = " ";
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

    }


    private void launchActivity() {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra("dietLabel", dietLabel);
        resultIntent.putExtra("servings", servings);
        resultIntent.putExtra("prepTime", prepTime);
        startActivityForResult(resultIntent, 1);
    }

}

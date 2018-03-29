package com.example.stephanieangulo.myapplication;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class Recipe {
    String title, imageURL, webURL, description, prepTime, dietLabel;
    int servings, prepTimeConverted;

    public static ArrayList<Recipe> getRecipesFromJSON(String filename, Context context) {
        ArrayList<Recipe> recipesList = new ArrayList<>();
        try {
            String x = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(x);
            JSONArray recipes = json.getJSONArray("recipes");
            for(int i = 0; i < recipes.length(); i++) {
                Recipe recipe = new Recipe();
                recipe.title = recipes.getJSONObject(i).getString("title");
                recipe.imageURL = recipes.getJSONObject(i).getString("image");
                recipe.webURL = recipes.getJSONObject(i).getString("url");
                recipe.description = recipes.getJSONObject(i).getString("description");
                recipe.servings = recipes.getJSONObject(i).getInt("servings");
                recipe.prepTime = recipes.getJSONObject(i).getString("prepTime");
                recipe.dietLabel = recipes.getJSONObject(i).getString("dietLabel");
                recipe.prepTimeConverted = recipe.convertPrepTime(recipe.prepTime);
                recipesList.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipesList;
    }
    public ArrayList<String> getAllDietLabels(Context context) {
        Set<String> dietLabels = new HashSet<>();
        ArrayList<Recipe> recipes = getRecipesFromJSON("recipes.json", context);
        for(int i = 0; i< recipes.size(); i++) {
            dietLabels.add(recipes.get(i).dietLabel);
        }
        ArrayList<String> list = new ArrayList<>(dietLabels);
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        list.add(0, " ");
        return list;
    }

    private int convertPrepTime(String prepTime) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(prepTime.split(" ")));
        if(words.contains("and"))
            words.remove("and");

        int time = 0;
        for(int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if(word.equals("hour") || word.equals("hours")) {
                String previousWord = words.get(i-1);
                int hour = Integer.valueOf(previousWord);
                time+= hour*60;
            }
            if(word.equals("minute") || word.equals("minutes")) {
                String previousWord = words.get(i-1);
                int minutes = Integer.valueOf(previousWord);
                time+= minutes;
            }
        }
        return time;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

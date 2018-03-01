package com.example.stephanieangulo.myapplication;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by stephanieangulo on 3/1/18.
 */

public class Recipe {
    String title, imageURL, webURL, description, prepTime, dietLabel;
    int servings;

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

                recipesList.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipesList;
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

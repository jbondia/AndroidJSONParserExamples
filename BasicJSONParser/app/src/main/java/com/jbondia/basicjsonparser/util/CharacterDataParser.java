package com.jbondia.basicjsonparser.util;

import android.util.Log;

import com.jbondia.basicjsonparser.model.Armor;
import com.jbondia.basicjsonparser.model.Character;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

;

/**
 * Created by jbondia on 11/03/15.
 */
public class CharacterDataParser {

    private static String LOG_TAG = "CharacterDataParser";

    public static Character jsonCharacterParser(JSONObject jsonObject) {

        try {
            /* Get values of simple attributes in Character */
            long id = jsonObject.getLong("id");
            int gold = jsonObject.getInt("gold");
            int level = jsonObject.getInt("level");
            String race = jsonObject.getString("race");
            String type = jsonObject.getString("class");
            String name = jsonObject.getString("name");
            JSONArray armors = jsonObject.getJSONArray("armor");

            return new Character(id, gold, level, name, type, race,
                                jsonArmorParser(armors));

        } catch (JSONException ex) {
            Log.e(LOG_TAG, "Error parsing json: " + ex.getMessage());
        }

        return null;
    }

    private static ArrayList<Armor> jsonArmorParser(JSONArray jsonArray) {

        int level;
        String name;
        Armor armor;
        ArrayList<Armor> armors = new ArrayList<>();

        try {
            for(int i = 0; i < jsonArray.length(); i++) {
                level = jsonArray.getJSONObject(i).getInt("ilevel");
                name = jsonArray.getJSONObject(i).getString("name");
                armor = new Armor(level, name);
                armors.add(armor);
                armor = null;
            }

            /*
            for(Armor a : armors) {
                Log.i(LOG_TAG, a.toString());
            }
            */

            return armors;

        } catch (JSONException ex) {
            Log.e(LOG_TAG, "Error parsing json: " + ex.getMessage());
        }

        return null;
    }
}

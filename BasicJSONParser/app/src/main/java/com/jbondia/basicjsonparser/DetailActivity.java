package com.jbondia.basicjsonparser;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jbondia.basicjsonparser.model.Armor;
import com.jbondia.basicjsonparser.model.Character;

import java.util.ArrayList;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        private static String CHARACTER_PARAM = "character";

        private ArrayAdapter<String> mArmorAdapter;

        public DetailFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            final ListView armorListVIew = (ListView) rootView.findViewById(R.id.listview_armor);

            this.mArmorAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_armor,
                    R.id.list_item_armor, new ArrayList<String>());
            armorListVIew.setAdapter(mArmorAdapter);

            Intent fromCharacter = getActivity().getIntent();
            Character character = (Character) fromCharacter.getSerializableExtra(CHARACTER_PARAM);

            TextView nameTextView = (TextView) rootView.findViewById(R.id.name_title);
            nameTextView.setText(character.getName());

            TextView raceTextView = (TextView) rootView.findViewById(R.id.race_title);
            raceTextView.setText(character.getRace());

            TextView levelTextView = (TextView) rootView.findViewById(R.id.level_param);
            levelTextView.setText(Long.toString(character.getLevel()));

            TextView classTextView = (TextView) rootView.findViewById(R.id.type_param);
            classTextView.setText(character.getType());

            TextView goldTextView = (TextView) rootView.findViewById(R.id.gold_param);
            goldTextView.setText(Long.toString(character.getGold()));

            for(Armor armor : character.getArmors())
                mArmorAdapter.add(armor.toString());

            return rootView;
        }
    }
}

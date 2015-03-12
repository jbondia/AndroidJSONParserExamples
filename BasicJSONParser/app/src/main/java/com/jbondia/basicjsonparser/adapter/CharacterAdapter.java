package com.jbondia.basicjsonparser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jbondia.basicjsonparser.R;
import com.jbondia.basicjsonparser.model.Character;

import java.util.ArrayList;

/**
 * Created by jbondia on 11/03/15.
 */
public class CharacterAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Character> mCharacterList;

    public CharacterAdapter(Context context) {
        this.mContext = context;
        this.mCharacterList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mCharacterList.size();
    }

    @Override
    public Character getItem(int position) {
        return mCharacterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCharacterList.get(position).getId();
    }

    public void setItem(Character character) {
        mCharacterList.add(character);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null)
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_character, null);

        Character character = getItem(position);
        TextView nameView = (TextView) view.findViewById(R.id.list_item_character);
        nameView.setText(character.getName());

        return view;
    }
}

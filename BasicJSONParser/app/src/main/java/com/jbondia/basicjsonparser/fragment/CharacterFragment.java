package com.jbondia.basicjsonparser.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jbondia.basicjsonparser.DetailActivity;
import com.jbondia.basicjsonparser.R;
import com.jbondia.basicjsonparser.adapter.CharacterAdapter;
import com.jbondia.basicjsonparser.delegate.AsyncDelegate;
import com.jbondia.basicjsonparser.model.Character;
import com.jbondia.basicjsonparser.task.GetCharacterTask;

/**
 * Created by jbondia on 11/03/15.
 */
public class CharacterFragment extends Fragment implements AsyncDelegate, AdapterView.OnItemClickListener {

    private static String CHARACTER_PARAM = "character";

    private CharacterAdapter mCharacterAdapter;

    public CharacterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ListView characterListView = (ListView) getActivity().findViewById(R.id.listview_character);
        mCharacterAdapter = new CharacterAdapter(getActivity());
        characterListView.setAdapter(mCharacterAdapter);
        characterListView.setOnItemClickListener(this);

        /* 10.110.184.181 */
        /* 192.168.1.4 */
        new GetCharacterTask(getActivity(), this).execute(
                "http://10.110.184.181:8080/simple_backend/api/v1/character"
        );
    }


    @Override
    public void asyncComplete(Object object) {

        Character character = (Character) object;
        mCharacterAdapter.setItem(character);
        mCharacterAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Character character = mCharacterAdapter.getItem(position);
        Intent characterDetail = new Intent(getActivity(), DetailActivity.class);
        characterDetail.putExtra(CHARACTER_PARAM, character);
        startActivity(characterDetail);
    }
}

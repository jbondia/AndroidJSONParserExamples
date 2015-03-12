package com.jbondia.basicjsonparser.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jbondia.basicjsonparser.model.Character;
import com.jbondia.basicjsonparser.adapter.CharacterAdapter;
import com.jbondia.basicjsonparser.R;
import com.jbondia.basicjsonparser.delegate.AsyncDelegate;
import com.jbondia.basicjsonparser.task.GetCharacterTask;

/**
 * Created by jbondia on 11/03/15.
 */
public class CharacterFragment extends Fragment implements AsyncDelegate {

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

        ListView characterListView = (ListView) getActivity().findViewById(R.id.listview_character);
        mCharacterAdapter = new CharacterAdapter(getActivity());
        characterListView.setAdapter(mCharacterAdapter);

        new GetCharacterTask(getActivity(), this).execute(
                "http://192.168.1.4:8080/simple_backend/api/v1/character"
        );
    }


    @Override
    public void asyncComplete(Object object) {

        Character character = (Character) object;
        mCharacterAdapter.setItem(character);
        mCharacterAdapter.notifyDataSetChanged();
    }
}

package com.example.android.ongoletourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TouristAttractionFragment extends Fragment {

    public TouristAttractionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word(getString(R.string.tourist_attraction_title_1), getString(R.string.tourist_attraction_subTitle_1), getString(R.string.tourist_attraction_address_1), getString(R.string.tourist_attraction_place_link_1), R.drawable.beach_photo, 4.0f, getString(R.string.tourist_attraction_phone_number_1)));
        words.add(new Word(getString(R.string.tourist_attraction_title_2), getString(R.string.tourist_attraction_subTitle_2), getString(R.string.tourist_attraction_address_2), getString(R.string.tourist_attraction_place_link_2), R.drawable.mallavaram_dam_photo, 4.3f, getString(R.string.tourist_attraction_phone_number_2)));
        words.add(new Word(getString(R.string.tourist_attraction_title_3), getString(R.string.tourist_attraction_subTitle_3), getString(R.string.tourist_attraction_address_3), getString(R.string.tourist_attraction_place_link_3), 3.0f, getString(R.string.tourist_attraction_phone_number_3)));

        WordAdapter adapter = new WordAdapter(getActivity(), words);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

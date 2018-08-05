package com.example.android.ongoletourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TransportationFragment extends Fragment {

    public TransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word(getString(R.string.transport_title_1), getString(R.string.transport_subtitle_1), getString(R.string.transport_address_1), getString(R.string.transport_place_link_1), R.drawable.ongole_railway_station, 4.0f, getString(R.string.transport_phone_number_1)));
        words.add(new Word(getString(R.string.transport_title_2), getString(R.string.transport_subtitle_2), getString(R.string.transport_address_2), getString(R.string.transport_place_link_2), R.drawable.ongole_bus_stand, 4.0f, getString(R.string.transport_phone_number_2)));

        WordAdapter adapter = new WordAdapter(getActivity(), words);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return rootView;
    }
}

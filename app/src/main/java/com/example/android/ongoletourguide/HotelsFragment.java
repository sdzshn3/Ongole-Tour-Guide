package com.example.android.ongoletourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.hotel_title_1), getString(R.string.hotel_subTitle_1), getString(R.string.hotel_address_1), getString(R.string.hotel_place_link_1), R.drawable.hotel_kolas, 3.6f, getString(R.string.hotel_phone_number_1)));
        words.add(new Word(getString(R.string.hotel_title_2), getString(R.string.hotel_subTitle_2), getString(R.string.hotel_address_2), getString(R.string.hotel_place_link_2), 3.9f, getString(R.string.hotel_phone_number_2)));
        words.add(new Word(getString(R.string.hotel_title_3), getString(R.string.hotel_subTitle_3), getString(R.string.hotel_address_3), getString(R.string.hotel_place_link_3), 3.2f, getString(R.string.hotel_phone_number_3)));

        WordAdapter adapter = new WordAdapter(getActivity(), words);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}

package com.example.kenkelvin.testeloginscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KenKelvin on 13/10/2015.
 */
public class FavoritosFragment extends android.support.v4.app.Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FavoritosFragment newInstance(int sectionNumber) {
        FavoritosFragment fragment = new FavoritosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FavoritosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}

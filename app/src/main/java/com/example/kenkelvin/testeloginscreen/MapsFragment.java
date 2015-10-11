package com.example.kenkelvin.testeloginscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by KenKelvin on 09/10/2015.
 */
public class MapsFragment extends android.support.v4.app.Fragment{


    public MapView mapView;
    private static GoogleMap googleMap;

//
//    public GMapsFragment() {
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.w("GMAPS", "Map place 1");
        // **********************************************************************************
        // The line below throws an inflation error when trying to parse the fragment_map xml
        // **********************************************************************************
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);
        // Log.w("GMAPS", "Map place 1");

        if (googleMap != null)
            setUpMap();
        if (googleMap == null) {
            googleMap = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.MapView)).getMap();
            if (googleMap != null) {
                setUpMap();
            }
        }

        return rootView;
    }

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static MapsFragment newInstance(int sectionNumber) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private static void setUpMap() {
        googleMap.setMyLocationEnabled(true);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-23.574124, -46.623387)).title("FIAP"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.574124, -46.623387), 12.0f));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (googleMap != null) {
            getActivity().getFragmentManager().beginTransaction()
                    .remove(getActivity().getFragmentManager().findFragmentById(R.id.MapView))
                    .commit();
            googleMap = null;
        }
    }
}

//    private static final String ARG_SECTION_NUMBER = "section_number";
//    public static MapsFragment newInstance(int sectionNumber) {
//        MapsFragment fragment = new MapsFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_mapa,container, false);
//
//        mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        return rootView;
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        ((MainActivity) activity).onSectionAttached(
//                getArguments().getInt(ARG_SECTION_NUMBER));
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        setUpMapIfNeeded();
//    }
//
//    private void setUpMapIfNeeded() {
//        if (mMap == null) {
//            mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map))
//                    .getMap();
//            if (mMap != null) {
//                setUpMap();
//            }
//        }
//    }
//    private void setUpMap() {
//        mMap.clear();
//        LatLng SaoPaulo = new LatLng(-23.574124, -46.623387);
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SaoPaulo, 12));
//
//    }
//}


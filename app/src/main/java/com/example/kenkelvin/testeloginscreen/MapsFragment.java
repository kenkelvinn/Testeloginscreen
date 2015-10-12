package com.example.kenkelvin.testeloginscreen;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by KenKelvin on 09/10/2015.
 */
public class MapsFragment extends android.support.v4.app.Fragment{


    public MapView mapView;
    private static GoogleMap googleMap;

//    private GoogleApiClient mGoogleApiClient;

//    static final LatLng real_estate1 = new LatLng(-23.563022, -46.629779);
//    static final LatLng real_estate2 = new LatLng(-23.573022, -46.629779);
//    static final LatLng real_estate3 = new LatLng(-23.583681, -46.627564);
//    static final LatLng real_estate4 = new LatLng(-23.584092, -46.645889);
//    static final LatLng real_estate5 = new LatLng(-23.579332, -46.642131);
//    static final LatLng real_estate6 = new LatLng(-23.575136, -46.639583);
//    static final LatLng real_estate7 = new LatLng(-23.564819, -46.627973);
//    static final LatLng real_estate8 = new LatLng(-23.580283, -46.616403);
//    static final LatLng real_estate9 = new LatLng(-23.579385, -46.676645);
//    static final LatLng real_estate10 = new LatLng(-23.558565, -46.660783);
//    static final LatLng real_estate11 = new LatLng(-23.548595, -46.629779);
//    static final LatLng real_estate12 = new LatLng(-23.568165, -46.649183);

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
        googleMap = null;

//        if (googleMap == null) {
            googleMap = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.MapView)).getMap();
            if (googleMap != null) {
                setUpMap();
            }
//        }

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
        BitmapDescriptor ic_apartment = BitmapDescriptorFactory.fromResource(R.drawable.ic_apartment);
        BitmapDescriptor ic_house = BitmapDescriptorFactory.fromResource(R.drawable.ic_house);
        BitmapDescriptor ic_condominium = BitmapDescriptorFactory.fromResource(R.drawable.ic_condominium);
        BitmapDescriptor ic_office_building = BitmapDescriptorFactory.fromResource(R.drawable.ic_office_building);
        BitmapDescriptor ic_townhouse = BitmapDescriptorFactory.fromResource(R.drawable.ic_townhouse);
        googleMap.setMyLocationEnabled(true);
        googleMap.setMyLocationEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setTrafficEnabled(true);
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.574124, -46.623387))
                .title("FIAP")
                .icon(ic_office_building));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.563022, -46.629779))
                .title("Conjunto Cury Residencial")
                .icon(ic_condominium));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.573022, -46.629779))
                .title("Jorge Cury Residencial")
                .icon(ic_townhouse));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.583681, -46.627564))
                .title("Imóvel Comercial Av.Lins de Vasconcelos")
                .icon(ic_office_building));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.584092, -46.645889))
                .title("Sobrado Bagé")
                .icon(ic_house));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.579332, -46.642131))
                .title("Salão Comercial R. Cubatão")
                .icon(ic_office_building));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.575136, -46.639583))
                .title("Kitnet Metrô Paraíso")
                .icon(ic_apartment));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.564819, -46.627973))
                .title("Casa Térrea")
                .icon(ic_house));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.580283, -46.616403))
                .title("Coronel Diogo Retiro")
                .icon(ic_apartment));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.579385, -46.646645))
                .title("República para Estudantes Jd. Paulista")
                .icon(ic_townhouse));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.558565, -46.660783))
                .title("Condomínio Augusta")
                .icon(ic_condominium));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-30.038301, -51.218765))
                .title("Imóvel Comercial Porto Alegre")
                .icon(ic_office_building));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-3.747769, -38.510835))
                .title("Condomínio Aldeota- CE")
                .icon(ic_condominium));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.574124, -46.623387), 14.0f));
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
    @Override
        public void onAttach(Activity activity) {
           super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
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


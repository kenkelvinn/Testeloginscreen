package com.example.kenkelvin.ondealuga;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by KenKelvin on 09/10/2015.
 */
public class MapsFragment extends android.support.v4.app.Fragment{

    public static GoogleMap googleMap;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);
            googleMap = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.ViewMap)).getMap();
            if (googleMap != null) {
                setUpMap();
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
        BitmapDescriptor ic_apartment = BitmapDescriptorFactory.fromResource(R.drawable.ic_apartment);
        BitmapDescriptor ic_house = BitmapDescriptorFactory.fromResource(R.drawable.ic_house);
        BitmapDescriptor ic_condominium = BitmapDescriptorFactory.fromResource(R.drawable.ic_condominium);
        BitmapDescriptor ic_office_building = BitmapDescriptorFactory.fromResource(R.drawable.ic_office_building);
        BitmapDescriptor ic_townhouse = BitmapDescriptorFactory.fromResource(R.drawable.ic_townhouse);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.setMyLocationEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setTrafficEnabled(true);

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.574124, -46.623387))
                .title("FIAP")
                .icon(ic_office_building)
                .snippet("A Melhor Faculdade de Tecnologia"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.563022, -46.629779))
                .title("Conjunto Cury Residencial")
                .icon(ic_condominium)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.573022, -46.629779))
                .title("Jorge Cury Residencial")
                .icon(ic_townhouse)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.583681, -46.627564))
                .title("Imóvel Comercial Av.Lins de Vasconcelos")
                .icon(ic_office_building)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.584092, -46.645889))
                .title("Sobrado Bagé")
                .icon(ic_house)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.579332, -46.642131))
                .title("Salão Comercial R. Cubatão")
                .icon(ic_office_building)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.575136, -46.639583))
                .title("Kitnet Metrô Paraíso")
                .icon(ic_apartment)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.564819, -46.627973))
                .title("Casa Térrea")
                .icon(ic_house)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.580283, -46.616403))
                .title("Coronel Diogo Retiro")
                .icon(ic_apartment)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.579385, -46.646645))
                .title("República para Estudantes Jd. Paulista")
                .icon(ic_townhouse)
                .snippet(""));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-23.558565, -46.660783))
                .title("Condomínio Augusta")
                .icon(ic_condominium)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-30.038301, -51.218765))
                .title("Imóvel Comercial Porto Alegre")
                .icon(ic_office_building)
                .snippet("Ver Detalhes"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-3.747769, -38.510835))
                .title("Condomínio Aldeota- CE")
                .icon(ic_condominium)
                .snippet("Ver Detalhes"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.574124, -46.623387), 14.0f));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (googleMap != null) {
            getActivity().getFragmentManager().beginTransaction()
                    .remove(getActivity().getFragmentManager().findFragmentById(R.id.ViewMap))
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



package com.banerjee.sirsha.geobound.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banerjee.sirsha.geobound.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by S.B. on 1/3/18.
 */

public class PickPlaceFragment extends Fragment implements OnMapReadyCallback {

    private MapView mMapView;
    private GoogleMap mGoogleMap;

    private ArrayList<LatLng> arrLatlnglist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pick_place, container, false);

        mMapView = v.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this); //this is important

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrLatlnglist = new ArrayList<>();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        final LatLng latLng = new LatLng(21, 57);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
//        mGoogleMap.addMarker(new MarkerOptions().position(latLng));
//        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        //Move the camera to the user's location and zoom in!
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
        mGoogleMap.getUiSettings().setScrollGesturesEnabled(true);

        mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                // TODO Auto-generated method stub
                arrLatlnglist.add(point);
//                mGoogleMap.clear();
//                    mGoogleMap.addMarker(new MarkerOptions().position(point));
                if (arrLatlnglist != null && arrLatlnglist.size() > 0) {

                    addMarker(point);
                }
            }
        });


    }

    private void addMarker(LatLng latLng) {
        for (int i = 0; i < arrLatlnglist.size(); i++) {
            if (arrLatlnglist.get(i) != latLng) {
                mGoogleMap.addMarker(new MarkerOptions().position(latLng));
            }
        }

        PolylineOptions line=
                new PolylineOptions().add(new LatLng(21,
                                57),
                        new LatLng(22,
                                57),
                        new LatLng(23,
                                57),
                        new LatLng(21,
                                57))
                        .width(5).color(Color.RED);

        mGoogleMap.addPolyline(line);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}

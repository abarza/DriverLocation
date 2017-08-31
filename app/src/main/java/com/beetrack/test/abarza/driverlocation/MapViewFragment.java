package com.beetrack.test.abarza.driverlocation;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapViewFragment extends Fragment implements OnMapReadyCallback {

  private SupportMapFragment mSupportMapFragment;

  public MapViewFragment() {
    // Required empty public constructor
  }

  public static MapViewFragment newInstance() {
    MapViewFragment fragment = new MapViewFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }

    mSupportMapFragment = SupportMapFragment.newInstance();
    FragmentTransaction fragmentTransaction =
        getFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.mapHolder, mSupportMapFragment);
    fragmentTransaction.commit();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View rootView = inflater.inflate(R.layout.fragment_map, container, false);

    mSupportMapFragment.getMapAsync(this);


    return rootView;
  }


  @Override
  public void onMapReady(GoogleMap map) {

    LatLng home = new LatLng(-33.424845, -70.615574);
    map.addMarker(new MarkerOptions()
        .position(home)
        .title("Mi Casa"));

    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);


    CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(home).zoom(16).build();

    map.animateCamera(CameraUpdateFactory
        .newCameraPosition(cameraPosition));
  }

}

package com.beetrack.test.abarza.driverlocation;


import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapViewFragment extends Fragment implements OnMapReadyCallback {
  private final static String TAG = MapViewFragment.class.getSimpleName();
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

    ImageView animatedImageView = (ImageView) rootView.findViewById(R.id.animatedMarker);
    ((AnimationDrawable) animatedImageView.getBackground()).start();

    mSupportMapFragment.getMapAsync(this);


    return rootView;
  }


  @Override
  public void onMapReady(GoogleMap map) {

    LatLng home = new LatLng(-33.424845, -70.615574);


    try {
      // Customise the styling of the base map using a JSON object defined
      // in a raw resource file.
      boolean success = map.setMapStyle(
          MapStyleOptions.loadRawResourceStyle(
              getContext(), R.raw.style_json));

      if (!success) {
        Log.e(TAG, "Style parsing failed.");
      }
    } catch (Resources.NotFoundException e) {
      Log.e(TAG, "Can't find style. Error: ", e);
    }

    map.getUiSettings().setAllGesturesEnabled(false);

    CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(home).zoom(16).build();

    map.animateCamera(CameraUpdateFactory
        .newCameraPosition(cameraPosition));
  }

}

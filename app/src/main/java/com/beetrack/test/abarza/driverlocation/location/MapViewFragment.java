package com.beetrack.test.abarza.driverlocation.location;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beetrack.test.abarza.driverlocation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;


public class MapViewFragment extends Fragment implements OnMapReadyCallback {
  private final static String TAG = MapViewFragment.class.getSimpleName();
  private static final String DARK_MODE = "mDarkMode";
  private SupportMapFragment mSupportMapFragment;
  private Boolean mDarkMode;

  public MapViewFragment() {
    // Required empty public constructor
  }

  public static MapViewFragment newInstance(boolean darkMode) {
    MapViewFragment fragment = new MapViewFragment();
    Bundle args = new Bundle();
    args.putBoolean(DARK_MODE, darkMode);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mDarkMode = getArguments().getBoolean(DARK_MODE);
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
    TextView title = (TextView) rootView.findViewById(R.id.title);

    RelativeLayout topShade = (RelativeLayout) rootView.findViewById(R.id.topShade);
    RelativeLayout bottomShade = (RelativeLayout) rootView.findViewById(R.id.bottomShade);


    if(!mDarkMode) {
      title.setTextColor(ContextCompat.getColor(getContext(), R.color.darkMap));
      title.setShadowLayer(0.02f, -2, 2, ContextCompat.getColor(getContext(), R.color.white));
      topShade.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.gradient_light_map));
      bottomShade.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.gradient_light_map_bottom));
    }

    mSupportMapFragment.getMapAsync(this);


    return rootView;
  }


  @Override
  public void onMapReady(GoogleMap map) {

    //TODO Get the current user position
    LatLng userLocation = new LatLng(-33.424845, -70.615574);


    if(mDarkMode) {
      setMapStyle(map, R.raw.style_dark_json);
    } else {
      setMapStyle(map, R.raw.style_light_json);
    }

    map.getUiSettings().setAllGesturesEnabled(false);

    CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(userLocation).zoom(16).build();

    map.animateCamera(CameraUpdateFactory
        .newCameraPosition(cameraPosition));
  }

  private void setMapStyle(GoogleMap map, int json) {
    map.setMapStyle(
        MapStyleOptions.loadRawResourceStyle(
            getContext(), json));
  }

}

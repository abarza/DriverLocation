package com.beetrack.test.abarza.driverlocation;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class LocationNotFoundFragment extends Fragment {

  private static final String TAG = LocationNotFoundFragment.class.getSimpleName();
  private static boolean HAS_PLACES = false;

  public LocationNotFoundFragment() {
    // Required empty public constructor
  }

  public static LocationNotFoundFragment newInstance() {
    LocationNotFoundFragment fragment = new LocationNotFoundFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_location_not_found, container, false);
    LinearLayout emptyContainer = (LinearLayout) rootView.findViewById(R.id.emptyContainer);
    ConstraintLayout constraintHoleder = (ConstraintLayout) rootView.findViewById(R.id
        .constraintHolder);

    if (!HAS_PLACES) {

      Log.d(TAG, "Sin places");
    } else {

      emptyContainer.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));

      // Remove the bottom constraint to stick it to the top
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) emptyContainer
          .getLayoutParams();
      layoutParams.bottomToTop = -1;
      emptyContainer.setLayoutParams(layoutParams);

      Log.d(TAG, "Con places");
    }

    return rootView;

  }


}

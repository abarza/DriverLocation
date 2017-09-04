package com.beetrack.test.abarza.driverlocation.location;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beetrack.test.abarza.driverlocation.R;


public class LocationNotFoundFragment extends Fragment {

  private static final String TAG = LocationNotFoundFragment.class.getSimpleName();
  private static final String HAS_PLACES = "hasPlaces";
  private RecyclerView mPlacesRecyclerView;
  private Boolean mPlaces;

  public LocationNotFoundFragment() {
    // Required empty public constructor
  }

  public static LocationNotFoundFragment newInstance(boolean hasPlaces) {
    LocationNotFoundFragment fragment = new LocationNotFoundFragment();
    Bundle args = new Bundle();
    args.putBoolean(HAS_PLACES, hasPlaces);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mPlaces = getArguments().getBoolean(HAS_PLACES);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_location_not_found, container, false);
    LinearLayout emptyContainer = (LinearLayout) rootView.findViewById(R.id.emptyContainer);
    TextView emptyContent = (TextView) rootView.findViewById(R.id.emptyContent);
    Button availabilityButton = (Button) rootView.findViewById(R.id.availableButton);
    mPlacesRecyclerView = (RecyclerView) rootView.findViewById(R.id.placesList);
    RelativeLayout bottomShade = (RelativeLayout) rootView.findViewById(R.id.bottomShade);

    if (mPlaces) {
      // Paint the container background
      emptyContainer.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
      // Remove the bottom constraint to stick it to the top
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) emptyContainer
          .getLayoutParams();
      layoutParams.bottomToTop = -1;
      emptyContainer.setLayoutParams(layoutParams);
      // Set text to make the user fist tap on a place to start their work
      emptyContent.setText(R.string.empty_select_a_place);
      // Hide the commit button (now will be the item in recyclerView)
      availabilityButton.setVisibility(View.GONE);
      mPlacesRecyclerView.setVisibility(View.VISIBLE);
    } else {
      bottomShade.getLayoutParams().height = dpAsPixels(250);
    }
    return rootView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle bundle) {
    super.onViewCreated(view, bundle);

    if (mPlaces) {
      // Get places from the dummy data set
      PlaceAdapter placeAdapter = new PlaceAdapter(PlaceDummyData.getInstance().getPlaces());
      // allows for optimizations if all items are of the same size
      mPlacesRecyclerView.setHasFixedSize(true);
      mPlacesRecyclerView.setAdapter(placeAdapter);
      LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
      // you can set the first visible item like this:
      layoutManager.scrollToPosition(0);
      mPlacesRecyclerView.setLayoutManager(layoutManager);
    }

  }

  private int dpAsPixels(int dp) {
    final float scale = getContext().getResources().getDisplayMetrics().density;
    return (int) (dp * scale + 0.5f);
  }
}

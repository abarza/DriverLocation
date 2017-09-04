package com.beetrack.test.abarza.driverlocation.location;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.beetrack.test.abarza.driverlocation.R;

import java.util.ArrayList;

/**
 * Created by abarza on 04-09-17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceHolder> {

  private ArrayList<PlaceModel> mPlaceModels;


  public PlaceAdapter(ArrayList<PlaceModel> placeModels) {
    mPlaceModels = placeModels;

    if (placeModels == null) {
      throw new IllegalArgumentException("Place data must no be null");
    }

  }

  @Override
  public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View orderCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_card,
        parent, false);

    return new PlaceHolder(orderCard);
  }

  @Override
  public void onBindViewHolder(final PlaceHolder holder, int position) {

    final PlaceModel placeModel = mPlaceModels.get(position);

    holder.updateUI(placeModel);


  }

  @Override
  public int getItemCount() {
    return mPlaceModels.size();
  }
}

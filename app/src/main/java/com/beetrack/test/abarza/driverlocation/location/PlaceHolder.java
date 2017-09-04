package com.beetrack.test.abarza.driverlocation.location;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beetrack.test.abarza.driverlocation.R;

/**
 * Created by abarza on 04-09-17.
 */

public class PlaceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  private static final String TAG = PlaceHolder.class.getSimpleName();
  private TextView mPlaceTitle;
  private TextView mPlaceAddress;
  private String mName;


  public PlaceHolder(View itemView) {
    super(itemView);

    mPlaceTitle = (TextView) itemView.findViewById(R.id.placeName);
    mPlaceAddress = (TextView) itemView.findViewById(R.id.placeAddress);

    itemView.setOnClickListener(this);
  }

  public void updateUI(PlaceModel placeModel) {

    mName = placeModel.getPlaceName();
    String address = placeModel.getPlaceAddress();

    setLabels(mName, mPlaceTitle);
    setLabels(address, mPlaceAddress);


  }

  private void setLabels(String label, TextView textView) {
    if (label != null) {
      textView.setText(label);
    } else {
      textView.setVisibility(View.GONE);
    }
  }

  @Override
  public void onClick(View v) {
    Toast.makeText(itemView.getContext(), mName, Toast.LENGTH_SHORT).show();
  }
}

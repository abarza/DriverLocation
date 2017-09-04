package com.beetrack.test.abarza.driverlocation.location;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.beetrack.test.abarza.driverlocation.R;

/**
 * Created by abarza on 04-09-17.
 */

public class PlaceHolder extends RecyclerView.ViewHolder {

  private TextView mPlaceTitle;
  private TextView mPlaceAddress;


  public PlaceHolder(View itemView) {
    super(itemView);

    mPlaceTitle = (TextView) itemView.findViewById(R.id.placeName);
    mPlaceAddress = (TextView) itemView.findViewById(R.id.placeAddress);
  }

  public void updateUI(PlaceModel placeModel) {

    String name = placeModel.getPlaceName();
    String address = placeModel.getPlaceAddress();

    setLabels(name, mPlaceTitle);
    setLabels(address, mPlaceAddress);


  }

  private void setLabels(String label, TextView textView) {
    if (label != null) {
      textView.setText(label);
    } else {
      textView.setVisibility(View.GONE);
    }
  }


}

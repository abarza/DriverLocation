package com.beetrack.test.abarza.driverlocation.location;

/**
 * Created by abarza on 04-09-17.
 * Dummy model of a place (warehouse)
 */

public class PlaceModel {

  private String placeName;
  private String placeAddress;

  public PlaceModel(String placeName, String placeAddress) {
    this.placeName = placeName;
    this.placeAddress = placeAddress;
  }

  public String getPlaceName() {
    return placeName;
  }

  public String getPlaceAddress() {
    return placeAddress;
  }
}

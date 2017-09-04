package com.beetrack.test.abarza.driverlocation.location;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by abarza on 04-09-17.
 */

public class PlaceDummyData {

  private static PlaceDummyData ourInstance = new PlaceDummyData();

  public static PlaceDummyData getInstance() {
    return ourInstance;
  }

  public ArrayList<PlaceModel> getPlaces() {
    ArrayList<PlaceModel> placesList = new ArrayList<>();

    placesList.add(new PlaceModel("Oficina Beetrack", "Alonso de Cordova 5670, Oficina 1504"));
    placesList.add(new PlaceModel("CD La Concepcion", "La Concepción 80, Oficina 43"));
    placesList.add(new PlaceModel("Oficina Beetrack", "Alonso de Cordova 5670, Oficina 1504"));
    placesList.add(new PlaceModel("CD Culiacán", "Av. Álvaro Obregón 301, Jorge Almada, 80200 " +
        "Culiacán Rosales, Sin."));

    return placesList;

  }

}

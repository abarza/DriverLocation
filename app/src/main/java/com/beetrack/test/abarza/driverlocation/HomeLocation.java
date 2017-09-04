package com.beetrack.test.abarza.driverlocation;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class HomeLocation extends AppCompatActivity {

  private static boolean HAS_LOCATION_ENABLED = false;
  private static boolean HAS_PLACES = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_location);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.getBackground().setAlpha(0);
    if (getSupportActionBar().getTitle() != null) {
      getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    if (HAS_LOCATION_ENABLED) {
      setCurrentFragment(MapViewFragment.newInstance(), R.id.launch);
    } else {
      setCurrentFragment(LocationNotFoundFragment.newInstance(), R.id.launch);
    }

  }

  private void setCurrentFragment(Fragment fragment, int frameLayoutId) {
    getSupportFragmentManager().beginTransaction()
        .replace(frameLayoutId, fragment)
        .commit();
  }

}

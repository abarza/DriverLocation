package com.beetrack.test.abarza.driverlocation.location;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.beetrack.test.abarza.driverlocation.R;

public class DriverLocation extends AppCompatActivity {

  private boolean mHasLocation;
  private boolean mDarkMode;
  private boolean mHasPlaces;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_location);

    Bundle extras = getIntent().getExtras();
    if(extras != null) {
      mHasLocation = extras.getBoolean("Has Location");
      mDarkMode = extras.getBoolean("dark Mode");
      mHasPlaces = extras.getBoolean("has Places");
    }


    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    toolbar.setNavigationOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){
        finish();
      }
    });
    toolbar.getBackground().setAlpha(0);
    if (getSupportActionBar().getTitle() != null) {
      getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    if (mHasLocation) {
      setCurrentFragment(MapViewFragment.newInstance(mDarkMode), R.id.launch);
    } else {
      setCurrentFragment(LocationNotFoundFragment.newInstance(mHasPlaces), R.id.launch);
    }

  }

  private void setCurrentFragment(Fragment fragment, int frameLayoutId) {
    getSupportFragmentManager().beginTransaction()
        .replace(frameLayoutId, fragment)
        .commit();
  }

}

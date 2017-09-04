package com.beetrack.test.abarza.driverlocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beetrack.test.abarza.driverlocation.location.DriverLocation;

public class SelectExamples extends AppCompatActivity implements View.OnClickListener {

  private Button mDarkGps;
  private Button mLightGps;
  private Button mNoGps;
  private Button mNoGpsNoPlaces;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_select_examples);

    mDarkGps = (Button) findViewById(R.id.blackGps);
    mLightGps = (Button) findViewById(R.id.lightGps);
    mNoGps = (Button) findViewById(R.id.noGps);
    mNoGpsNoPlaces = (Button) findViewById(R.id.noGpsNoPlaces);

    mDarkGps.setOnClickListener(this);
    mLightGps.setOnClickListener(this);
    mNoGps.setOnClickListener(this);
    mNoGpsNoPlaces.setOnClickListener(this);

  }

  private void setIntent(String key1, Boolean param1, String key2, Boolean param2) {
    Intent goToActivity = new Intent(SelectExamples.this, DriverLocation.class);
    goToActivity.putExtra(key1, param1);
    goToActivity.putExtra(key2, param2);
    startActivity(goToActivity);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.blackGps:
        setIntent("Has Location", true, "dark Mode", true);
        break;
      case R.id.lightGps:
        setIntent("Has Location", true, "dark Mode", false);
        break;
      case R.id.noGps:
        setIntent("Has Location", false, "has Places", true);
        break;
      case R.id.noGpsNoPlaces:
        setIntent("Has Location", false, "has Places", false);
        break;
    }
  }
}

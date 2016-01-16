package com.example.kanikaaggarwal.magicbutton;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

/**
 * Created by ankur on 2015-12-26.
 */
public class MainActivity4 extends Activity implements ConnectionCallbacks, OnConnectionFailedListener {


    private GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;
    protected static final String TAG = "basic-location-sample";
    protected TextView mLatitudeText;
    protected TextView mLongitudeText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

    }

    @Override
    public void onConnected(Bundle connectionHint) {

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }


    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }


    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();

    }
}



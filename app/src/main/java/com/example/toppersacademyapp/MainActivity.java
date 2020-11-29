package com.example.toppersacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.toppersacademyapp.View.Events;
import com.example.toppersacademyapp.View.PhotoViewFragment;
import com.example.toppersacademyapp.View.SplashScreen;
import com.example.toppersacademyapp.Model.EventModel;

public class MainActivity extends AppCompatActivity implements Events.FragmentDataListner {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        SplashScreen splashScreen = new SplashScreen();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, splashScreen)
                .commit();

    }

    @Override
    public void onFragmentDataListner(EventModel eventModel) {

        /*PhotoViewFragment photoViewFragment =
                (PhotoViewFragment) getSupportFragmentManager().findFragmentById(R.id.mphotoViewID);
        photoViewFragment.displayImage(eventModel);*/
        PhotoViewFragment photoViewFragment = new PhotoViewFragment();
        String URL = eventModel.getEventImage();
        Log.d(TAG,URL);
        Bundle bundle = new Bundle();
        bundle.putString("URL",URL);
        photoViewFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().addToBackStack("BackSTack")
                .replace(R.id.fragment_container,photoViewFragment).commit();

    }
}
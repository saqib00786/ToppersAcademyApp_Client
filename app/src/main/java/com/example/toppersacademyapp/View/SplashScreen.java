package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.toppersacademyapp.R;

public class SplashScreen extends Fragment {

    public SplashScreen() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        int mSecondDisplay = 1;
        new Handler().postDelayed(() -> {
            DashBoard dashBoard = new DashBoard();
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, dashBoard).commit();
        }, mSecondDisplay * 4000);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();
    }
}

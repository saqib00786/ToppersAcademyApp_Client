package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.toppersacademyapp.R;

public class Courses extends Fragment {

    public Courses() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses,container,false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();




        return view;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();
    }
}


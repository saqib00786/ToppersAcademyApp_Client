package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.toppersacademyapp.R;
import com.github.chrisbanes.photoview.PhotoView;


public class PhotoViewFragment extends Fragment {

    private PhotoView photoView;

    public PhotoViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photoview, container, false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        photoView = view.findViewById(R.id.mphotoViewID);
        display();

        return view;
    }

    public void display(){
        Bundle bundle = this.getArguments();
        String Url =bundle.getString("URL");

        Glide.with(getContext())
                .load(Url)
                .fitCenter()
                .placeholder(R.drawable.error_img)
                .into(photoView);
    }

    /*public void displayImage(EventModel eventModel){
        String Url = eventModel.getEventImage();
        Glide.with(getContext())
                .load(Url)
                .fitCenter()
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(photoView);
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();
    }
}

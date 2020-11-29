package com.example.toppersacademyapp.View;

import android.os.Bundle;


import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toppersacademyapp.R;

public class DashBoard extends Fragment implements View.OnClickListener {

    private AppCompatButton mFacultyBtn,mCoursesBtn,mFeeBtn,mEventsBtn,mAboutUsBtn,mFAQBtn;


    public DashBoard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_dash_board,container,false);



        mFacultyBtn= mView.findViewById(R.id.facultyID_btn);
        mCoursesBtn= mView.findViewById(R.id.coursesID_btn);
        mFeeBtn= mView.findViewById(R.id.feeID_btn);
        mEventsBtn= mView.findViewById(R.id.eventsID_btn);
        mAboutUsBtn= mView.findViewById(R.id.aboutUsID_btn);
        mFAQBtn= mView.findViewById(R.id.faqID_btn);


        mFacultyBtn.setOnClickListener(this);
        mCoursesBtn.setOnClickListener(this);
        mFeeBtn.setOnClickListener(this);
        mEventsBtn.setOnClickListener(this);
        mAboutUsBtn.setOnClickListener(this);
        mFAQBtn.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.facultyID_btn:

                Faculty faculty = new Faculty();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,faculty).commit();

                break;
            case R.id.coursesID_btn:

                Courses courses = new Courses();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,courses).commit();

                break;
            case R.id.feeID_btn:

                FeeStructure feeStructure = new FeeStructure();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,feeStructure).commit();

                break;
            case R.id.eventsID_btn:

                Events events = new Events();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,events).commit();

                break;
            case R.id.aboutUsID_btn:

                AboutUs aboutUs = new AboutUs();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,aboutUs).commit();

                break;
            case R.id.faqID_btn:

                FAQs faQs = new FAQs();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("ToppersAcademy")
                        .replace(R.id.fragment_container,faQs).commit();

                break;

        }
    }
}
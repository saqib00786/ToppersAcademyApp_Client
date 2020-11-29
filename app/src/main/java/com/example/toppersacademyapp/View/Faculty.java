package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.toppersacademyapp.Controller.FacultyRecyclerViewAdapter;
import com.example.toppersacademyapp.Model.FacultyModel;
import com.example.toppersacademyapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Fragment {

    RecyclerView mRecyclerView;
    FacultyRecyclerViewAdapter mAdapter;
    private LottieAnimationView lottieAnimationView;


    private List<FacultyModel> facultyModelList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference dbRef = db.collection("Faculty");

    public Faculty() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty,container,false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        mRecyclerView = view.findViewById(R.id.facultyRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lottieAnimationView = view.findViewById(R.id.animation_view);

        lottieAnimationView.setVisibility(View.VISIBLE);
        dbRef.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if(!queryDocumentSnapshots.isEmpty()){
                        for(QueryDocumentSnapshot faculty : queryDocumentSnapshots){
                            lottieAnimationView.setVisibility(View.GONE);
                            FacultyModel facultyModel = faculty.toObject(FacultyModel.class);
                            facultyModelList.add(facultyModel);
                        }

                        mAdapter = new FacultyRecyclerViewAdapter(getContext(),facultyModelList);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();

                    }else {
                        Toast.makeText(getContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(getContext(), "Something Wrong", Toast.LENGTH_SHORT).show());


        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();
    }
}

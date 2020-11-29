package com.example.toppersacademyapp.View;

import android.content.Context;
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
import com.example.toppersacademyapp.Controller.EventRecyclerViewAdapter;
import com.example.toppersacademyapp.Model.EventModel;
import com.example.toppersacademyapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Events extends Fragment {

    private RecyclerView mEventRecyclerView;
    private EventRecyclerViewAdapter mAdapter;
    private LottieAnimationView lottieAnimationView;
    private FragmentDataListner mListner;

    private List<EventModel> eventModelList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference dbRef = db.collection("Events");

    public Events() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events,container,false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        mEventRecyclerView = view.findViewById(R.id.eventRecyclerView);
        eventModelList.clear();

        mEventRecyclerView.setHasFixedSize(true);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lottieAnimationView = view.findViewById(R.id.event_animation_view);

        lottieAnimationView.setVisibility(View.VISIBLE);
        dbRef.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if(!queryDocumentSnapshots.isEmpty()){
                        for(QueryDocumentSnapshot events : queryDocumentSnapshots){
                            lottieAnimationView.setVisibility(View.GONE);
                            EventModel eventModel = events.toObject(EventModel.class);
                            eventModelList.add(eventModel);
                        }

                        mAdapter = new EventRecyclerViewAdapter(getContext(),eventModelList,mListner);
                        mEventRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();

                    }else {
                        Toast.makeText(getContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                }).
                addOnFailureListener(e -> Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show());


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentDataListner)
            mListner = (FragmentDataListner) context;
    }

    public interface FragmentDataListner{
        void onFragmentDataListner(EventModel eventModel);
    }

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

package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.toppersacademyapp.Controller.FAQAdapter;
import com.example.toppersacademyapp.Model.Question;
import com.example.toppersacademyapp.R;

import java.util.ArrayList;
import java.util.List;

public class FAQs extends Fragment {

    private RecyclerView recyclerView;
    private FAQAdapter mAdapter;
    private LottieAnimationView lottieAnimationView;

    private List<Question> modelList = new ArrayList<>();

    public FAQs() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faqs,container,false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        recyclerView = view.findViewById(R.id.faqRecyclerView);

        Question mQ1 = new Question();
        mQ1.setmQuestion("Where is Toppers academy located?");
        mQ1.setmAnswer("Toppers academy located near Imran Siddique Composing Center Piplan, Koh-e-Noor town Piplan.");
        modelList.add(mQ1);

        Question mQ2 = new Question();
        mQ2.setmQuestion("What is the timing of academy?");
        mQ2.setmAnswer("The timing of academy is 3:00 PM to 5:00 PM.It may be change after decision of academy stakeholders.");
        modelList.add(mQ2);

        Question mQ3 = new Question();
        mQ3.setmQuestion("What about staff?");
        mQ3.setmAnswer("Staff of Toppers academy is highly educated and working as a lecturer in renowned colleges.");
        modelList.add(mQ3);

        Question mQ4 = new Question();
        mQ4.setmQuestion("About educational environment of Toppers academy?");
        mQ4.setmAnswer("All the lectures are activity and discussion based and each class assigned a separate room.");
        modelList.add(mQ4);

        Question mQ5 = new Question();
        mQ5.setmQuestion("What about fee system?");
        mQ5.setmAnswer("The fee of per subject is 800 but academy will provide a discount of 6% to every student, And all the orphan student get tuition with no cost.");
        modelList.add(mQ5);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new FAQAdapter(getContext(),modelList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();



        return view;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();
    }
}

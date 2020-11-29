package com.example.toppersacademyapp.Controller;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toppersacademyapp.Model.Question;
import com.example.toppersacademyapp.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.ViewHolder> {

    private Context context;
    private List<Question> questionList;

    public FAQAdapter(Context context,List<Question> questionList) {
        this.questionList = questionList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faqs_cardview,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Question model = questionList.get(position);

        holder.mQuest.setText(model.getmQuestion());
        holder.mAnsw.setText(model.getmAnswer());

        boolean isExpandedBtn = questionList.get(position).isExpandeBtn();
        if(isExpandedBtn){
            holder.ExpandAbleLayout.setVisibility(View.VISIBLE);
            holder.mExpandableBtn.setBackgroundResource(R.drawable.ic_sharp_indeterminate_check_box_24);
            holder.mTopBarView.setBackgroundColor(Color.BLACK);
            holder.mQuest.setTextColor(Color.WHITE);
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,R.anim.slide_down);
            holder.ExpandAbleLayout.setAnimation(animation);
        }
        if(!isExpandedBtn){
            holder.ExpandAbleLayout.setVisibility(View.GONE);
            holder.mExpandableBtn.setBackgroundResource(R.drawable.ic_sharp_add_box_24);
            holder.mTopBarView.setBackgroundColor(Color.rgb(212,214,216));
            holder.mQuest.setTextColor(Color.BLACK);
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,R.anim.slide_up);
            holder.ExpandAbleLayout.setAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        MaterialTextView mQuest,mAnsw;
        AppCompatButton mExpandableBtn;
        RelativeLayout ExpandAbleLayout;
        LinearLayout mTopBarView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mQuest = itemView.findViewById(R.id.mFAQ_HeadingID);
            mAnsw = itemView.findViewById(R.id.mFAQ_DesID);
            mExpandableBtn = itemView.findViewById(R.id.expandableButtonID);
            ExpandAbleLayout = itemView.findViewById(R.id.expandableLayout);
            mTopBarView = itemView.findViewById(R.id.topBarCardViewFAQ);

            mExpandableBtn.setOnClickListener(v -> {
                Question question = questionList.get(getAdapterPosition());
                question.setExpandeBtn(!question.isExpandeBtn());
                notifyItemChanged(getAdapterPosition());
            });



        }
    }
}

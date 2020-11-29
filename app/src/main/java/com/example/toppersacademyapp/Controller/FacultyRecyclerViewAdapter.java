package com.example.toppersacademyapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.toppersacademyapp.Model.FacultyModel;
import com.example.toppersacademyapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyRecyclerViewAdapter extends RecyclerView.Adapter<FacultyRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<FacultyModel> facultyModelList;

    public FacultyRecyclerViewAdapter(Context context, List<FacultyModel> facultyModelList) {
        this.context = context;
        this.facultyModelList = facultyModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_card_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FacultyModel model = facultyModelList.get(position);

        holder.mFacultyName.setText(model.getmFacName());
        holder.mFacultyWork.setText(model.getmWorkAt());
        holder.mFacultyEdu.setText(model.getmEducation());
        holder.mFacultyContact.setText(model.getmContact());

        String Url = model.getmImageUrl();

        Glide.with(context)
                .load(Url)
                .override(70,70)
                .placeholder(R.drawable.user_img)
                .into(holder.mFacultyImg);

        boolean isExpande = facultyModelList.get(position).isExpande();
        if(isExpande){
            holder.bottomBarCardView.setVisibility(View.VISIBLE);
            holder.mExpandableBtn.setBackgroundResource(R.drawable.collapse_btn_cardview);
        }else {
            holder.bottomBarCardView.setVisibility(View.GONE);
            holder.mExpandableBtn.setBackgroundResource(R.drawable.add_box_cardview);
        }
    }

    @Override
    public int getItemCount() {
        return facultyModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mFacultyImg;
        MaterialTextView mFacultyName, mFacultyWork, mFacultyContact, mFacultyEdu;
        AppCompatButton mExpandableBtn;
        RelativeLayout ExpandableLayout, bottomBarCardView;
        Animation mClockWise, mAntiClockWise;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            mFacultyImg = itemView.findViewById(R.id.facultyImgCardView);
            mFacultyName = itemView.findViewById(R.id.facultyNameCardView);
            mFacultyWork = itemView.findViewById(R.id.facWorkCardViewID);
            mFacultyContact = itemView.findViewById(R.id.facContactID);
            mFacultyEdu = itemView.findViewById(R.id.facEducationID);
            mExpandableBtn = itemView.findViewById(R.id.expandBtnCardView);
            ExpandableLayout = itemView.findViewById(R.id.topBarCardView);
            bottomBarCardView = itemView.findViewById(R.id.bottomBarCardView);

            mClockWise = AnimationUtils.loadAnimation(context, R.anim.rotate_clockwise);
            mAntiClockWise = AnimationUtils.loadAnimation(context, R.anim.rotate_anticlockwise);

            mExpandableBtn.setOnClickListener(v -> {
                FacultyModel facultyModel = facultyModelList.get(getAdapterPosition());
                facultyModel.setExpande(!facultyModel.isExpande());
                notifyItemChanged(getAdapterPosition());
            });
        }
    }
}


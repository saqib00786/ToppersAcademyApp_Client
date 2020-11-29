package com.example.toppersacademyapp.Controller;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.toppersacademyapp.View.Events;
import com.example.toppersacademyapp.Model.EventModel;
import com.example.toppersacademyapp.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<EventModel> eventModelList;
    private Events.FragmentDataListner mListener;


    public EventRecyclerViewAdapter(Context context, List<EventModel> eventModelList, Events.FragmentDataListner mListener) {
        this.context = context;
        this.eventModelList = eventModelList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_event_card,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventModel eventModel = eventModelList.get(position);
        holder.setIsRecyclable(false);

        holder.mEventName.setText(eventModel.getEventName());
        String Url = eventModel.getEventImage();

        Glide.with(context)
                .load(Url)
                .centerCrop()
                .placeholder(R.drawable.error_img)
                .into(holder.mEventImage);

    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView mEventName;
        ImageView mEventImage;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mEventName = itemView.findViewById(R.id.eventNameID);
            mEventImage = itemView.findViewById(R.id.eventImageID);


            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                mListener.onFragmentDataListner(eventModelList.get(position));
            });
        }
    }
}

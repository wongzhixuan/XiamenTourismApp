package com.example.xiamentourismapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ExploreModel> exploreModelArrayList;
    private FragmentCommunication communicator;
    // Constructor
    public RecyclerViewAdapter(Context context, ArrayList<ExploreModel> exploreModelArrayList, FragmentCommunication communication) {
        this.context = context;
        this.exploreModelArrayList = exploreModelArrayList;
        this.communicator = communication;
    }

    // Override onCreateViewHolder which deals with the inflation of the card layout as an item for the RecyclerView.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate cardview.xml using LayoutInflator
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder holder = new ViewHolder(cardView, communicator);
        return holder;
    }

    // Override onBindViewHolder which deals with the setting of different data and methods related to clicks on particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        ExploreModel exploreModel = exploreModelArrayList.get(position);
        holder.title.setText(exploreModel.getCard_title());
        holder.description.setText(exploreModel.getCard_description());
        holder.rating.setText(exploreModel.getCard_rating());
        holder.card_image.setImageResource(exploreModel.getCard_image());
        Fragment selectedFrag = new ExploreContent();
        Bundle bundle = new Bundle();
        bundle.putString("Title", exploreModel.getCard_title());
        bundle.putString("Rating", exploreModel.getCard_rating());
        selectedFrag.setArguments(bundle);
    }


    @Override
    public int getItemCount() {
        return exploreModelArrayList.size();
    }

    // View Holder class which extends RecyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, description, rating;
        ImageView card_image;
        MaterialCardView cardView;
        FragmentCommunication communication;

        public ViewHolder(View view, FragmentCommunication communicator) {
            super(view);
            cardView = (MaterialCardView)view.findViewById(R.id.cardview_explore);
            title = (TextView) view.findViewById(R.id.card_title);
            description = (TextView) view.findViewById(R.id.card_description);
            rating = (TextView) view.findViewById(R.id.card_rating);
            card_image = (ImageView) view.findViewById(R.id.card_image);
            communication = communicator;
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            communication.respond(getAdapterPosition(),exploreModelArrayList.get(getAdapterPosition()).getCard_title(), exploreModelArrayList.get(getAdapterPosition()).getCard_rating());
        }
    }
    public interface FragmentCommunication{
        void respond(int position, String title, String rating);
    }
}

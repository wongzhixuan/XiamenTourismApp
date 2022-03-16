package com.example.xiamentourismapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ExploreModel> exploreModelArrayList;
    private RecyclerViewAdapterVertical.FragmentCommunication fragmentCommunication1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_places,container,false);
        recyclerView = view.findViewById(R.id.recyclerview_places);
        fragmentCommunication1 = new RecyclerViewAdapterVertical.FragmentCommunication() {
            @Override
            public void respond(int position, String title, String rating) {
                Fragment selectedFragment = new PlacesToStayContent();
                Bundle bundle = new Bundle();
                bundle.putString("Title",title);
                bundle.putString("Rating", rating);
                selectedFragment.setArguments(bundle);
                getChildFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).addToBackStack(null).commit();
            }
        };

        // add data to first recycler view
        exploreModelArrayList = new ArrayList<>();
        exploreModelArrayList.add(new ExploreModel("Pan Pacific Xiamen", "Hotel", "5",R.drawable.pan2));
        exploreModelArrayList.add(new ExploreModel("Swiss Grand Xiamen", "Hotel", "4.5", R.drawable.swiss1));
        exploreModelArrayList.add(new ExploreModel("Shangri-La Xiamen", "Hotel","4.5", R.drawable.shangri_lang));
        exploreModelArrayList.add(new ExploreModel("Joyze Hotel Xiamen", "Hotel", "4", R.drawable.joyze1));
        exploreModelArrayList.add(new ExploreModel("Riyuegu Hotsprings Resort", "Resort", "4", R.drawable.hotspring3));

        // we are initializing our adapter class and passing our arraylist to it.
        RecyclerViewAdapterVertical Adapter = new RecyclerViewAdapterVertical(getActivity(), exploreModelArrayList, fragmentCommunication1);

        // setting a layout manager for our recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // setting layoutmanager and adapter to our recycler view
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Adapter);
        return view;
    }
}

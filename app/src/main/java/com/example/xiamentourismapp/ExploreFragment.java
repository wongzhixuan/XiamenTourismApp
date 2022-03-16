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

public class ExploreFragment extends Fragment {
    private RecyclerView recyclerView, recyclerView2;
    private ArrayList<ExploreModel> exploreModelArrayList, arrayList2;
    private RecyclerViewAdapter.FragmentCommunication fragmentCommunication1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_explore,container,false);
        recyclerView = view.findViewById(R.id.recyclerview_explore);
        recyclerView2 = view.findViewById(R.id.recyclerview_explore2);
        // set the interface
        fragmentCommunication1 = new RecyclerViewAdapter.FragmentCommunication() {
            @Override
            public void respond(int position, String title, String rating) {
                Fragment selectedFragment = new ExploreContent();
                Bundle bundle = new Bundle();
                bundle.putString("Title",title);
                bundle.putString("Rating", rating);
                selectedFragment.setArguments(bundle);
                getChildFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).addToBackStack(null).commit();
            }
        };

        // add data to first recycler view
        exploreModelArrayList = new ArrayList<>();
        exploreModelArrayList.add(new ExploreModel("Gulangyu Island", "Explore the splendid natural scenery, colonial styled architectures and numerous interesting museums!", "4.5",R.drawable.gulangyu4));
        exploreModelArrayList.add(new ExploreModel("Yuanlin Botanical Garden", "Relax in the heaven-like scenery of the nature.", "4.5", R.drawable.yuanlin_botanical_garden));
        exploreModelArrayList.add(new ExploreModel("Kulangsu Huandao Road", "Enjoy a comfortable bike ride with the sea breeze.","4", R.drawable.kulangsu_road1));
        exploreModelArrayList.add(new ExploreModel("Xiamen Bailuzhou Park", "Experience a modern park with interesting sculptures.", "4", R.drawable.bailuzhou));
        // add data to second recycler view
        arrayList2 = new ArrayList<>();
        arrayList2.add(new ExploreModel("South Putuo Temple", "A hundred-plus years old Buddhist temple with ornate decorations and impressive statues.", "4", R.drawable.southputuotemple5));
        arrayList2.add(new ExploreModel("Xiamen Piano Museum", "Explore the story behind antique and vintage pianos.","4",R.drawable.piano_musuem3));
        arrayList2.add(new ExploreModel("Overseas Chinese Museum", "Get to know more about the story of overseas chinese.", "4", R.drawable.museum_chinese));

        // we are initializing our adapter class and passing our arraylist to it.
        RecyclerViewAdapter Adapter = new RecyclerViewAdapter(getActivity(), exploreModelArrayList, fragmentCommunication1);
        RecyclerViewAdapter Adapter2 = new RecyclerViewAdapter(getActivity(), arrayList2,fragmentCommunication1);

        // setting a layout manager for our recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        // setting layoutmanager and adapter to our recycler view.
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Adapter);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(Adapter2);
        return view;
    }
}

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

public class FoodFragment extends Fragment {
    private RecyclerView recyclerView, recyclerView2;
    private ArrayList<ExploreModel> exploreModelArrayList, arrayList2;
    private RecyclerViewAdapter.FragmentCommunication fragmentCommunication1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_food,container,false);
        recyclerView = view.findViewById(R.id.recyclerview_food);
        recyclerView2 = view.findViewById(R.id.recyclerview_food2);
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
        exploreModelArrayList.add(new ExploreModel("Shacha Mian", "Noodles", "4",R.drawable.shachamian));
        exploreModelArrayList.add(new ExploreModel("Fried Oysters Omelet", "Snack, SeaFood", "4.5", R.drawable.friedoyster4));
        exploreModelArrayList.add(new ExploreModel("Tusundong", "Snack, SeaFood","4", R.drawable.tusundong3));
        exploreModelArrayList.add(new ExploreModel("Jiangmu Duck", "Duck", "4", R.drawable.duck4));
        exploreModelArrayList.add(new ExploreModel("Mianxianhu", "Noodles, Breakfast", "3.5", R.drawable.mianxianhu));
        // add data to second recycler view
        arrayList2 = new ArrayList<>();
        arrayList2.add(new ExploreModel("Zhongshan Road Walking Street", "A street lined up with various local snacks and shops", "4", R.drawable.zhongshan_street));
        arrayList2.add(new ExploreModel("Zeng Cuo An Village", "Enjoy the delicious delicates in a fishing village", "4", R.drawable.zengcuoan1));

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

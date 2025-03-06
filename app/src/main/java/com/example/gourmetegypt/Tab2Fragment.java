package com.example.gourmetegypt;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2Fragment extends Fragment {
    RecyclerView recyclerRecipe;

    RecyclerView.Adapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        GridLayoutManager gridLayoutManager= new GridLayoutManager(getActivity(), 2);
        recyclerRecipe = view.findViewById(R.id.recyclerRecipeTab2);
        recyclerRecipe.setLayoutManager(gridLayoutManager);

        int[] recipeImages = {R.drawable.recipe3, R.drawable.recipe6, R.drawable.recipe2, R.drawable.recipe4, R.drawable.recipe7,
                R.drawable.recipe2, R.drawable.recipe5};
        String[] recipeTitles = {"Whole Roasted Chicken",
                "Marinated Australian Lamb Leg Recipe",
                "Honey & Soy Glazed Chicken Drumsticks",
                "Dukkah Crusted Baked Salmon Fillet",
                "Stuffed Bell Peppers",
                "Sausage Tartine",
                "Orzo with Clams, Calamari Rings & Arribbiata Sauce"};
        String[] recipeDetails = {"High in protein", "High in protein", "Party, Vegan", "Healthy", "Sweet", "Vegan", "Super food"};
        adapter = new RecipeListAdapter(recipeImages, recipeTitles, recipeDetails);
        recyclerRecipe.setAdapter(adapter);

        return view;
    }
}
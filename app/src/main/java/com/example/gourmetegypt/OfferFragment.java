package com.example.gourmetegypt;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OfferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfferFragment newInstance(String param1, String param2) {
        OfferFragment fragment = new OfferFragment();
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
        View view =  inflater.inflate(R.layout.fragment_offer, container, false);
        RecyclerView recyclerOffer;
        RecyclerView.Adapter adapter;

        GridLayoutManager gridLayoutManager= new GridLayoutManager(getActivity(), 2);
        recyclerOffer = view.findViewById(R.id.recyclerOffer);
        recyclerOffer.setLayoutManager(gridLayoutManager);
        int[] offerImages = {R.drawable.offer1, R.drawable.offer2, R.drawable.offer3, R.drawable.offer4, R.drawable.offer5,
                R.drawable.offer6, R.drawable.offer7, R.drawable.offer8, R.drawable.offer9, R.drawable.offer10};
        String[] offerNames = {"Milka Sweet Alpine Milk Chocolate",
                "Lasagna Bolognese Small",
                "Gourmet Christmas Cookies Tin",
                "Gourmet Frozen Eggplant Parmigiana",
                "Gourmet Christmas Biscotti Tin",
                "Maison Popcorn With Salt",
                "Motta Original Panettone",
                "Cherries, Imported",
                "French Almond & Lemon Croissant",
                "Gourmet Cinnamon Star Cookies"};
        double[] offerPrices = {51.00, 199.32, 63.00, 9.54, 255.00, 72.00, 115.50, 105.44, 74.00, 98.00};
        adapter = new OfferListAdapter(offerImages, offerNames, offerPrices);
        recyclerOffer.setAdapter(adapter);
        return view;
    }
}
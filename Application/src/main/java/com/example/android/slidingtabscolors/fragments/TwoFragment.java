package com.example.android.slidingtabscolors.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.slidingtabscolors.R;
import com.example.android.slidingtabscolors.activity.HelloActivity;

import java.util.ArrayList;
import java.util.HashMap;


public class TwoFragment extends Fragment{

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    public TwoFragment() {
        // Required empty public constructor
    }

    String[] Malesinger = {"Akshaya Mohanty",
            "Alphons Joseph",
            "Aman Trikha",
            "Amit Kumar",
            "Amit Trivedi",
            "Anirudh Ravichander",
            "Anuj Gurwara",
            "Anupam Roy",
            "Anwar",
            "Abhijeet Bhattacharya",
            "Abhijeet Sawant",
            "A R Rahman",
            "Arijit Singh",
            "Ankit Tiwari",
            "Armaan Malik",
            "Atif Aslam",
            "Babul Supriyo",
            "Badshah",
            "Bhimsen Joshi",
            "Bhupen Hazarika",
            "Bhupinder",
            "Blaaze",
            "Biju Narayanan",
            "Bohemia (musician)",
            "Chetan Sosca",
            "Clinton Cerejo",
            "Damodar Raao",
            "Devan Ekambaram",
            "Daler Mehndi",
            "Dhananjay Bhattacharya",
            "Dhanush",
            "Diwakar",
            "Dwijen Mukhopadhyay",
            "G. M. Durrani",
            "Ghantasala Venkateswara Rao",
            "Gurdas Maan",
            "Hariharan",
            "Hemant Kumar",
            "Himesh Reshammiya",
            "Jagjit Singh",
            "Jassie Gift",
            "Mohan Rathore",
            "Javed Ali",
            "Jayachandran",
            "Jubin Nautiyal",
            "Kailash Kher",
            "Kamal Haasan",
            "Karthik",
            "Kishore Kumar",
            "KK",
            "K. J. Yesudas",
            "Kozhikode Abdul Kader",
            "Krishna Beura",
            "Krishna Iyer",
            "Kundan Lal Saigal",
            "Kumar Sanu",
            "Kunal Ganjawala",
            "Lucky Ali",
            "M. G. Sreekumar",
            "Madhu Balakrishnan",
            "Mahendra Kapoor",
            "Malaysia Vasudevan",
            "Manabendra Mukhopadhyay",
            "Manikka Vinayagam",
            "Manna Dey",
            "Mano",
            "Master Saleem",
            "Mohammed Rafi",
            "Mohammed Aziz",
            "Mukesh",
            "Mynampati Sreeram Chandra",
            "Mohit Chauhan",
            "Naresh Iyer",
            "Najim Arshad",
            "Nitin Mukesh",
            "Navin Prabhakar",
            "P. B. Sreenivas",
            "Pankaj Mullick",
            "Pankaj Udhas",
            "Papon",
            "Pradip Somasundaran",
            "Rahat Fateh Ali Khan",
            "Rahul Vaidya",
            "Rajesh Krishnan",
            "Rajkumar",
            "Remo Fernandes",
            "Roop Kumar Rathod",
            "Rupam Islam",
            "sanam puri",
            "Silambarasan",
            "S. P. Balasubrahmanyam",
            "S. P. B. Charan",
            "Saandip",
            "Sandeep Khurana",
            "Shaan",
            "Shabab Sabri",
            "Shabbir Kumar",
            "Shahid Mallya",
            "Shailender Singh",
            "Shankar Mahadevan",
            "Shyamal Mitra",
            "Sudesh Bhosle",
            "Suraj Jagan",
            "Soham Chakraborty (singer)",
            "Sonu Nigam",
            "Sriram Parthasarathy",
            "Sundar Narayana Rao",
            "Suresh Wadkar",
            "Talat Mahmood",
            "Tochi Raina",
            "Thomson Andrews",
            "T. M. Soundararajan",
            "Unni Menon",
            "Unnikrishnan",
            "Vijay Yesudas",
            "Joseph Vijay",
            "Vijay Prakash",
            "Vineeth Sreenivasan",
            "Yo Yo Honey Singh",
            "Mohan Rathod",
            "Zubeen Garg"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        // Listview Data

        lv = (ListView) rootView.findViewById(R.id.list_view);
        inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                TwoFragment.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Malesinger);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 11) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 12) {
                    Intent myIntent = new Intent(view.getContext(), HelloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });


    }
}
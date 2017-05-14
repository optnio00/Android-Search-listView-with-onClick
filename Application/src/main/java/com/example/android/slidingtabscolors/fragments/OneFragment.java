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
import android.widget.TextView;

import com.example.android.slidingtabscolors.R;
import com.example.android.slidingtabscolors.activity.HelloActivity;
import com.example.android.slidingtabscolors.activity.HelloActivity2;

import java.util.ArrayList;
import java.util.HashMap;


public class OneFragment extends Fragment{
    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    public OneFragment() {
        // Required empty public constructor
    }

    String[] Musician = {"Abhimann Roy","Raushan kumar"," Aadesh Shrivastava"," Aby Tom Cyriac"," Abhimann Roy"," Achu Rajamani"," Adnan Sami"," Ajay−Atul"," Amaal Mallik"," Anand Bakshi"," Amit Trivedi"," Anand Raj Anand"," Anand–Milind"," Anand Modak",
            " Anil Biswas"," Anil Mohile"," Anirudh Ravichander"," Hiphop Tamizha"," Santhosh Narayanan"," Anup Rubens"," Mickey J Meyer"," Anoop Seelin"," Anu Malik"," Arjuna Harjai"," Arjun Janya"," Arun Paudwal"," Ashok Patki"," Avadhoot Gupte"," C. Ashwath"," S. D. Burman","S. P. Balasubrahmanyam",
            " M. S. Baburaj"," Bappi Lahiri"," Bennet–Veetraag"," Berny-Ignatius"," Bharathwaj"," Bhaskar Chandavarkar"," Bhavatharini"," Bhupen Hazarika"," Bijibal"," Baba Sehgal"," C.Arjun"," Chakri"," Chitragupta"," Chowdiah"," Colonial Cousins"," V. Dakshinamoorthy"," Datta Naik (N Datta"," Dattaram (Datta Wadkar)"," Damodar Raao"," Deva"," Devan Ekambaram"," Devi Sri Prasad"," Deepak Dev"," Dharan"," Dhina"," Dilup Dholakia"," G. Devarajan"," Gangai Amaran"," Gopi Sunder"," Ghantasala"," Gurukiran",
            " Hamsalekha"," Hansraj Bahal"," Harris Jayaraj", " Datta Korgaonkar (K Datta"," Hemanta Kumar Mukhopadhyay"," Himesh Reshammiya", " Hridaynath Mangeshkar"," Honey Singh"," Ishaan Dev"," V. Harikrishna"," Husanlal Bhagatram"," Ilayaraja"," Ismail Darbar"," Imman"," Jagjit Singh"," James Vasanthan"," Jassie Gift"," Jatin–Lalit"," Jerry Amaldev"," Johnson"," Joshua Sridhar"," Joy Sarkar"," M. Jayachandran"," Jan Babu qawwal"," M. M. Keeravani/M. M. Kreem"," K. Kalyan"," Mukesh"," Kailash-Naresh-Paresh",
            " Kalyanji Anandji"," P. Kalinga Rao"," Karthik"," Karthik Raja","Khayyam"," Kemchand Prakash"," Kishore Kumar"," S. P. Kodandapani"," V. Kumar"," Kumar Sanu"," Kunnakudi Vaidyanathan"," Lalit Pandit"," Laxmikant–Pyarelal"," Lesle Lewis"," T. G. Lingappa"," V. Manohar"," K. V. Mahadevan"," Lata Mangeshkar"," Madan Mohan"," Mani Sharma"," Manikanth Kadri"," Mano Murthy"," Manoj S"," Mithoon Sharma"," Monty Sharma"," Meet Bros"," Mejo Joseph"," Neeta Sen"," Nadeem–Shravan"," Naushad Ali"," Nitz 'N' Sony",
            " Nusrat Fateh Ali Khan"," O. P. Nayyar"," Ouseppachan"," Pankaj Mullick"," Papanasam Sivan"," Pendyala Nageswara Rao"," S. Narayan"," G. V. Prakash Kumar"," Krishnarao Phulambrikar"," Prashant Pillai"," Pravin Mani"," Praveen D Rao"," Premgi Amaren"," Pritam Chakraborty"," C. Ramchandra (Ramachandra Chitalkar)"," A. R. Rahman"," Rahul Dev Burman","Ramjeevan"," A. R. Reihana"," R. P. Patnaik"," Raghu Dixit"," Rahul Raj"," Raj-Koti"," Perumbavoor G. Raveendranath"," M. Ranga Rao"," Rajan–Nagendra",
            " Rajesh Ramanath"," Rajesh Roshan"," S. A. Rajkumar"," Ram Kadam"," Ram Lakshman"," Ramana Gogula"," Ramesh Naidu"," J. V. Raghavulu"," Ranjit Barot"," Raveendran"," V. Ravichandran"," Ravindra Jain"," Ricky Kej"," Roop Kumar Rathod"," Roshan"," T. K. Ramamoorthy"," M. G. Radhakrishnan"," M. G. Sreekumar"," Sanjib Sarkar"," Sachin–Jigar"," Salur Rajeswara Rao"," Sadhu Kokila"," Sagar S."," Salil Chowdhury"," Salim–Sulaiman"," Sajid–Wajid"," Sandesh Shandilya"," Sandeep Chowta"," Sanjay Leela Bhansali",
            " S. J. Jananiy"," Swaroop Anshuman Roy"," Sanjeev–Darshan"," Sankar Ganesh"," Satyam"," Selvaganesh"," Shankar–Ehsaan–Loy"," Shankar Mahadevan"," Shankar-Jaikishan"," Shantanu Moitra"," Sharreth"," Shyam"," Shruti Haasan"," K. S. Simon"," Sneha Khanwalkar"," Srinivas"," Sohail Sen"," Srikanth Deva"," Snehal Bhatkar"," Sajjad Hussain"," Sudhir Phadke"," Malhotra"," Sukhwinder Singh"," Suresh Peters"," S. Thaman"," Thomas Rathnam"," Upendra Kumar"," Usha Khanna"," Uttam Singh"," Varun Unni"," L. Vaidyanathan",
            " Vani Harikrishna"," Vasant Desai"," M. Venkataraju"," G. K. Venkatesh"," S. P. Venkatesh"," M. S. Viswanathan"," Zakir Hussain"," Vidyasagar"," Vijay Antony"," Vijay Prakash"," Vijaya Bhaskar"," Viju Shah"," Vishal Bhardwaj"," Vivek Sagar"," Vishal–Shekhar",
            "Yuvan Shankar Raja","Zubeen Garg","Debojyoti Mishra"};

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
                OneFragment.this.adapter.getFilter().filter(cs);
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
                R.layout.list_item, Musician);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
               // LinearLayout ll = (LinearLayout) arg1;
                TextView tv = (TextView) arg1.findViewById(R.id.product_name1);
                String str = tv.getText().toString().trim();

                if (str.equals(Musician[0])) {
                    Intent int0 = new Intent(getContext(), HelloActivity.class);
                    startActivity(int0);
                }else if(str.equals(Musician[1])) {
                    Intent int1 = new Intent(getContext(), HelloActivity2.class);
                    startActivity(int1);
                }
            }
        });


    }
}

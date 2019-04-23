package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Arrays;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "DONK";
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali", "Kebnekaise","K2","Mount Everest","Kangchenjunga"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));
    private ArrayList<Mountain> mountainArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mountainArrayList.add(new Mountain("Matterhorn","Alperna",4478));
        mountainArrayList.add(new Mountain("Mont Blanc","Alperna",4808));
        mountainArrayList.add(new Mountain("Denali","Alaska",6190));
        mountainArrayList.add(new Mountain("Kebnekaise","Skanderna",2106));
        mountainArrayList.add(new Mountain("K2","Himalaya",8611));
        mountainArrayList.add(new Mountain("Mount Everest","Himalaya",8848));
        mountainArrayList.add(new Mountain("Kangchenjunga","Himalaya",8586));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_items,R.id.list_item_textview,listData);
        final ListView my_listview=(ListView) findViewById(R.id.list_item_textview_list);
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MountainDetailsActivity.class);
                String minfo = mountainArrayList.get(position).info();
                intent.putExtra(EXTRA_MESSAGE, minfo);
                startActivity(intent);
            }

        });
        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.

    }



}

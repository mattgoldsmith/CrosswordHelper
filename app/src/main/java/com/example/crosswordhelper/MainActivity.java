package com.example.crosswordhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<String> words;
    public static ArrayList<String> filteredWords;
    public static final String EXTRA_MESSAGE = "com.example.crosswordhelper.MESSAGE";
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        /**Use this for testing**/
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("5B75434FE04CF61695C5822866803C59").build();
        /**Use this for release**/
        //AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        words = new ArrayList<String>();

        String data;

        InputStream is = this.getResources().openRawResource(R.raw.words_alpha);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if(is != null){
            try{
                while((data = reader.readLine())!= null) {
                    words.add(data);
                }
                is.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        ArrayList<Integer> lengths = new ArrayList<Integer>();

        //get the distinct lengths of the words
        for(String word : words){
            if(lengths.contains(word.length())){
                continue;
            }
            else{
                lengths.add(word.length());
            }
        }

        //sort the lengths
        Collections.sort(lengths);

        Integer[] lengthList = lengths.toArray(new Integer[lengths.size()]);

        Spinner lengthsDD = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, lengthList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthsDD.setAdapter(adapter);
    }

    /** Called when the user taps the Send button */
    public void confirmLength(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, InputLetters.class);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String message = spinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        ArrayList<String> filteredWords = filterByLength(Integer.valueOf(message));

        //Bundle bundle = new Bundle();
        //bundle.putParcelableArrayList("wordsArray",filteredWords);
        //bundle.putParcelableArrayList("failList",failList);
        //bundle.putStringArrayList("wordsList",filteredWords);

        //intent.putExtras(bundle);

        //intent.putParcelableArrayListExtra("wordsList",filteredWords);

        //bundle.putSerializable("wordsSerialised",filteredWords);

        //intent.putExtras(bundle);

        //intent.putExtra("filteredWords",filteredWords);
        startActivity(intent);
    }

    private ArrayList<String> filterByLength(int length){
        if(filteredWords == null){
            filteredWords = new ArrayList<>();
        }
        else if(filteredWords.size() > 0){
            filteredWords.clear();
        }
        //ArrayList<String> filteredWords = new ArrayList<String>();

        for(String word : words){
            if(word.length() == length){
                filteredWords.add(word);
            }
        }

        return  filteredWords;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


}

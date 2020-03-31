package com.example.crosswordhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowWords extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();
    private AdView mAdView;
    private int page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_words);

        mAdView = findViewById(R.id.adView3);
        /**Use this for testing**/
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("5B75434FE04CF61695C5822866803C59").build();
        /**Use this for release**/
        //AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        page = 0;

        list = InputLetters.finalWords; //intent.getStringArrayListExtra("FinalWords");

        TextView textView = findViewById(R.id.textView7);
        textView.setText(displayWords(list));
        //textView.setMovementMethod(new ScrollingMovementMethod());

        TextView textView1 = findViewById(R.id.textView5);
        textView1.setText(list.size() + " words found");

        Button button = findViewById(R.id.previous100Button);
        button.setEnabled(false);

        if((page * 100) + 100 > list.size()){
            Button button1 = findViewById(R.id.next100Button);
            button1.setEnabled(false);
        }
    }

    /** Called when the user taps the New Word button */
    public void newWord(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        //Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //String message = spinner.getSelectedItem().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private String displayWords(ArrayList<String> words){
        String wordsList = "";

        System.out.println("displayWords: " + page);

        int startPage = page * 100;

        System.out.println("StartPage: " + startPage);

        int i = 1;
        for(String word : words.subList(startPage,words.size())){
            wordsList = wordsList + (startPage+i) + " - " + word;

            i++;
            if(i > 100){
                System.out.println("i: " + i);
                break;
            }

            if(startPage + i <= words.size()){
                wordsList = wordsList + "\n";
            }

        }
        //System.out.println(wordsList.toString());
        //System.out.println(words.size() + ": " + i);
        return wordsList;
    }

    public void nextPage(View view){

        page++;

        if(page * 100 < list.size()){
            TextView textView = findViewById(R.id.textView7);
            textView.setText(displayWords(list));

            ScrollView scrollView = findViewById(R.id.ShowWordsScrollView);
            scrollView.setScrollY(0);

            if((page * 100) + 100 > list.size()){
                Button button = findViewById(R.id.next100Button);
                button.setEnabled(false);
            }

            Button button = findViewById(R.id.previous100Button);
            button.setEnabled(true);

        }
    }

    public void previousPage(View view){

        page--;

        if(page >= 0){
            TextView textView = findViewById(R.id.textView7);
            textView.setText(displayWords(list));

            ScrollView scrollView = findViewById(R.id.ShowWordsScrollView);
            scrollView.setScrollY(0);

            if(page == 0){
                Button button = findViewById(R.id.previous100Button);
                button.setEnabled(false);
            }

            Button button = findViewById(R.id.next100Button);
            button.setEnabled(true);
        }
    }
}

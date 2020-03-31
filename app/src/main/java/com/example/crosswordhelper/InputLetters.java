package com.example.crosswordhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class InputLetters extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.crosswordhelper.MESSAGE";
    public static ArrayList<String> filteredWords;
    public int length;
    public static  ArrayList<String> finalWords;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_letters);

        mAdView = findViewById(R.id.adView2);
        /**Use this for testing**/
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("5B75434FE04CF61695C5822866803C59").build();
        /**Use this for release**/
        //AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        /*TextView textView = findViewById(R.id.textView4);
        textView.setText("Length chosen: " + message);*/

        filteredWords = MainActivity.filteredWords; //intent.getExtras().getStringArrayList("wordsSerialised");

        //filteredWords = intent.getStringArrayListExtra("filteredWords");

        length = Integer.valueOf(message);

        removeViews(Integer.valueOf(message));

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

    /** Called when the user taps the New Word button */
    public void confirmLetters(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ShowWords.class);
        //Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //String message = spinner.getSelectedItem().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        finalWords = filterByLetters(filteredWords);

        //intent.putExtra("FinalWords",finalWords);
        startActivity(intent);
    }

    public ArrayList<String> filterByLetters(/*HashMap<Integer,JTextField> hash*/ ArrayList<String> filteredWords){

        ArrayList<String> list = new ArrayList<String>();

        HashMap<Integer, String> hash = getLetters(length);
        //SparseArray<String> hash = new SparseArray<>();

        //Compare given letters to words
        for(String word : filteredWords){
            for(Integer key : hash.keySet()){
                if(hash.get(key).trim().length() < 1){
                    continue;
                }
                if(hash.get(key).toLowerCase().trim().charAt(0) != word.charAt(key-1)){
                    list.add(word);
                    break;
                }
            }
        }

        //Remove mismatching words
        for(String word : list){
            filteredWords.remove(word);
        }

        return filteredWords;
    }

    private void removeViews(int length){
        if(length < 31){
            View textBox = findViewById(R.id.editText31);
            View label = findViewById(R.id.textFieldDisplay31);
            View guideline = findViewById(R.id.guidelineInner7);

            EditText previous = findViewById(R.id.editText30);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 30){
            View textBox = findViewById(R.id.editText30);
            View label = findViewById(R.id.textFieldDisplay30);

            EditText previous = findViewById(R.id.editText29);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 29){
            View textBox = findViewById(R.id.editText29);
            View label = findViewById(R.id.textFieldDisplay29);

            EditText previous = findViewById(R.id.editText28);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 28){
            View textBox = findViewById(R.id.editText28);
            View label = findViewById(R.id.textFieldDisplay28);

            EditText previous = findViewById(R.id.editText27);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 27){
            View textBox = findViewById(R.id.editText27);
            View label = findViewById(R.id.textFieldDisplay27);

            EditText previous = findViewById(R.id.editText26);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 26){
            View textBox = findViewById(R.id.editText26);
            View label = findViewById(R.id.textFieldDisplay26);
            View guideline = findViewById(R.id.guidelineInner6);

            EditText previous = findViewById(R.id.editText25);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 25){
            View textBox = findViewById(R.id.editText25);
            View label = findViewById(R.id.textFieldDisplay25);

            EditText previous = findViewById(R.id.editText24);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 24){
            View textBox = findViewById(R.id.editText24);
            View label = findViewById(R.id.textFieldDisplay24);

            EditText previous = findViewById(R.id.editText23);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 23){
            View textBox = findViewById(R.id.editText23);
            View label = findViewById(R.id.textFieldDisplay23);

            EditText previous = findViewById(R.id.editText22);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 22){
            View textBox = findViewById(R.id.editText22);
            View label = findViewById(R.id.textFieldDisplay22);

            EditText previous = findViewById(R.id.editText21);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 21){
            View textBox = findViewById(R.id.editText21);
            View label = findViewById(R.id.textFieldDisplay21);
            View guideline = findViewById(R.id.guidelineInner5);

            EditText previous = findViewById(R.id.editText20);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 20){
            View textBox = findViewById(R.id.editText20);
            View label = findViewById(R.id.textFieldDisplay20);

            EditText previous = findViewById(R.id.editText19);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 19){
            View textBox = findViewById(R.id.editText19);
            View label = findViewById(R.id.textFieldDisplay19);

            EditText previous = findViewById(R.id.editText18);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 18){
            View textBox = findViewById(R.id.editText18);
            View label = findViewById(R.id.textFieldDisplay18);

            EditText previous = findViewById(R.id.editText17);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 17){
            View textBox = findViewById(R.id.editText17);
            View label = findViewById(R.id.textFieldDisplay17);

            EditText previous = findViewById(R.id.editText16);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 16){
            View textBox = findViewById(R.id.editText16);
            View label = findViewById(R.id.textFieldDisplay16);
            View guideline = findViewById(R.id.guidelineInner4);

            EditText previous = findViewById(R.id.editText15);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 15){
            View textBox = findViewById(R.id.editText15);
            View label = findViewById(R.id.textFieldDisplay15);

            EditText previous = findViewById(R.id.editText14);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 14){
            View textBox = findViewById(R.id.editText14);
            View label = findViewById(R.id.textFieldDisplay14);

            EditText previous = findViewById(R.id.editText13);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 13){
            View textBox = findViewById(R.id.editText13);
            View label = findViewById(R.id.textFieldDisplay13);

            EditText previous = findViewById(R.id.editText12);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 12){
            View textBox = findViewById(R.id.editText12);
            View label = findViewById(R.id.textFieldDisplay12);

            EditText previous = findViewById(R.id.editText11);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 11){
            View textBox = findViewById(R.id.editText11);
            View label = findViewById(R.id.textFieldDisplay11);
            View guideline = findViewById(R.id.guidelineInner3);

            EditText previous = findViewById(R.id.editText10);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 10){
            View textBox = findViewById(R.id.editText10);
            View label = findViewById(R.id.textFieldDisplay10);

            EditText previous = findViewById(R.id.editText9);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 9){
            View textBox = findViewById(R.id.editText9);
            View label = findViewById(R.id.textFieldDisplay9);

            EditText previous = findViewById(R.id.editText8);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 8){
            View textBox = findViewById(R.id.editText8);
            View label = findViewById(R.id.textFieldDisplay8);

            EditText previous = findViewById(R.id.editText7);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 7){
            View textBox = findViewById(R.id.editText7);
            View label = findViewById(R.id.textFieldDisplay7);

            EditText previous = findViewById(R.id.editText6);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 6){
            View textBox = findViewById(R.id.editText6);
            View label = findViewById(R.id.textFieldDisplay6);
            View guideline = findViewById(R.id.guidelineInner2);

            EditText previous = findViewById(R.id.editText5);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
            ((ViewGroup) guideline.getParent()).removeView(guideline);
        }
        if(length < 5){
            View textBox = findViewById(R.id.editText5);
            View label = findViewById(R.id.textFieldDisplay5);

            EditText previous = findViewById(R.id.editText4);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 4){
            View textBox = findViewById(R.id.editText4);
            View label = findViewById(R.id.textFieldDisplay4);

            EditText previous = findViewById(R.id.editText3);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 3){
            View textBox = findViewById(R.id.editText3);
            View label = findViewById(R.id.textFieldDisplay3);

            EditText previous = findViewById(R.id.editText2);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }
        if(length < 2){
            View textBox = findViewById(R.id.editText2);
            View label = findViewById(R.id.textFieldDisplay2);

            EditText previous = findViewById(R.id.editText1);
            previous.setImeOptions(EditorInfo.IME_ACTION_DONE);

            ((ViewGroup) textBox.getParent()).removeView(textBox);
            ((ViewGroup) label.getParent()).removeView(label);
        }

    }

    private HashMap<Integer,String> getLetters(int length){

        HashMap<Integer,String > finalWords = new HashMap<>();

        if(length >= 31){
            EditText textBox = findViewById(R.id.editText31);
            TextView label = findViewById(R.id.textFieldDisplay31);

            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());

        }
        if(length >= 30){
            EditText textBox = findViewById(R.id.editText30);
            TextView label = findViewById(R.id.textFieldDisplay30);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 29){
            EditText textBox = findViewById(R.id.editText29);
            TextView label = findViewById(R.id.textFieldDisplay29);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 28){
            EditText textBox = findViewById(R.id.editText28);
            TextView label = findViewById(R.id.textFieldDisplay28);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 27){
            EditText textBox = findViewById(R.id.editText27);
            TextView label = findViewById(R.id.textFieldDisplay27);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 26){
            EditText textBox = findViewById(R.id.editText26);
            TextView label = findViewById(R.id.textFieldDisplay26);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 25){
            EditText textBox = findViewById(R.id.editText25);
            TextView label = findViewById(R.id.textFieldDisplay25);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 24){
            EditText textBox = findViewById(R.id.editText24);
            TextView label = findViewById(R.id.textFieldDisplay24);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 23){
            EditText textBox = findViewById(R.id.editText23);
            TextView label = findViewById(R.id.textFieldDisplay23);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 22){
            EditText textBox = findViewById(R.id.editText22);
            TextView label = findViewById(R.id.textFieldDisplay22);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 21){
            EditText textBox = findViewById(R.id.editText21);
            TextView label = findViewById(R.id.textFieldDisplay21);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 20){
            EditText textBox = findViewById(R.id.editText20);
            TextView label = findViewById(R.id.textFieldDisplay20);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 19){
            EditText textBox = findViewById(R.id.editText19);
            TextView label = findViewById(R.id.textFieldDisplay19);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 18){
            EditText textBox = findViewById(R.id.editText18);
            TextView label = findViewById(R.id.textFieldDisplay18);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 17){
            EditText textBox = findViewById(R.id.editText17);
            TextView label = findViewById(R.id.textFieldDisplay17);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 16){
            EditText textBox = findViewById(R.id.editText16);
            TextView label = findViewById(R.id.textFieldDisplay16);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 15){
            EditText textBox = findViewById(R.id.editText15);
            TextView label = findViewById(R.id.textFieldDisplay15);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 14){
            EditText textBox = findViewById(R.id.editText14);
            TextView label = findViewById(R.id.textFieldDisplay14);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 13){
            EditText textBox = findViewById(R.id.editText13);
            TextView label = findViewById(R.id.textFieldDisplay13);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 12){
            EditText textBox = findViewById(R.id.editText12);
            TextView label = findViewById(R.id.textFieldDisplay12);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 11){
            EditText textBox = findViewById(R.id.editText11);
            TextView label = findViewById(R.id.textFieldDisplay11);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 10){
            EditText textBox = findViewById(R.id.editText10);
            TextView label = findViewById(R.id.textFieldDisplay10);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 9){
            EditText textBox = findViewById(R.id.editText9);
            TextView label = findViewById(R.id.textFieldDisplay9);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 8){
            EditText textBox = findViewById(R.id.editText8);
            TextView label = findViewById(R.id.textFieldDisplay8);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 7){
            EditText textBox = findViewById(R.id.editText7);
            TextView label = findViewById(R.id.textFieldDisplay7);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 6){
            EditText textBox = findViewById(R.id.editText6);
            TextView label = findViewById(R.id.textFieldDisplay6);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 5){
            EditText textBox = findViewById(R.id.editText5);
            TextView label = findViewById(R.id.textFieldDisplay5);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 4){
            EditText textBox = findViewById(R.id.editText4);
            TextView label = findViewById(R.id.textFieldDisplay4);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 3){
            EditText textBox = findViewById(R.id.editText3);
            TextView label = findViewById(R.id.textFieldDisplay3);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 2){
            EditText textBox = findViewById(R.id.editText2);
            TextView label = findViewById(R.id.textFieldDisplay2);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }
        if(length >= 1){
            EditText textBox = findViewById(R.id.editText1);
            TextView label = findViewById(R.id.textFieldDisplay1);
            finalWords.put(Integer.valueOf(label.getText().toString()),textBox.getText().toString());
        }

        return finalWords;
    }

}

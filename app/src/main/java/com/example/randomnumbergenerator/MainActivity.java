package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateRandom(View view){
        EditText initial_num ,final_num;
        TextView result;
        String output;
        Random random = new Random();

        initial_num = (EditText)findViewById(R.id.initial_num);
        final_num = (EditText)findViewById(R.id.final_num);
        result = (TextView)findViewById(R.id.textView4);

        int min;
        try{
            min = Integer.parseInt(initial_num.getText().toString());
        }
        catch (Exception e){
            min = 1;
        }

        int max;
        try {
            max = Integer.parseInt(final_num.getText().toString());
        }
        catch (Exception e){
            max = 100;
        }

        output = "" + (random.nextInt(max - min + 1) + min);
        result.setText(output);
        result.setVisibility(View.VISIBLE);
    }

}
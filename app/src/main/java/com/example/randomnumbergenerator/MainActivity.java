package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
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
        EditText initial_num, final_num;
        TextView result;
        String output;
        Random random = new Random();

        initial_num = findViewById(R.id.initial_num);
        final_num = findViewById(R.id.final_num);
        result = findViewById(R.id.textView4);

        float min;

        // Setting default values in case of input exceptions
        try{
            min = Float.parseFloat(initial_num.getText().toString());
        }
        catch (Exception e){
            min = 1;
        }

        float max;
        try {
            max = Float.parseFloat(final_num.getText().toString());
        }
        catch (Exception e){
            max = 100;
        }

        Boolean validation = validationSuccess(min, max);

        if(validation) {
            output = "" + (random.nextInt((int) max - (int) min + 1) + (int) min);
            result.setText(output);
            result.setVisibility(View.VISIBLE);
        }
        else{
            alertDialog();
        }

    }

    // Alerts user in case of invalid input
    private void alertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Please enter valid integer inputs").setCancelable(false).setPositiveButton("OK", (dialog, id) -> dialog.cancel());

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    // Checks if input data is integer and if min < max
    private Boolean validationSuccess(float min, float max){
        return !(max < min) && !(max - (int) max > 0) && !(min - (int) min > 0);
    }

}
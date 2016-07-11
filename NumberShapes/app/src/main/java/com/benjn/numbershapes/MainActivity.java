package com.benjn.numbershapes;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void testNumber(View view){

        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);
        String message ="";

        if(usersNumber.getText().toString().isEmpty()){
            message = "Please Enter a Number";
        }else {

            Number myNum = new Number();
            myNum.number = Integer.parseInt(usersNumber.getText().toString());
            boolean isSquare = myNum.isSquare();
            boolean isTri = myNum.isTriangular();


            if (isSquare) {
                if (isTri) {
                    message = myNum.number + " is both Triangular and Square!";
                } else {
                    message = myNum.number + " is a Square!";
                }
            } else {
                if (isTri) {
                    message = myNum.number + " is Triangular!";
                } else {
                    message = myNum.number + " is NOT Triangular or Square!";
                }
            }
        }

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

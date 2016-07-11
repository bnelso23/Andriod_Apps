package com.benjn.currencyconverter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){

        EditText dollarAmount = (EditText) findViewById(R.id.dollarAmount);

        Double dollarDouble = Double.parseDouble(dollarAmount.getText().toString());

        Double poundAmount = dollarDouble * 0.65;

        Log.i("poundAmount", poundAmount.toString());

        Toast.makeText(getApplicationContext(),poundAmount.toString()+" pounds!",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

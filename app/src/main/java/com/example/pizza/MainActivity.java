package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ImageView iv = (ImageView)findViewById(R.id.submit);
final EditText rozmiar_1 = findViewById(R.id.rozmiar_1);
final EditText rozmiar_2 = findViewById(R.id.rozmiar_2);
final EditText cena_1 = findViewById(R.id.cena_1);
final EditText cena_2 = findViewById(R.id.cena_2);
final TextView wynik = findViewById(R.id.wynik);


iv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (rozmiar_1.getText().toString().isEmpty() || rozmiar_2.getText().toString().isEmpty() || cena_1.getText().toString().isEmpty() || cena_2.getText().toString().isEmpty()){
            if (rozmiar_1.getText().toString().isEmpty()){
                rozmiar_1.setError("Wprowadz wartosc");
            }
            if (rozmiar_2.getText().toString().isEmpty()){
                rozmiar_2.setError("Wprowadz wartość");
            }
            if (cena_1.getText().toString().isEmpty()){
                cena_1.setError("Wprowadz wartość");
            }
            if (cena_2.getText().toString().isEmpty()){
                cena_2.setError("Wprowadz wartość");
            }
        }else{
            /* METRY */ double powierzchnia_1 = (((0.5*(Double.parseDouble(rozmiar_1.getText().toString())))*(0.5*(Double.parseDouble(rozmiar_1.getText().toString())))) * 3.14)*0.0001;
            /* METRY */ double powierzchnia_2 = (((0.5*(Double.parseDouble(rozmiar_2.getText().toString())))*(0.5*(Double.parseDouble(rozmiar_2.getText().toString())))) * 3.14)*0.0001;

            Log.v("Powierzchnia 1: ","=" + powierzchnia_1);
            Log.v("Powierzchnia 2","=" + powierzchnia_2);

            double cena_nr1 = Double.parseDouble(cena_1.getText().toString());
            double cena_nr2 = Double.parseDouble(cena_2.getText().toString());

            double cena_nr1_metr = (1/powierzchnia_1)*cena_nr1;
            double cena_nr2_metr = (1/powierzchnia_2)*cena_nr2;
            double porownanie;

            if (cena_nr1_metr>cena_nr2_metr){
                porownanie = (1-(cena_nr2_metr/cena_nr1))*100;
                wynik.setText("Pizza nr 2 jest tansza o "+porownanie+"%");
            }else if(cena_nr1_metr==cena_nr2_metr){
                wynik.setText("Obie pizze maja taka sama wartosc");
            }else{
                porownanie = ((cena_nr2_metr/cena_nr1_metr)-1)*100;
                wynik.setText("Pizza nr 1 jest tansza o "+porownanie+"%");
            }

        }




    }
});





    }
}

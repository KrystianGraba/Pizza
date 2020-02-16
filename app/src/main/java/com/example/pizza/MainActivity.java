package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.math.RoundingMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.round;
import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
        private static DecimalFormat df2 = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView iv = (ImageView) findViewById(R.id.submit);
        final EditText rozmiar_1 = findViewById(R.id.rozmiar_1);
        final EditText rozmiar_2 = findViewById(R.id.rozmiar_2);
        final EditText cena_1 = findViewById(R.id.cena_1);
        final EditText cena_2 = findViewById(R.id.cena_2);
        final TextView wynik = findViewById(R.id.wynik);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if (rozmiar_1.getText().toString().isEmpty() || rozmiar_2.getText().toString().isEmpty() || cena_1.getText().toString().isEmpty() || cena_2.getText().toString().isEmpty()) {
                    if (rozmiar_1.getText().toString().isEmpty()) {
                        rozmiar_1.setError("Wprowadz wartosc");
                    }
                    if (rozmiar_2.getText().toString().isEmpty()) {
                        rozmiar_2.setError("Wprowadz wartość");
                    }
                    if (cena_1.getText().toString().isEmpty()) {
                        cena_1.setError("Wprowadz wartość");
                    }
                    if (cena_2.getText().toString().isEmpty()) {
                        cena_2.setError("Wprowadz wartość");
                    }
                } else {
                    /* METRY */
                    double powierzchnia_1 = (((0.5 * (Double.parseDouble(rozmiar_1.getText().toString()))) * (0.5 * (Double.parseDouble(rozmiar_1.getText().toString())))) * 3.14) * 0.0001;
                    double powierzchnia_2 = (((0.5 * (Double.parseDouble(rozmiar_2.getText().toString()))) * (0.5 * (Double.parseDouble(rozmiar_2.getText().toString())))) * 3.14) * 0.0001;

                    Log.v("Powierzchnia 1: ", "=" + powierzchnia_1);
                    Log.v("Powierzchnia 2: ", "=" + powierzchnia_2);

                    double cena_nr1 = Double.parseDouble(cena_1.getText().toString());
                    double cena_nr2 = Double.parseDouble(cena_2.getText().toString());

                    double cena_nr1_metr = (1 / powierzchnia_1) * cena_nr1;
                    double cena_nr2_metr = (1 / powierzchnia_2) * cena_nr2;
                    double porownanie;
                    Log.v("Cena za metr 1: ", "=" + cena_nr1_metr);
                    Log.v("Cena za metr 2: ",  "=" + cena_nr2_metr);
                    DecimalFormat twoDForm = new DecimalFormat("#.##");

                   if (cena_nr1_metr > cena_nr2_metr) {
                        porownanie = ((cena_nr1_metr-cena_nr2_metr)*100)/cena_nr2_metr;
                        wynik.setText("Pizza nr 1 jest droższa o " + df2.format(porownanie)+ "% od pizzy nr 2");
                    } else if (cena_nr2_metr>cena_nr1_metr) {
                       porownanie = ((cena_nr2_metr-cena_nr1_metr)*100)/cena_nr1_metr;
                        wynik.setText("Pizza nr 1 jest  tańsza o " + df2.format(porownanie)+ "% od pitcy nr 2");
                   } else if (cena_nr1_metr == cena_nr2_metr) {
                       wynik.setText("Obie pizze maja taka sama wartosc");
                   }
                }

            }
        });

    }
}
package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ImageView iv = (ImageView)findViewById(R.id.submit);

iv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            Log.v("MyApp","test");
    }
});





    }
}

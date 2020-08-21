package com.example.pravda_lozh;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;



public class MainActivity extends AppCompatActivity {
String a = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void sendMessageBbt (View view) {
        String a = "1";
     Intent intent = new Intent(this, test.class);
    intent.putExtra("a", a);
    startActivity(intent);

    }
    public void sendMessageScr (View view) {
        String a = "2";
        Intent intent = new Intent(this, test.class);
        intent.putExtra("a", a);
        startActivity(intent);
    }
    public void sendMessageH (View view) {
        String a = "3";
        Intent intent = new Intent(this, test.class);
        intent.putExtra("a", a);
       startActivity(intent);
    }
    public void sendMessageFr (View view) {
        String a = "4";
       Intent intent = new Intent(this, test.class);
        intent.putExtra("a", a);
        startActivity(intent);
    }

}

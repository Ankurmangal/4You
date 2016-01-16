package com.example.kanikaaggarwal.magicbutton;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String buttonPress = ((Button) view).getText().toString();

        if (buttonPress.equalsIgnoreCase("next")) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
    }
}

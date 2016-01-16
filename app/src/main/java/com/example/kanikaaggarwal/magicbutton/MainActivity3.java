package com.example.kanikaaggarwal.magicbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ankur on 2015-11-28.
 */
public class MainActivity3 extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        Button btn1 = (Button) findViewById(R.id.button14);
        btn1.setOnClickListener(this);

    }

    public void onClick(View view) {

        String buttonPress = ((Button) view).getText().toString();

        if (buttonPress.equalsIgnoreCase("message")) {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            startActivity(intent);
        }

    }


}

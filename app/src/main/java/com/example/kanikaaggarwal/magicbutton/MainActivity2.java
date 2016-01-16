package com.example.kanikaaggarwal.magicbutton;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import android.provider.ContactsContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        Button btn1 = (Button) findViewById(R.id.button7);
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.button8);
        btn2.setOnClickListener(this);

        Button btn3 = (Button) findViewById(R.id.button9);
        btn3.setOnClickListener(this);

        Button btn4 = (Button) findViewById(R.id.button10);
        btn4.setOnClickListener(this);


        Button btn5 = (Button) findViewById(R.id.button13);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String buttonPress = ((Button) view).getText().toString();

        /*if (buttonPress.equalsIgnoreCase("contact1")) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            startActivityForResult(intent, 1)

            ;
        }

        if (buttonPress.equalsIgnoreCase("contact2")) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            startActivityForResult(intent, 1);

        }

        if (buttonPress.equalsIgnoreCase("contact3")) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            startActivityForResult(intent, 1);

        }

        if (buttonPress.equalsIgnoreCase("contact4")) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            startActivityForResult(intent, 1);

        }*/

        if (buttonPress.equalsIgnoreCase("Next")) {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        }

    }

    //not working as of now for every contact button the display is working just for contact button 1
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        EditText nameDisplay = (EditText) findViewById(R.id.editText8);
        //EditText nameDisplay1 = (EditText) findViewById(R.id.editText9);
        //EditText nameDisplay2 = (EditText) findViewById(R.id.editText10);
        //EditText nameDisplay3 = (EditText) findViewById(R.id.editText11);


        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();

                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));


                String[] names = new String[4];


                if (nameDisplay.getText().toString().matches("") == true) {
                    nameDisplay.setText(name);
                    names[0] = nameDisplay.getText().toString();
                }


                //Toast.makeText(this, "Contact 1 "+  name + " is saved now ", Toast.LENGTH_LONG).show();
            }
        }
    }

}

package com.example.davidtp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button inform = (Button)findViewById(R.id.button);
        inform.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView showText = (TextView) findViewById(R.id.textView2);
                EditText editName = (EditText) findViewById(R.id.editText);
                TimePicker timeP = (TimePicker) findViewById(R.id.tpPicker);

                String name = editName.getText().toString(); //gets you the contents of edit text
                String hour = timeP.getCurrentHour().toString();
                String minute = timeP.getCurrentMinute().toString();
                String content = name +  " - " + hour + "h" + minute; //combine text
                showText.setText(content); //set text for text view

                Intent intent = new Intent(MainActivity.this, secondActivity.class); //pass value from main to second
                String[] myStrings = new String[] {name, hour, minute};
                intent.putExtra("strings", myStrings);
                startActivity(intent); //to secondAct.
//                finish(); //end MainAct.
            }
        });

        Button quit = (Button)findViewById(R.id.button2);
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish(); //end MainAct.
            }
        });
    }


}

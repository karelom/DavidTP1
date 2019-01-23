package com.example.davidtp1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.concurrent.TimeUnit;

public class secondActivity extends AppCompatActivity{

    String myLog = "myLog";

    AlphaAnimation inAnimation;
    AlphaAnimation outAnimation;

    FrameLayout progressBarHolder;

    Button authenticate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //REMEMBER TO CHANGE!

        Intent intent = getIntent();
        String[] myStrings = intent.getStringArrayExtra("strings");
        String content = "User: " + myStrings[0]; //[1] for hour; [2] for minute

        TextView t1 = (TextView) findViewById(R.id.textView3);
        t1.setText(content);

        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);

        authenticate = (Button)findViewById(R.id.button4);
        authenticate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new MyTask().execute();
            }
        });

        Button back = (Button)findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(secondActivity.this, MainActivity.class); //pass value from second to main
//                startActivity(intent); //to MainAct.
                finish(); //end secondAct.
            }
        });
    }


    private class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            authenticate.setEnabled(false);
            inAnimation = new AlphaAnimation(0f, 1f);
            inAnimation.setDuration(200);
            progressBarHolder.setAnimation(inAnimation);
            progressBarHolder.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            outAnimation = new AlphaAnimation(1f, 0f);
            outAnimation.setDuration(200);
            progressBarHolder.setAnimation(outAnimation);
            progressBarHolder.setVisibility(View.GONE);
            authenticate.setEnabled(true);
        }


        @Override
        protected Void doInBackground(Void... params) {
            try {
                for (int i = 0; i < 5; i++) {
                    Log.d(myLog, "Emulating some task.. Step " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}

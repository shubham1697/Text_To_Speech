package com.sa.uchiha_itachi.text_to_speech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1;
    TextView tv1;
    TextToSpeech ttsobj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1 = findViewById(R.id.et1);
        b1 = findViewById(R.id.bt1);

        ttsobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    ttsobj.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = e1.getText().toString();
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT);
                ttsobj.speak(data, TextToSpeech.QUEUE_FLUSH,null);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ttsobj != null){
            ttsobj.stop();
            ttsobj.shutdown();
        }
    }

}

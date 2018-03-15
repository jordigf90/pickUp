package com.example.jordi.pickup_pattern;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_send = (Button) findViewById(R.id.btn_send);
        //Button btn_return = (Button)findViewById(R.id.btn_send);

        final CheckBox ch_patron_1 = (CheckBox) findViewById(R.id.ch_patron_1);
        final CheckBox ch_patron_2 = (CheckBox) findViewById(R.id.ch_patron_2);
        final CheckBox ch_patron_3 = (CheckBox) findViewById(R.id.ch_patron_3);

        //String body_mail = "";

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ch_patron_1_status = "";
                String ch_patron_2_status = "";
                String ch_patron_3_status = "";

                if (ch_patron_1.isChecked() == true){
                    ch_patron_1_status = "Patron_1";
                }else{
                    ch_patron_1_status = "";
                }


                if (ch_patron_2.isChecked() == true){
                    ch_patron_2_status = "Patron_2";
                }else{
                    ch_patron_2_status = "";
                }


                if (ch_patron_3.isChecked() == true){
                    ch_patron_3_status = "Patron_3";
                }else{
                    ch_patron_3_status = "";
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","email@email.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Patron List");
                intent.putExtra(Intent.EXTRA_TEXT, ch_patron_1_status+" "+ch_patron_2_status+" "+ch_patron_3_status);
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

                Log.d("message",ch_patron_1_status+" "+ch_patron_2_status+" "+ch_patron_3_status);

            }
        });






    }
}

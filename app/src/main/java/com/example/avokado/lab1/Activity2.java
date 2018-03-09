package com.example.avokado.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
sources:
startActivityForResult: https://stackoverflow.com/a/10407371
*/

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String T1text = "Hello ";
        Intent A1intent = getIntent();
        T1text = T1text + A1intent.getStringExtra("T1string");
        TextView T2view = findViewById(R.id.T2);
        T2view.setText(T1text);

        String A3String = "From A3: ";
        TextView T3view = findViewById(R.id.T3);
        T3view.setText(A3String);
        findViewById(R.id.B2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Activity2.this, Activity3.class), 1);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity3.RESULT_OK){
                String str = "From A3: ";
                str = str + (data.getStringExtra("result"));
                TextView t = findViewById(R.id.T3);
                t.setText(str);
            }
            else if (resultCode == Activity3.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

}

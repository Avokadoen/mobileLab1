package com.example.avokado.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private EditText T4watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        T4watcher = (EditText) findViewById(R.id.T4);
        T4watcher.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH ||
                        i == EditorInfo.IME_ACTION_DONE ||
                        keyEvent != null &&
                                keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                                keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (keyEvent == null || !keyEvent.isShiftPressed()) {
                        // the user is done typing.
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result", T4watcher.getText().toString());
                        setResult(Activity3.RESULT_OK, returnIntent);
                        finish();
                        return true; // consume.
                    }
                }
                return false;
            }
        });
        findViewById(R.id.B3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}


/*
  T4watcher.addTextChangedListener(new TextWatcher() {

                            public void afterTextChanged(Editable s) {
                                // you can call or do what you want with your T4watcher here
                                Intent returnIntent = new Intent();
                                returnIntent.putExtra("result", s.toString());
                                setResult(Activity3.RESULT_OK, returnIntent);
                                finish();
                            }

                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                            public void onTextChanged(CharSequence s, int start, int before, int count) {}
                        });
 */
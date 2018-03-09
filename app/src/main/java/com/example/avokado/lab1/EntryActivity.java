package com.example.avokado.lab1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.TextView;

/* specifications:
- editable text field (T1)
- slider (S1)
- a drop-down list of options (L1)
- a button (B1)


Source:
- activity and state: https://developer.android.com/guide/components/activities/activity-lifecycle.html
*/

public class EntryActivity extends AppCompatActivity {
    private int spinnerPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int defaultValue = 0;
        spinnerPos = sharedPref.getInt("spinnerPos", defaultValue);

        AdapterView spinner = findViewById(R.id.L1);
        spinner.setSelection(spinnerPos);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                spinnerPos = pos;
                Log.d("spinnerPos", "realtime kek " + spinnerPos);
            }

            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        findViewById(R.id.B1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView username = findViewById(R.id.T1);
                Intent i = new Intent(EntryActivity.this, Activity2.class);
                i.putExtra("T1string", username.getText().toString());
                startActivity(i);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("spinnerPos", spinnerPos);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        AdapterView spinner = findViewById(R.id.L1);
        spinnerPos = savedInstanceState.getInt("spinnerPos");
    }

    @Override
    public void onPause(){
        Log.d("spinnerPos", "saved kek " + spinnerPos);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("spinnerPos", spinnerPos);
        editor.apply();
        super.onPause();
    }

    @Override
    public void onStop(){
        Log.d("spinnerPos", "saved kek " + spinnerPos);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("spinnerPos", spinnerPos);
        editor.apply();
        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.d("spinnerPos", "saved kek " + spinnerPos);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("spinnerPos", spinnerPos);
        editor.apply();
        super.onDestroy();
    }
}



































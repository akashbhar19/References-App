package com.example.akash.references;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String options, format;
    ArrayAdapter<CharSequence> adapter, adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner selectOption = (Spinner) findViewById(R.id.optionSpinner);
        Spinner selectFormat = (Spinner) findViewById(R.id.formatSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.Format, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectOption.setAdapter(adapter);
        selectFormat.setAdapter(adapter2);
        selectOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                options = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selectFormat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                format = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void loadAnnotation(View view) {
        //Ifs for choosing which Activity to load
        Intent startNewActivity;
        if(options.equals("Website")){
            startNewActivity = new Intent(this, websiteActivity.class);
        }
        else{
            startNewActivity = new Intent(this, Type.class);
        }
        startNewActivity.putExtra("Format", format);
        startNewActivity.putExtra("Option", options);
        //Once Intent is determined, load activity
        startActivity(startNewActivity);

    }

}

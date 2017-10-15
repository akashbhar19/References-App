package com.example.akash.references;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Type extends AppCompatActivity {
    String option, format, type;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        Bundle bundle = getIntent().getExtras();
        format = bundle.getString("Format");
        option = bundle.getString("Option");
        setTitle(option +" - " + format);
        TextView typeHeader = (TextView) findViewById(R.id.typeHeader);
        Spinner bookType = (Spinner) findViewById(R.id.typeSpinner);
        if(option.equals("Book")){
            typeHeader.setText("Book Type");
            adapter = ArrayAdapter.createFromResource(this, R.array.BookType, android.R.layout.simple_spinner_item);
        }
        else if(option.equals("Journal")){
            typeHeader.setText("Journal Type");
            adapter = ArrayAdapter.createFromResource(this, R.array.JournalType, android.R.layout.simple_spinner_item);
        }
        else{
            typeHeader.setText("Video Type");
            adapter = ArrayAdapter.createFromResource(this, R.array.VideoType, android.R.layout.simple_spinner_item);

        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bookType.setAdapter(adapter);
        bookType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                type = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void loadAnnotation(View view) {
        //Ifs for choosing which Activity to load
        Intent startNewActivity;
        if(option.equals("Book")){
            startNewActivity = new Intent(this, bookActivity.class);
        }
        else if(option.equals("Journal")){
            startNewActivity = new Intent(this, journalActivity.class);
        }
        else{
            startNewActivity = new Intent(this, videoActivity.class);
        }
        startNewActivity.putExtra("Format", format);
        startNewActivity.putExtra("Type", type);
        //Once Intent is determined, load activity
        startActivity(startNewActivity);

    }
}

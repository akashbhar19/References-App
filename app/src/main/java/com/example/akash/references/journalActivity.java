package com.example.akash.references;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class journalActivity extends AppCompatActivity {
    String format, type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        format = bundle.getString("Format");
        type = bundle.getString("Type");
        setTitle("Journal - " + format + " - " + type);
        if(type.equals("Print")){
            setContentView(R.layout.activity_journal_print);
        }
        else if(type.equals("Online")){
            setContentView(R.layout.activity_journal_online);
        }
        else{
            setContentView(R.layout.activity_journal_database);
        }
    }
}

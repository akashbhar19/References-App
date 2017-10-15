package com.example.akash.references;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.ClipboardManager;
import com.example.akash.references.Website;
import android.content.Intent;

public class websiteActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter, adapterPM, adapterPD, adapterAM, adapterAD;
    String format, strContributor;
    String sFirstName, sMiddleI, sLastName, sArticleTitle, sWebsiteTitle, sPublisher, sURL, sPubMonth, sPubDay, sPubYear, sAccMonth, sAccDay, sAccYear, sAnnotation;
    EditText firstName, middleI, lastName, articleTitle, websiteTitle, publisher, URL, pubYear, accYear, annotation;
    Spinner contributor, pubMonth, pubDay, accMonth, accDay;
    int pYear, aYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Website");
        Bundle bundle = getIntent().getExtras();
        format = bundle.getString("Format");
        setTitle("Website - " + format);
        setContentView(R.layout.activity_website);
        firstName = (EditText) findViewById(R.id.etFirstName);
        middleI = (EditText) findViewById(R.id.etMiddleInitial);
        contributor = (Spinner) findViewById(R.id.contributorSpinner);
        lastName = (EditText) findViewById(R.id.etLastName);
        articleTitle = (EditText) findViewById(R.id.etArticleTitle);
        websiteTitle = (EditText) findViewById(R.id.etWebsiteTitle);
        publisher = (EditText) findViewById(R.id.etPublisher);
        URL = (EditText) findViewById(R.id.etURL);
        pubMonth = (Spinner) findViewById(R.id.spinnerPubMonth);
        pubDay = (Spinner) findViewById(R.id.spinnerPubDay);
        pubYear = (EditText) findViewById(R.id.etPubYear);
        accMonth = (Spinner) findViewById(R.id.spinnerAccMonth);
        accDay = (Spinner) findViewById(R.id.spinnerAccDay);
        accYear = (EditText) findViewById(R.id.etAccYear);
        annotation = (EditText) findViewById(R.id.etAnnotation);
        Button generate = (Button) findViewById(R.id.bGenerate);
        adapter = ArrayAdapter.createFromResource(this, R.array.WebsiteContributors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contributor.setAdapter(adapter);
        contributor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                strContributor = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapterPM = ArrayAdapter.createFromResource(this, R.array.Month, android.R.layout.simple_spinner_item);
        adapterPM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pubMonth.setAdapter(adapterPM);
        pubMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                sPubMonth = (String) adapterView.getItemAtPosition(i);
                if(sPubMonth.equals("Feb")){
                    adapterPD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days29, android.R.layout.simple_spinner_item);
                    adapterPD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    pubDay.setAdapter(adapterPD);
                }
                else if(sPubMonth.equals("Jan") || sPubMonth.equals("Mar") || sPubMonth.equals("May") || sPubMonth.equals("Jul") || sPubMonth.equals("Aug") || sPubMonth.equals("Oct") || sPubMonth.equals("Dec")){
                    adapterPD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days31, android.R.layout.simple_spinner_item);
                    adapterPD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    pubDay.setAdapter(adapterPD);
                }
                else{
                    adapterPD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days30, android.R.layout.simple_spinner_item);
                    adapterPD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    pubDay.setAdapter(adapterPD);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapterAM = ArrayAdapter.createFromResource(this, R.array.Month, android.R.layout.simple_spinner_item);
        adapterAM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accMonth.setAdapter(adapterAM);
        accMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                sAccMonth = (String) adapterView.getItemAtPosition(i);
                if(sAccMonth.equals("Feb")){
                    adapterAD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days29, android.R.layout.simple_spinner_item);
                    adapterAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    accDay.setAdapter(adapterPD);
                }
                else if(sAccMonth.equals("Jan") || sAccMonth.equals("Mar") || sAccMonth.equals("May") || sAccMonth.equals("Jul") || sAccMonth.equals("Aug") || sAccMonth.equals("Oct") || sAccMonth.equals("Dec")){
                    adapterAD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days31, android.R.layout.simple_spinner_item);
                    adapterAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    accDay.setAdapter(adapterPD);
                }
                else{
                    adapterAD = ArrayAdapter.createFromResource(websiteActivity.this, R.array.Days30, android.R.layout.simple_spinner_item);
                    adapterAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    accDay.setAdapter(adapterPD);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        pubDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                sPubDay = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        accDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
                sAccDay = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}

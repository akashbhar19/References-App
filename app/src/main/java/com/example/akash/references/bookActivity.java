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

public class bookActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;
    String format, type, strContributor;
    String sFirstName, sMiddleI, sLastName, sTitle, sVolume, sEdition, sSeries, sPublisher, sCity, sState, sYear, sAnnotation, sWebTitle;
    EditText firstName, middleI, lastName, title, volume, edition, series, publisher, city, state, year, annotation, webTitle, version, url;
    int ed, nYear;
    Spinner contributor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        format = bundle.getString("Format");
        type = bundle.getString("Type");
        setTitle("Book - " + format + " - " + type);
        if(type.equals("Print")){
            setContentView(R.layout.activity_book_print);
        }
        else if(type.equals("E-Book")){
            setContentView(R.layout.activity_book_online);
            webTitle = (EditText) findViewById(R.id.etWebsiteTitle);
            version = (EditText) findViewById(R.id.etVersion);
            url = (EditText) findViewById(R.id.etURL);
        }
        else{
            setContentView(R.layout.activity_book_database);
        }
        firstName = (EditText) findViewById(R.id.etFirstName);
        middleI = (EditText) findViewById(R.id.etMiddleInitial);
        lastName = (EditText) findViewById(R.id.etLastName);
        contributor = (Spinner) findViewById(R.id.contributorSpinner);
        title = (EditText) findViewById(R.id.etTitle);
        volume = (EditText) findViewById(R.id.etVolume);
        edition = (EditText) findViewById(R.id.etEdition);
        series = (EditText) findViewById(R.id.etSeries2);
        publisher = (EditText) findViewById(R.id.etPublisher);
        city = (EditText) findViewById(R.id.etCity);
        state = (EditText) findViewById(R.id.etState);
        year = (EditText) findViewById(R.id.etYear);


        annotation = (EditText) findViewById(R.id.etAnnotation);
        Button generate = (Button) findViewById(R.id.bGenerate);
        adapter = ArrayAdapter.createFromResource(this, R.array.BookContributors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contributor.setAdapter(adapter);
        contributor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_LONG).show();
                strContributor = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sFirstName = firstName.getText().toString();
                sMiddleI = middleI.getText().toString();
                sLastName = lastName.getText().toString();
                strContributor = contributor.toString();
                sTitle = title.getText().toString();
                sVolume = volume.getText().toString();
                sEdition = edition.getText().toString();
                if(sEdition.matches(".*[a-zA-Z].*") || sEdition.isEmpty()){
                    ed = 0;
                }
                else{
                    ed = (int)Integer.parseInt(sEdition);
                }
                sPublisher = publisher.getText().toString();
                sSeries = series.getText().toString();
                sCity = city.getText().toString();
                sState = state.getText().toString();
                sYear = year.getText().toString();
                if(sYear.isEmpty()){
                    nYear = 0;
                }
                else{
                    nYear = (int)Integer.parseInt(sYear);
                }
                sAnnotation = annotation.getText().toString();
                Book book = new Book(sFirstName, sMiddleI, sLastName, strContributor, sTitle, sVolume, ed, sSeries, sPublisher, sCity, sState, nYear, sAnnotation, format);
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(bookActivity.this);
                View mView = LayoutInflater.from(bookActivity.this).inflate(R.layout.dialog_generate, null);
                TextView citation = (TextView) mView.findViewById(R.id.tvCitation);
                citation.setText(book.citation);
                Button bSave = (Button) mView.findViewById(R.id.bSave);
                Button bCopy = (Button) mView.findViewById(R.id.bCopy);
                Button bSaveAndCopy = (Button) mView.findViewById(R.id.bSaveAndCopy);
                Button bCancel = (Button) mView.findViewById(R.id.bCancel);

                /*bSave.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void OnClick(View view){
                        dismiss();
                    }
                });*/
                mBuilder.setView(mView);
                mBuilder.show();
            }
        });


    }
}

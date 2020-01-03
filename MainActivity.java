package com.example.fireinsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, contact;
    Button send;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String string[] = {"Cooking", "Playing", "Dancing", "Reading", "Writing"};
    String string1[] = {"Pune", "Karad", "Sangli", "Kolhapur", "Satara", "Dhanori", "Airport", "Pimpri"};
    String string2[] = {"Neha", "Ashwini", "Nisha", "Prachi", "Manisha", "Sarika", "Mayuri", "Anand"};
    ArrayAdapter arrayAdapter, arrayAdapter2, arrayAdapter3;
    DatabaseReference databaseReference;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        send = findViewById(R.id.send);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.auto);
        multiAutoCompleteTextView = findViewById(R.id.multi);
        progressBar = findViewById(R.id.progress);


        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, string);
        spinner.setAdapter(arrayAdapter);

        arrayAdapter2 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, string1);
        autoCompleteTextView.setAdapter(arrayAdapter2);
        autoCompleteTextView.setThreshold(1);

        arrayAdapter3 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, string2);
        multiAutoCompleteTextView.setAdapter(arrayAdapter3);
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child("Student");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String NAME = name.getText().toString();
                String EMAIL = email.getText().toString();
                String CONTACT = contact.getText().toString();
                String SPINNER = spinner.getSelectedItem().toString();
                String AUTO = autoCompleteTextView.getText().toString();
                String MULTI = multiAutoCompleteTextView.getText().toString();

                progressBar.setVisibility(View.VISIBLE);


                String id = databaseReference.push().getKey();
                Item item = new Item(id, NAME, EMAIL, CONTACT, SPINNER, AUTO, MULTI);

                databaseReference.child(id).setValue(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Data Insert", Toast.LENGTH_LONG).show();

                            progressBar.setVisibility(View.INVISIBLE);

                        }

                    }
                });


            }
        });


    }

    public void openViewDataActivity(View view) {
        startActivity(new Intent(this, ViewDataActivity.class));
    }
}






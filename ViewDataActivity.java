package com.example.fireinsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child("Student");
        listView = findViewById(R.id.list1);
        list = new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    Item item = snap.getValue(Item.class);
                    list.add(item);
                }

                AdapterCls adapterCls = new AdapterCls(ViewDataActivity.this, list);
                listView.setAdapter(adapterCls);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

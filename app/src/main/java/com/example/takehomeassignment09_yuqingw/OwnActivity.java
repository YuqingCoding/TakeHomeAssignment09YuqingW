package com.example.takehomeassignment09_yuqingw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OwnActivity extends AppCompatActivity {

    private TextView displayText;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference personRef = database.getReference("person");
    private DatabaseReference myRef = database.getReference("another person");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own);

        Intent intent = getIntent();
        displayText = (TextView) findViewById(R.id.display_text);

        personRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Person p = dataSnapshot.getValue(Person.class);
                displayText.setText(p.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(OwnActivity.this,"Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setPerson(View view){
        personRef.setValue(new Person("Superman","male",100,true));
    }

    public void addPerson(View view){
        myRef.push().setValue(new Person("Donald Duck","male",99,true));
    }
}

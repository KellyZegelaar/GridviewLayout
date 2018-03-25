package com.example.kelly.gridviewlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ItemClick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click);

        Bundle extras = getIntent().getExtras();

        TextView textView = findViewById(R.id.textView);

        Person p = (Person) extras.getSerializable("PERSON");

        textView.setText(p.getName());
    }


    // adds the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.available_activities, menu);
        return true;
    }

    //some more comments
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.mnuAccount:
                Intent i = new Intent(getApplicationContext(), Person_Overview.class);
                startActivity(i);
                break;
            case R.id.mnuFilms:
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i2);
                break;
            case R.id.mnuContact:
                Intent i3 = new Intent(getApplicationContext(), BioscoopFinder.class);
                startActivity(i3);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

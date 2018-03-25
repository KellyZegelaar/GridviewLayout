package com.example.kelly.gridviewlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<>();
        persons.add(new Person("Kees"));
        persons.add(new Person("Piet"));
        persons.add(new Person("Annabel"));
        persons.add(new Person("Sanne"));
        persons.add(new Person("Petra"));
        persons.add(new Person("Jan"));
        persons.add(new Person("Bas"));
        persons.add(new Person("Nicolette"));


        GridView gridView = findViewById(R.id.Personlist);
        personAdapter adapter = new personAdapter(this,getLayoutInflater(),persons);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

        adapter.notifyDataSetChanged();

        Spinner spinner = findViewById(R.id.spnrGenre);
        ArrayAdapter<CharSequence> spnrAdapter = ArrayAdapter.createFromResource(this, R.array.genres, android.R.layout.simple_spinner_dropdown_item);
        spnrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spnrAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Person p = persons.get(position);
        Intent i = new Intent(getApplicationContext(), ItemClick.class);
        i.putExtra("PERSON", p);

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.available_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.mnuAccount:
                Intent i = new Intent(getApplicationContext(), Person_Overview.class);
                startActivity(i);
                break;
            case R.id.mnuFilms:
                break;
            case R.id.mnuContact:
                Intent i2 = new Intent(getApplicationContext(), BioscoopFinder.class);
                startActivity(i2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

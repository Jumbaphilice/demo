package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demo.adapters.NotesAdapter;
import com.example.demo.database.DatabaseHelper;
import com.example.demo.database.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvhello;
    Button btnViewNote;
    ListView listNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AddNoteActivity.class));
                // startActivity(new Intent(getBaseContext(),TrialActivity.class));

            }
        });


        listNames= findViewById(R.id.listNames);
        displayNotes();
//        displayNames();
    }


        private void displayNotes() {
            DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
            List<Note> noteList = new ArrayList<Note>();
            noteList = databaseHelper.getNotes();
            Log.d("notes", "my noteList has" + noteList.size() + "notes");
            NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(),0,noteList);
            listNames.setAdapter(notesAdapter);
        }

        private void  displayNames(){
            List<String>namesList=new ArrayList<String>();
            namesList.add("Mercy Muhonja");
            namesList.add("Bilha ,Wanjiku");
            namesList.add("Tina,Nanzala");
            namesList.add("Grace,Nyokabi");
            namesList.add("Charity,Gaya");
            namesList.add("Pauline,Malova");
            namesList.add("Edith ,Aleyo");
            namesList.add("Brian ,Ariyo");
            namesList.add("Vincent ,Mmene");
            namesList.add("Prince ,Matuku");

            ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,namesList);
            listNames.setAdapter(arrayAdapter);


            }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.architecturetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =  "com.example.architecturetutorial.EXTRA_TITLE";
    public static final String EXTRA_DESCRITPION =  "com.example.architecturetutorial.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY=  "com.example.architecturetutorial.EXTRA_PRIORITY";
    private EditText noteTitle;
    private EditText noteDescritpion;
    private NumberPicker priorityPicker;
    private FloatingActionButton fbtn_save_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_cancel);
        setTitle("Add Note");

        initializeWidgets();

    }
    public void initializeWidgets(){

        noteTitle = findViewById(R.id.note_title);
        noteDescritpion = findViewById(R.id.note_description);
        priorityPicker = findViewById(R.id.priority_picker);

        fbtn_save_note = findViewById(R.id.fbtn_add_note);
        fbtn_save_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save_note();
            }
        });
        priorityPicker.setMaxValue(10);
        priorityPicker.setMinValue(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater add_note_menu_inflater = getMenuInflater();
        add_note_menu_inflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_item_cancel:
                //cancelEntry();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void save_note(){
        String note_title;
        String note_description;
        int note_priority_value;

        note_title = noteTitle.getText().toString();
        note_description = noteDescritpion.getText().toString();
        note_priority_value = priorityPicker.getValue();

        Intent data = new Intent();

        data.putExtra(, note_title);

    }
}

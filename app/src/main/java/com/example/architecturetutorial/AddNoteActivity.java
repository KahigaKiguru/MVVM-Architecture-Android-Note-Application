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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =  "com.example.architecturetutorial.EXTRA_TITLE";
    public static final String EXTRA_DESCRITPION =  "com.example.architecturetutorial.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY=  "com.example.architecturetutorial.EXTRA_PRIORITY";


    private EditText noteTitle;
    private EditText noteDescription;
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
        noteDescription = findViewById(R.id.note_description);
        priorityPicker = findViewById(R.id.priority_picker);

        fbtn_save_note = findViewById(R.id.f_btn_save_note);
        fbtn_save_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });
        priorityPicker.setMaxValue(10);
        priorityPicker.setMinValue(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater add_note_menu_inflater = getMenuInflater();
        add_note_menu_inflater.inflate(R.menu.cancel_note_menu, menu);
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

    private void saveEntry(){
        String note_title;
        String note_description;
        int note_priority_value;

        note_title = noteTitle.getText().toString();
        note_description = noteDescription.getText().toString();
        note_priority_value = priorityPicker.getValue();

        if (note_title.trim().isEmpty() || note_description.trim().isEmpty()){

            Toast.makeText(this, "Please Enter a Title and Description ", Toast.LENGTH_SHORT).show();
            return;
        }
        
        Intent data = new Intent();

        data.putExtra(EXTRA_TITLE, note_title);
        data.putExtra(EXTRA_DESCRITPION, note_description);
        data.putExtra(EXTRA_PRIORITY, note_priority_value);

        setResult(RESULT_OK, data);

        Toast.makeText(this, "Note Saved ! ", Toast.LENGTH_SHORT).show();
        finish();

    }
}

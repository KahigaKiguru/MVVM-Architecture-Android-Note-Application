package com.example.architecturetutorial;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int note_id;

    private int priority;
    private String note_title;
    private String note_description;

    //Constructor

    public Note(String note_title, String note_description, int priority) {
        this.note_title = note_title;
        this.note_description = note_description;
        this.priority = priority;
    }

    //Setter

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    //Getters
    public String getNote_title() {
        return note_title;
    }

    public String getNote_description() {
        return note_description;
    }

    public int getNote_id() {
        return note_id;
    }

    public int getPriority() {
        return priority;
    }
}

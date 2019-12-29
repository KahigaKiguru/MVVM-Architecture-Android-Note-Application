package com.example.architecturetutorial;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDAO noteDAO();

    public static synchronized NoteDatabase getInstance(Context context){

        if (instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class, "Note Database")
            .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new populateDBAsyncTask(instance).execute();
        }
    };

    private static class populateDBAsyncTask extends AsyncTask<Void,Void,Void>{
       private NoteDAO noteDAO;

        private populateDBAsyncTask(NoteDatabase noteDB){
            this.noteDAO = noteDB.noteDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.insertNote(new Note("Title 1","title 1", 2));
            noteDAO.insertNote(new Note("Title 2", "second note ", 10));
            noteDAO.insertNote(new Note("Title 34 ", "What is on your mind?",9));
            return null;
        }
    }
}

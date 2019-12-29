package com.example.architecturetutorial;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDAO = database.noteDAO();
        allNotes = database.noteDAO().getAllNotes();
    }

    public void insert(Note note){
        new insertNoteAsyncTask(noteDAO).execute(note);
    }
    public void update(Note note){
        new updateNoteAsyncTask(noteDAO).execute(note);
    }
    public void delete(Note note){
        new deleteNoteAsyncTask(noteDAO).execute(note);
    }
    public void deleteAllNotes(){
        new deleteAllNotesAsyncTask(noteDAO).execute();
    }
    public LiveData<List<Note>> getAllNotes(){return allNotes;}

    private static class insertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDAO noteDAO;

        private insertNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insertNote(notes[0]);
            return null;
        }
    }

    private static class updateNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        private updateNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.updateNote(notes[0]);
            return null;
        }
    }

    public static class deleteNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        private deleteNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.deleteNote(notes[0]);
            return null;
        }
    }

    private static class deleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDAO noteDAO;

        private deleteAllNotesAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAllNotes();
            return null;
        }
    }
}
package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private List<Note> noteList = new ArrayList<>();
    private Long nextId = 1L;

    public List<Note> getAllNotes() {
        return noteList;
    }

    public Note getNoteById(Long id) {
        for (Note note : noteList) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

    public void saveNote(Note note) {
        note.setId(nextId++);
        noteList.add(note);
    }

    public void updateNote(Long id, String text) {
        for (Note note : noteList) {
            if (note.getId().equals(id)) {
                note.setText(text);
                return;
            }
        }
    }

    public void deleteNoteById(Long id) {
        noteList.removeIf(note -> note.getId().equals(id));
    }
}




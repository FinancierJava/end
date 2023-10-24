package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> listNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public void createNote(@RequestBody Note note) {
        noteService.saveNote(note);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody String text) {
        noteService.updateNote(id, text);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }
}

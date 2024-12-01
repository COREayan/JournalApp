package net.edigest.journal.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.edigest.journal.entity.Journal;
import net.edigest.journal.service.JournalService;



@RestController
@RequestMapping("/journal/v2/")
public class JournalControllerV2 {
    
    private final JournalService journalService;

    @Autowired
    public JournalControllerV2(JournalService newJournalService) {
        this.journalService = newJournalService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllJournal() {
        List<Journal> all = journalService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @PostMapping()
    public ResponseEntity<Journal> createJournal(@RequestBody Journal newJournal) {
        try {
            journalService.createJournal(newJournal);
            return new ResponseEntity<>(newJournal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<Journal> getJournalById(@PathVariable ObjectId myId) {
        Optional<Journal> journal = journalService.getJournalById(myId);
        if (journal.isPresent()) {
            return new ResponseEntity<>(journal.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<Journal> updateJournalById(@PathVariable ObjectId myId, @RequestBody Journal newEntry) {
        Journal old = journalService.getJournalById(myId).orElse(null);
        if (old != null) {
            old.setName(newEntry.getName() != null && !newEntry.getName().isEmpty() ? newEntry.getName() : old.getName());
            old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().isEmpty() ? newEntry.getDescription() : old.getDescription());
            journalService.updateJournal(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId) {
        journalService.deleteJournal(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

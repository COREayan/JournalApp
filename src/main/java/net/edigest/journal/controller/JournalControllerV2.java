package net.edigest.journal.controller;

import java.util.*;

import net.edigest.journal.entity.User;
import net.edigest.journal.service.UserService;
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

    @Autowired
    public JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<Journal> all = user.getJournalList(); //journalService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @PostMapping("{userName}")
    public ResponseEntity<Journal> createJournal(@RequestBody Journal newJournal, @PathVariable String userName) {
        try {
            journalService.saveJournal(newJournal, userName);
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

    @DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId, @PathVariable String userName) {
        journalService.deleteJournal(myId, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

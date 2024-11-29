package net.edigest.journal.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Journal> getAllJournal() {
        return journalService.getAll();
    }
    

    @PostMapping()
    public Journal createJournal(@RequestBody Journal newJournal) {
        journalService.createJournal(newJournal);
        return newJournal;
    }

    @GetMapping("id/{myId}")
    public Journal getJournalById(@PathVariable ObjectId myId) {
        return journalService.getJournalById(myId).orElse(null);
    }

    @PutMapping("id/{myId}")
    public Journal updateJournalById(@PathVariable ObjectId myId, @RequestBody Journal newEntry) {
        Journal old = journalService.getJournalById(myId).orElse(null);
        if (old != null) {
            old.setName(newEntry.getName() != null && !newEntry.getName().isEmpty() ? newEntry.getName() : old.getName());
            old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().isEmpty() ? newEntry.getDescription() : old.getDescription());
        }
        journalService.updateJournal(old);
        return old;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId) {
        journalService.getJournalById(myId);
        return true;
    }
}

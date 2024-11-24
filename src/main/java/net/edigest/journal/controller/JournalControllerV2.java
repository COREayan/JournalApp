package net.edigest.journal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.edigest.journal.entity.Journal;
import net.edigest.journal.service.JournalService;



@RestController
@RequestMapping("/journal/v2/")
public class JournalControllerV2 {
    
    private final JournalService journalService;

    public JournalControllerV2(JournalService newJournalService) {
        this.journalService = newJournalService;
    }

    @GetMapping()
    public List<Journal> getAllJournal() {
        return journalService.getAll();
    }
    

    @PostMapping()
    public void createJournal(@RequestBody Journal newJournal) {
        journalService.createJournal(newJournal);
    }
}

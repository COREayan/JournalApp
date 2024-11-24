package net.edigest.journal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.edigest.journal.entity.Journal;
import net.edigest.journal.repository.JournalRepository;

@Service
public class JournalService {
    
    private final JournalRepository journalRepository;

    public JournalService(JournalRepository newJournalRepository) {
        this.journalRepository = newJournalRepository;
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Journal getJournalById(Long myId) {
        return journalRepository.findById(myId).get();
    }

    public void createJournal(Journal newJournal) {
        journalRepository.insert(newJournal);
    }
}

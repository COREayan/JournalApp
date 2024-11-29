package net.edigest.journal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edigest.journal.entity.Journal;
import net.edigest.journal.repository.JournalRepository;

@Service
public class JournalService {
    
    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository newJournalRepository) {
        this.journalRepository = newJournalRepository;
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId myId) {
        return journalRepository.findById(myId);
    }

    public void createJournal(Journal newJournal) {
        newJournal.setCreateDate(LocalDate.now());
        journalRepository.insert(newJournal);
    }

    public void deleteJournal(ObjectId id) {
        journalRepository.deleteById(id);
    }

    public Journal updateJournal(Journal updatedJournal) {
        updatedJournal.setCreateDate(LocalDate.now());
        journalRepository.save(updatedJournal);
        return updatedJournal;
    }

}

package net.edigest.journal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import net.edigest.journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edigest.journal.entity.Journal;
import net.edigest.journal.repository.JournalRepository;

@Service
public class JournalService {

    @Autowired
    public JournalRepository journalRepository;

    @Autowired
    public UserService userService;

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId myId) {
        return journalRepository.findById(myId);
    }

    public void saveJournal(Journal newJournal, String userName) {
        User user = userService.findByUserName(userName);
        newJournal.setCreateDate(LocalDate.now());
        Journal saved = journalRepository.save(newJournal);
        user.getJournalList().add(saved);
        userService.updateUser(user);
    }

    public void deleteJournal(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalList().removeIf(x -> x.getId().equals(id));
        userService.updateUser(user);
        journalRepository.deleteById(id);
    }

    public Journal updateJournal(Journal updatedJournal) {
        updatedJournal.setCreateDate(LocalDate.now());
        journalRepository.save(updatedJournal);
        return updatedJournal;
    }

}

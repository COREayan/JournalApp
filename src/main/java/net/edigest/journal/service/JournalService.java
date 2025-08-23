package net.edigest.journal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.edigest.journal.entity.Journal;
import net.edigest.journal.entity.User;
import net.edigest.journal.repository.JournalRepository;

@Service
public class JournalService {


    private final JournalRepository journalRepository;

    private final UserService userService;

    public JournalService(JournalRepository journalRepository, UserService userService) {
        this.journalRepository = journalRepository;
        this.userService = userService;
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId myId) {
        return journalRepository.findById(myId);
    }

    @Transactional
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

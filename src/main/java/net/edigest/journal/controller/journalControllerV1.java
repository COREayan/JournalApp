// package net.edigest.journal.controller;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import net.edigest.journal.entity.Journal;



// @RestController
// @RequestMapping("journal/v1/")
// public class journalControllerV1 {
    
//     private HashMap<String, Journal> journalMap = new HashMap<>();

//     @GetMapping
//     public List<Journal> getAllJournal() {
//         return new ArrayList<>(journalMap.values());
//     }

//     @GetMapping("/{id}")
//     public Journal getJounralById(@PathVariable String id) {
//         return journalMap.get(id);
//     }
    
//     @PostMapping
//     public void createJournal(@RequestBody Journal newJournal) {
//         newJournal.setCreateDate(LocalDate.now());
//         journalMap.put(journalMap.size()+"", newJournal);
//     }
    
// }

package net.edigest.journal.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("journal_entry")
@Data
public class Journal {
    
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    private String description;
    private LocalDate createDate;
}

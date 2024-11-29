package net.edigest.journal.entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("journal_entry")
public class Journal {
    
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private LocalDate createDate;

    public Journal() {
    }

    public Journal(ObjectId id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Journal{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
}

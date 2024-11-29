package net.edigest.journal.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.edigest.journal.entity.Journal;
 
@Repository
public interface JournalRepository extends MongoRepository<Journal, ObjectId>{
    
}

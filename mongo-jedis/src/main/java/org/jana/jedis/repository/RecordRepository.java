package org.jana.jedis.repository;

import org.jana.jedis.document.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, String> {
}

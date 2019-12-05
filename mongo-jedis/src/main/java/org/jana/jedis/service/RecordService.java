package org.jana.jedis.service;

import org.jana.jedis.document.Record;
import org.jana.jedis.repository.RecordRepository;
import org.jana.jedis.request.SaveRecordRequest;
import org.jana.jedis.request.UpdateRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RecordService {

    private static final Logger log = Logger.getLogger(RecordService.class.getName());

    @Autowired
    private RecordRepository recordRepository;

    @Cacheable(value = "records", unless = "#result == null")
    public List<Record> getAll() {
        log.info("Get all records");
        return recordRepository.findAll();
    }

    @CachePut(value = "records", key = "#courseId")
    public Record getById(String courseId) {
        log.info("Get record by by id");
        Optional<Record> recordOptional = recordRepository.findById(courseId);
        return recordOptional.get();
    }

    @CacheEvict(allEntries = true, value = "records")
    public Record save(SaveRecordRequest request) {
        log.info("Save record");
        Record record = new Record();
        record.setRecordId(request.getId());
        record.setCode(request.getCode());
        record.setValue(request.getValue());
        return recordRepository.save(record);
    }

    @CacheEvict(allEntries = true, value = "records")
    public Record update(String recordId, UpdateRecordRequest request) {
        log.info("Update record");
        Optional<Record> optionalRecord = recordRepository.findById(recordId);
        Record record = optionalRecord.get();
        record.setCode(request.getCode());
        record.setValue(request.getValue());
        return  recordRepository.save(record);
    }

    @CacheEvict(allEntries = true, value = "records")
    public String clearCache() {
        log.info("Clear jedis");
        return "Cache cleared";
    }

}

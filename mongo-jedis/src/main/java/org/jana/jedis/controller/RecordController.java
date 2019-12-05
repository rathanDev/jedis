package org.jana.jedis.controller;

import org.jana.jedis.document.Record;
import org.jana.jedis.request.SaveRecordRequest;
import org.jana.jedis.request.UpdateRecordRequest;
import org.jana.jedis.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/all")
    public ResponseEntity<List<Record>> getCourses() {
        List<Record> all = recordService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<Record> getCourse(@PathVariable("recordId") String recordId) {
        Record record = recordService.getById(recordId);
        return ResponseEntity.ok(record);
    }

    @PostMapping("/save")
    public ResponseEntity<Record> save(@RequestBody SaveRecordRequest request) {
        Record record = recordService.save(request);
        return ResponseEntity.ok(record);
    }

    @PostMapping("/update/{recordId}")
    public ResponseEntity<Record> update(@PathVariable("recordId") String recordId, @RequestBody UpdateRecordRequest request) {
        Record record = recordService.update(recordId, request);
        return ResponseEntity.ok(record);
    }

    @PostMapping("/clear-cache")
    public String clearCache() {
        return recordService.clearCache();
    }

}

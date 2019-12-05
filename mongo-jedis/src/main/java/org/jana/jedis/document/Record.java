package org.jana.jedis.document;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Record implements Serializable {

    @Id
    private String recordId;

    private String code;

    private int value;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

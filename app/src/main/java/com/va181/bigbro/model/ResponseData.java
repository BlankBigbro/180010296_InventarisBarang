package com.va181.bigbro.model;

import java.util.List;

public class ResponseData {

    private String value;
    private String message;
    private List<Barang> result;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Barang> getResult() {
        return result;
    }
}

package kr.co.carroteditor.global;

import lombok.Data;

@Data
public class ValidationResponse {


    private final String field;
    private final String message;
}

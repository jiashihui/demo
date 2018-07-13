package com.example.demo.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private String code;
    private String message;

    @Override
    public String toString() {
        return "code :" + code + ", message : " + message + ".";
    }
}

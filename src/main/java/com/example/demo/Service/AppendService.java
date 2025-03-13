package com.example.demo.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppendService {

    public String appendTextValue(String value) {
        return "Ahoj " + value;
    }

    public String append(String value) {
        return value;
    }
}

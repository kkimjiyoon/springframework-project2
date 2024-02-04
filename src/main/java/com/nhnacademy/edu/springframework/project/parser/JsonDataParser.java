package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonDataParser implements DataParser {
    @Override
    @ExecutionTime
    public Collection<WaterBill> parse(String filePath) {
        List<WaterBill> waterBillList = new ArrayList<>();
        return null;
    }
}

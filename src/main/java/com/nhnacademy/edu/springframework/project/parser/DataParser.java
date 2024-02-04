package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.domain.WaterBill;

import java.util.Collection;
import java.util.List;

public interface DataParser {
    Collection<WaterBill> parse(String filePath);
}

package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.domain.WaterBill;

import java.util.Collection;
import java.util.List;

public interface ResultReport {
    void resultReport(Collection<WaterBill> waterBillList);
}

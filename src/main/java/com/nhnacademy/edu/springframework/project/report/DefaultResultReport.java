package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DefaultResultReport implements ResultReport {
    @Override
    @ExecutionTime
    public void resultReport(Collection<WaterBill> waterBillList) {
        waterBillList.stream().limit(5).forEach(System.out::println);
    }
}

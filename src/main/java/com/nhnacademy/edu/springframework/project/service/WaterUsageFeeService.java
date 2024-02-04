package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.domain.WaterBill;

import java.util.Collection;

public interface WaterUsageFeeService {
    Collection<WaterBill> calculateFee(long waterUsage);
}

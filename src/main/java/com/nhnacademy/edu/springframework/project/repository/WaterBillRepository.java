package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.domain.WaterBill;

import java.util.Collection;
import java.util.List;

public interface WaterBillRepository {
    void load();
    Collection<WaterBill> findFeeByUsage(long waterUsage);
}

package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;
import com.nhnacademy.edu.springframework.project.repository.WaterBillRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DefaultWaterUsageFeeService implements WaterUsageFeeService {
    private final WaterBillRepository waterBillRepository;

    public DefaultWaterUsageFeeService(WaterBillRepository waterBillRepository) {
        this.waterBillRepository = waterBillRepository;
    }

    @Override
    @ExecutionTime
    public Collection<WaterBill> calculateFee(long waterUsage) {
        Collection<WaterBill> waterBillList = waterBillRepository.findFeeByUsage(waterUsage).stream().sorted(Comparator.comparing(WaterBill::getUnitPrice)).collect(Collectors.toList());

        for (WaterBill waterBill : waterBillList) {
            long totalBill = waterBill.getUnitPrice() * waterUsage;
            waterBill.setBillTotal(totalBill);
        }

        return waterBillList;
    }
}

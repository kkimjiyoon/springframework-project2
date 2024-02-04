package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;
import com.nhnacademy.edu.springframework.project.parser.DataParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class DefaultWaterBillRepository implements WaterBillRepository {

    private final DataParser dataParser;
    private Collection<WaterBill> waterBillList;

    @Value("${filePath}")
    private String filePath;
    public DefaultWaterBillRepository(DataParser dataParser) {
        this.dataParser = dataParser;
        this.waterBillList = new ArrayList<>();
    }

    @Override
    @ExecutionTime
    public void load() {
        waterBillList = dataParser.parse(filePath);
    }

    @Override
    @ExecutionTime
    public Collection<WaterBill> findFeeByUsage(long waterUsage) {
        return waterBillList.stream().filter(waterBill -> (waterBill.getSectionStart() <= waterUsage) && waterBill.getSectionEnd() >= waterUsage).collect(Collectors.toList());
    }
}

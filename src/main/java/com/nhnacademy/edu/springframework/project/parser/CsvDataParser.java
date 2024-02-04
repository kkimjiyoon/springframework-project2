package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CsvDataParser implements DataParser {



    @Override
    @ExecutionTime
    public Collection<WaterBill> parse(String filePath) {
        List<WaterBill> waterBillList = new ArrayList<>();
        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataArray = line.split(",");
                int no = Integer.parseInt(dataArray[0]);
                String city = dataArray[1];
                String sector = dataArray[2];
                int step = Integer.parseInt(dataArray[3]);
                long sectionStart = Long.parseLong(dataArray[4]);
                long sectionEnd = Long.parseLong(dataArray[5]);
                long unitPrice = Long.parseLong(dataArray[6]);

                waterBillList.add(new WaterBill(no, city, sector, step, sectionStart, sectionEnd, unitPrice));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return waterBillList;
    }
}

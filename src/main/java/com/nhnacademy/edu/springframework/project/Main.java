package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.ConfigMain;
import com.nhnacademy.edu.springframework.project.report.DefaultResultReport;
import com.nhnacademy.edu.springframework.project.report.ResultReport;
import com.nhnacademy.edu.springframework.project.repository.WaterBillRepository;
import com.nhnacademy.edu.springframework.project.service.DefaultWaterUsageFeeService;
import com.nhnacademy.edu.springframework.project.service.WaterUsageFeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigMain.class);

        WaterBillRepository waterBillRepository = context.getBean("defaultWaterBillRepository", WaterBillRepository.class);
        waterBillRepository.load();

        WaterUsageFeeService defaultWaterUsageFeeService = context.getBean("defaultWaterUsageFeeService", WaterUsageFeeService.class);

        String line;

        System.out.print("물 사용량 입력 > ");

            Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).isEmpty()) {
            long waterUsage = Long.parseLong(line);
            ResultReport defaultResultReport = context.getBean("defaultResultReport", ResultReport.class);
            defaultResultReport.resultReport(defaultWaterUsageFeeService.calculateFee(waterUsage));
        }




    }
}

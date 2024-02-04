package com.nhnacademy.edu.springframework.project.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.nhnacademy.edu.springframework.project.annotation.ExecutionTime;
import com.nhnacademy.edu.springframework.project.domain.WaterBill;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class JsonDataParser implements DataParser {
    @Override
    @ExecutionTime
    public Collection<WaterBill> parse(String filePath) {
        List<WaterBill> waterBillList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            ArrayNode jsonArray = (ArrayNode) objectMapper.readTree(inputStream);

            Iterator<JsonNode> elements = jsonArray.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                int no = node.get("순번").asInt();
                String city = node.get("지자체명").asText();
                String sector = node.get("업종").asText();
                int step = node.get("단계").asInt();
                long sectionStart = node.get("구간시작(세제곱미터)").asLong();
                long sectionEnd = node.get("구간끝(세제곱미터)").asLong();
                long unitPrice = node.get("구간금액(원)").asLong();

                waterBillList.add(new WaterBill(no, city, sector, step, sectionStart, sectionEnd, unitPrice));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return waterBillList;
    }
}

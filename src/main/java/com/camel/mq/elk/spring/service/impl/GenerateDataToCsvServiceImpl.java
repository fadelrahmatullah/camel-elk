package com.camel.mq.elk.spring.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.camel.mq.elk.spring.constants.Constants;
import com.camel.mq.elk.spring.repository.GetDataRepository;
import com.camel.mq.elk.spring.service.GenerateDataToCsvService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenerateDataToCsvServiceImpl implements GenerateDataToCsvService{
    
    @Autowired 
    private GetDataRepository getDataRepository;
    
    @Override
    public void generateCsv() {

        List<Map<String, Object>> data = getDataRepository.executeQuery();
        Random rand = new Random();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        final String currentDate = dateFormat.format(new Date());
        final String folderPath = Constants.FILE_DIRECT;

        String filePath = "";
    
        int random = rand.nextInt(100000);
        String fileName = "filecsvCamel_"+ currentDate +"-"+String.valueOf(random)+".csv";
        if (data.isEmpty()) {
            throw new EmptyResultDataAccessException("", 0);
        }

        try {
            // create directory path in local systme if not exist
            if (!Files.exists(Paths.get(folderPath))) {
                Files.createDirectories(Paths.get(folderPath));
            }
            
            filePath = folderPath + Constants.FILE_SEPARATOR + fileName;
            this.createCsv(data, filePath);

        } catch (Exception e) {
            log.info("Error : "+e.getMessage());
        }
        
    }

    private void createCsv(List<Map<String, Object>> list, String filePath) throws IOException{

        FileWriter fileWriter = new FileWriter(filePath);
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter('|').setQuoteMode(QuoteMode.ALL).build();
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);

        Object[] header = !list.isEmpty() ? list.get(0).keySet().toArray() : null;
        if(header == null){
            csvPrinter.close();
            fileWriter.close();
            throw new RuntimeException("Header Is Null");
        }

        csvPrinter.printRecord(header);

         // Write the data rows
         for (Map<String, Object> row : list) {
            if (row != null && row.values() != null) {
                Object[] rowData  = row.values().stream().map(value -> value != null ? value.toString() : "").toArray();
                csvPrinter.printRecord(rowData);
            }
        }  

        csvPrinter.close();
        fileWriter.close();

                    
    }
    
}

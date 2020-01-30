package com.unilever.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.unilever.dto.OutletDto;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvOutletParser {

    public List<OutletDto> readAllOutlets(InputStream inputStream) throws java.io.IOException {
        try (InputStreamReader isr = new InputStreamReader(inputStream)) {
            return new CsvToBeanBuilder<OutletDto>(isr)
                    .withType(OutletDto.class)
                    .build().parse();
        }
    }
}

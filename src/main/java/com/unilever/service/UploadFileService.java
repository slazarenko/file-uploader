package com.unilever.service;

import com.unilever.mapper.OutletMapper;
import com.unilever.repository.OutletRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UploadFileService {
    private final OutletRepository outletRepository;
    private final OutletMapper outletMapper;
    private final CsvOutletParser csvOutletParser;

    public UploadFileService(OutletRepository outletRepository,
                             OutletMapper outletMapper,
                             CsvOutletParser csvOutletParser) {
        this.outletRepository = outletRepository;
        this.outletMapper = outletMapper;
        this.csvOutletParser = csvOutletParser;
    }

    /**
     * @return number of processed items
     */
    public long upload(MultipartFile file) throws IOException {
        return csvOutletParser.readAllOutlets(file.getInputStream())
                .stream()
                .map(outletMapper::mapToEntity)
                .peek(outletRepository::save).count();
    }

}

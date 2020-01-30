package com.unilever.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

@RestController
public class OutletRestController {
    private final UploadFileService uploadFileService;

    public OutletRestController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping("/upload-file")
    public DeferredResult<ResponseEntity<String>> uploadFile(@RequestParam("file") MultipartFile file) {
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();

        ForkJoinPool.commonPool().submit(() -> {
            try {
                deferredResult.setResult(
                        ResponseEntity.ok("File with " + uploadFileService.upload(file) + " items successfully uploaded")
                );
            } catch (IOException e) {
                deferredResult.setResult(
                        new ResponseEntity<>("Exception has occurred", HttpStatus.INTERNAL_SERVER_ERROR)
                );
            }
        });

        return deferredResult;
    }
}

package com.geppetto.dedalus.controller;

import com.geppetto.dedalus.dto.ExternalpatientlistDto;
import com.geppetto.dedalus.service.ExternalpatientlistService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Externalpatientlist
* Provides endpoints to create, update, delete, retrieve, and search for Externalpatientlist,
* as well as to handle file uploads and downloads associated with Externalpatientlist.
*/
@RestController
@RequestMapping("/externalpatient")
@RequiredArgsConstructor
@Slf4j
public class ExternalpatientlistController {

   private final ExternalpatientlistService externalpatientlistService; 


@GetMapping("/{id}")
public ResponseEntity<ExternalpatientlistDto> getExternalpatientlistById(@PathVariable String id) {
    log.info("Enter into getExternalpatientlistById method");
    ResponseEntity<ExternalpatientlistDto> response =ResponseEntity.status(HttpStatus.OK).body(externalpatientlistService.getExternalpatientlistById(id));
    log.info("Exit from getExternalpatientlistById method");
    return response;
}

@PostMapping
public ResponseEntity<ExternalpatientlistDto> createExternalpatientlist(@Valid @RequestBody ExternalpatientlistDto externalpatientlistDto) {
    log.info("Enter into createExternalpatientlist method");
    ResponseEntity<ExternalpatientlistDto> response =  ResponseEntity.status(HttpStatus.OK).body(externalpatientlistService.createExternalpatientlist(externalpatientlistDto));
    log.info("Exit from createExternalpatientlist method");
    return response;
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteExternalpatientlist(@PathVariable String id) {
    log.info("Enter into deleteExternalpatientlist method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(externalpatientlistService.deleteExternalpatientlist(id));
    log.info("Exit from deleteExternalpatientlist method");
    return response;
}

@PutMapping
public ResponseEntity<ExternalpatientlistDto> updateExternalpatientlist(@Valid @RequestBody ExternalpatientlistDto externalpatientlistDto) {
    log.info("Enter into updateExternalpatientlist method");
    ResponseEntity<ExternalpatientlistDto> response = ResponseEntity.status(HttpStatus.OK).body(externalpatientlistService.updateExternalpatientlist(externalpatientlistDto));
    log.info("Exit from updateExternalpatientlist method");
    return response;
}

@GetMapping
public ResponseEntity<Page<ExternalpatientlistDto>> getAllExternalpatientlist(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllExternalpatientlist method");
    Page<ExternalpatientlistDto>externalpatientlistDtoPage = externalpatientlistService.getAllExternalpatientlist(page, size);
    log.info("Exit from getAllExternalpatientlist method");
    return new ResponseEntity<>(externalpatientlistDtoPage, HttpStatus.OK);
}

   
}

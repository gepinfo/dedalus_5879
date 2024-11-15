package com.geppetto.dedalus.controller;

import com.geppetto.dedalus.dto.HospitalorderlistDto;
import com.geppetto.dedalus.service.HospitalorderlistService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Hospitalorderlist
* Provides endpoints to create, update, delete, retrieve, and search for Hospitalorderlist,
* as well as to handle file uploads and downloads associated with Hospitalorderlist.
*/
@RestController
@RequestMapping("/hospitalorder")
@RequiredArgsConstructor
@Slf4j
public class HospitalorderlistController {

   private final HospitalorderlistService hospitalorderlistService; 


@GetMapping("/{id}")
public ResponseEntity<HospitalorderlistDto> getHospitalorderlistById(@PathVariable String id) {
    log.info("Enter into getHospitalorderlistById method");
    ResponseEntity<HospitalorderlistDto> response =ResponseEntity.status(HttpStatus.OK).body(hospitalorderlistService.getHospitalorderlistById(id));
    log.info("Exit from getHospitalorderlistById method");
    return response;
}

@PostMapping
public ResponseEntity<HospitalorderlistDto> createHospitalorderlist(@Valid @RequestBody HospitalorderlistDto hospitalorderlistDto) {
    log.info("Enter into createHospitalorderlist method");
    ResponseEntity<HospitalorderlistDto> response =  ResponseEntity.status(HttpStatus.OK).body(hospitalorderlistService.createHospitalorderlist(hospitalorderlistDto));
    log.info("Exit from createHospitalorderlist method");
    return response;
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteHospitalorderlist(@PathVariable String id) {
    log.info("Enter into deleteHospitalorderlist method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(hospitalorderlistService.deleteHospitalorderlist(id));
    log.info("Exit from deleteHospitalorderlist method");
    return response;
}

@PutMapping
public ResponseEntity<HospitalorderlistDto> updateHospitalorderlist(@Valid @RequestBody HospitalorderlistDto hospitalorderlistDto) {
    log.info("Enter into updateHospitalorderlist method");
    ResponseEntity<HospitalorderlistDto> response = ResponseEntity.status(HttpStatus.OK).body(hospitalorderlistService.updateHospitalorderlist(hospitalorderlistDto));
    log.info("Exit from updateHospitalorderlist method");
    return response;
}

@GetMapping
public ResponseEntity<Page<HospitalorderlistDto>> getAllHospitalorderlist(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllHospitalorderlist method");
    Page<HospitalorderlistDto>hospitalorderlistDtoPage = hospitalorderlistService.getAllHospitalorderlist(page, size);
    log.info("Exit from getAllHospitalorderlist method");
    return new ResponseEntity<>(hospitalorderlistDtoPage, HttpStatus.OK);
}

   
}

package com.geppetto.dedalus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospitalorderlist {

@Id
private String id;

private String orderID;

private String speciemanNo;

private String patientID;

private String facility;

private String episodeType;

private String episodeID;

private String doctor;

private String type;

private String code;

private String ps;

    
    
}


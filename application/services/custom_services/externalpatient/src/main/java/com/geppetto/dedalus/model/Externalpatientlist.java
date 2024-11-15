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
public class Externalpatientlist {

@Id
private String id;

private String extPatientID;

private String patientName;

private String locPatientName;

private String gender;

private String dateofBirth;

private String source;

private String description;

private String profix;

private String sourcePatientID;

private String IDNo;

    
    
}


package com.geppetto.dedalus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalpatientlistDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "extPatientID cannot be null or empty")  
    private String extPatientID;
   
    @NotBlank(message = "patientName cannot be null or empty")  
    private String patientName;
   
    @NotBlank(message = "locPatientName cannot be null or empty")  
    private String locPatientName;
   
    @NotBlank(message = "gender cannot be null or empty")  
    private String gender;
   
    @NotBlank(message = "dateofBirth cannot be null or empty")  
    private String dateofBirth;
   
    @NotBlank(message = "source cannot be null or empty")  
    private String source;
   
    @NotBlank(message = "description cannot be null or empty")  
    private String description;
   
    @NotBlank(message = "profix cannot be null or empty")  
    private String profix;
   
    @NotBlank(message = "sourcePatientID cannot be null or empty")  
    private String sourcePatientID;
   
    @NotBlank(message = "IDNo cannot be null or empty")  
    private String IDNo;
  
    }

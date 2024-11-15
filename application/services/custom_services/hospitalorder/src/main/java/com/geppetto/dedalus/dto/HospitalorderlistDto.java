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
public class HospitalorderlistDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "orderID cannot be null or empty")  
    private String orderID;
   
    @NotBlank(message = "speciemanNo cannot be null or empty")  
    private String speciemanNo;
   
    @NotBlank(message = "patientID cannot be null or empty")  
    private String patientID;
   
    @NotBlank(message = "facility cannot be null or empty")  
    private String facility;
   
    @NotBlank(message = "episodeType cannot be null or empty")  
    private String episodeType;
   
    @NotBlank(message = "episodeID cannot be null or empty")  
    private String episodeID;
   
    @NotBlank(message = "doctor cannot be null or empty")  
    private String doctor;
   
    @NotBlank(message = "type cannot be null or empty")  
    private String type;
   
    @NotBlank(message = "code cannot be null or empty")  
    private String code;
   
    @NotBlank(message = "ps cannot be null or empty")  
    private String ps;
  
    }

package com.geppetto.dedalus.service;

import com.geppetto.dedalus.dto.ExternalpatientlistDto;
import org.springframework.data.domain.Page;

public interface ExternalpatientlistService {

    ExternalpatientlistDto  getExternalpatientlistById(String id);

    ExternalpatientlistDto  createExternalpatientlist(ExternalpatientlistDto externalpatientlistDto);

    String  deleteExternalpatientlist(String id);

    ExternalpatientlistDto  updateExternalpatientlist(ExternalpatientlistDto externalpatientlistDto);

    Page<ExternalpatientlistDto>  getAllExternalpatientlist(int page, int size);

}

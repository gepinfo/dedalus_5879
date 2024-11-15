package com.geppetto.dedalus.service;

import com.geppetto.dedalus.dto.HospitalorderlistDto;
import org.springframework.data.domain.Page;

public interface HospitalorderlistService {

    HospitalorderlistDto  getHospitalorderlistById(String id);

    HospitalorderlistDto  createHospitalorderlist(HospitalorderlistDto hospitalorderlistDto);

    String  deleteHospitalorderlist(String id);

    HospitalorderlistDto  updateHospitalorderlist(HospitalorderlistDto hospitalorderlistDto);

    Page<HospitalorderlistDto>  getAllHospitalorderlist(int page, int size);

}

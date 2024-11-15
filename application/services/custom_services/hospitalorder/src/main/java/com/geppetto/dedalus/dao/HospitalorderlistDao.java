package com.geppetto.dedalus.dao;

import java.util.Optional;
import com.geppetto.dedalus.model.Hospitalorderlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface HospitalorderlistDao {

    Optional<Hospitalorderlist> getHospitalorderlistById(String id);

    Hospitalorderlist createHospitalorderlist(Hospitalorderlist hospitalorderlist);

    void deleteHospitalorderlist(String id);

    Optional<Hospitalorderlist> updateHospitalorderlist(String id);

    Page<Hospitalorderlist> getAllHospitalorderlist(Pageable pageable);

}


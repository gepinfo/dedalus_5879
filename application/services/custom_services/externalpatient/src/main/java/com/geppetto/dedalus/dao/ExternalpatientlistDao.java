package com.geppetto.dedalus.dao;

import java.util.Optional;
import com.geppetto.dedalus.model.Externalpatientlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ExternalpatientlistDao {

    Optional<Externalpatientlist> getExternalpatientlistById(String id);

    Externalpatientlist createExternalpatientlist(Externalpatientlist externalpatientlist);

    void deleteExternalpatientlist(String id);

    Optional<Externalpatientlist> updateExternalpatientlist(String id);

    Page<Externalpatientlist> getAllExternalpatientlist(Pageable pageable);

}


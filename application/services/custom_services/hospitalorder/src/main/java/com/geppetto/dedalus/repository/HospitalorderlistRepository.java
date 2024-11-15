package com.geppetto.dedalus.repository;

import com.geppetto.dedalus.model.Hospitalorderlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface HospitalorderlistRepository extends MongoRepository<Hospitalorderlist,String>  {
    
    Page<Hospitalorderlist> findAll(Pageable pageable);

}

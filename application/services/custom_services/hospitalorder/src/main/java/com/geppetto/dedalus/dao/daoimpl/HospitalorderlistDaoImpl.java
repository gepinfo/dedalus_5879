package com.geppetto.dedalus.dao.daoimpl;

import com.geppetto.dedalus.repository.HospitalorderlistRepository;
import com.geppetto.dedalus.dao.HospitalorderlistDao;

import java.util.Optional;
import com.geppetto.dedalus.model.Hospitalorderlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link HospitalorderlistDao} interface.
* Provides methods to interact with the {@link HospitalorderlistRepository} for CRUD operations on {@link Hospitalorderlist } entities.
*/
@Service
public class HospitalorderlistDaoImpl implements HospitalorderlistDao {

    private final HospitalorderlistRepository hospitalorderlistRepository;
    /**
     * Constructs a new {@code HospitalorderlistDaoImpl} with the specified repository.
     *
     * @param hospitalorderlistRepository The repository used for accessing {@link Hospitalorderlist} entities. Must not be {@code null}.
     */
    public HospitalorderlistDaoImpl(HospitalorderlistRepository hospitalorderlistRepository) {
        this.hospitalorderlistRepository = hospitalorderlistRepository;
    }

    /**
     * Retrieves hospitalorderlist by its ID.
     *
     * @param id The ID of the hospitalorderlist to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the hospitalorderlist if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Hospitalorderlist> getHospitalorderlistById(String id) {
        return hospitalorderlistRepository.findById(id);
    }


    /**
     * Creates new hospitalorderlist.
     *
     * @param hospitalorderlist The {@link Hospitalorderlist} entity to create. Must not be {@code null}.
     * @return The created {@link Hospitalorderlist} entity.
     */
    @Override
    public Hospitalorderlist createHospitalorderlist(Hospitalorderlist hospitalorderlist) {
        return hospitalorderlistRepository.save(hospitalorderlist);
    }


    /**
     * Deletes hospitalorderlist by its ID.
     *
     * @param id The ID of the hospitalorderlist to delete. Must not be {@code null}.
     */
    @Override
    public void deleteHospitalorderlist(String id) {
        hospitalorderlistRepository.deleteById(id);
    }


    /**
     * Retrieves hospitalorderlist by its ID for update purposes.
     *
     * @param id The ID of the hospitalorderlist to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the hospitalorderlist if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Hospitalorderlist> updateHospitalorderlist(String id) {
        return hospitalorderlistRepository.findById(id);
    }


     /**
     * Retrieves all hospitalorderlist from the repository.
     *
     * @return A list of all {@link Hospitalorderlist} entities.
     */
    @Override
    public Page<Hospitalorderlist> getAllHospitalorderlist(Pageable pageable) {
        return hospitalorderlistRepository.findAll(pageable);
    }


}



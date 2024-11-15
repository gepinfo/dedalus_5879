package com.geppetto.dedalus.dao.daoimpl;

import com.geppetto.dedalus.repository.ExternalpatientlistRepository;
import com.geppetto.dedalus.dao.ExternalpatientlistDao;

import java.util.Optional;
import com.geppetto.dedalus.model.Externalpatientlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link ExternalpatientlistDao} interface.
* Provides methods to interact with the {@link ExternalpatientlistRepository} for CRUD operations on {@link Externalpatientlist } entities.
*/
@Service
public class ExternalpatientlistDaoImpl implements ExternalpatientlistDao {

    private final ExternalpatientlistRepository externalpatientlistRepository;
    /**
     * Constructs a new {@code ExternalpatientlistDaoImpl} with the specified repository.
     *
     * @param externalpatientlistRepository The repository used for accessing {@link Externalpatientlist} entities. Must not be {@code null}.
     */
    public ExternalpatientlistDaoImpl(ExternalpatientlistRepository externalpatientlistRepository) {
        this.externalpatientlistRepository = externalpatientlistRepository;
    }

    /**
     * Retrieves externalpatientlist by its ID.
     *
     * @param id The ID of the externalpatientlist to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the externalpatientlist if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Externalpatientlist> getExternalpatientlistById(String id) {
        return externalpatientlistRepository.findById(id);
    }


    /**
     * Creates new externalpatientlist.
     *
     * @param externalpatientlist The {@link Externalpatientlist} entity to create. Must not be {@code null}.
     * @return The created {@link Externalpatientlist} entity.
     */
    @Override
    public Externalpatientlist createExternalpatientlist(Externalpatientlist externalpatientlist) {
        return externalpatientlistRepository.save(externalpatientlist);
    }


    /**
     * Deletes externalpatientlist by its ID.
     *
     * @param id The ID of the externalpatientlist to delete. Must not be {@code null}.
     */
    @Override
    public void deleteExternalpatientlist(String id) {
        externalpatientlistRepository.deleteById(id);
    }


    /**
     * Retrieves externalpatientlist by its ID for update purposes.
     *
     * @param id The ID of the externalpatientlist to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the externalpatientlist if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Externalpatientlist> updateExternalpatientlist(String id) {
        return externalpatientlistRepository.findById(id);
    }


     /**
     * Retrieves all externalpatientlist from the repository.
     *
     * @return A list of all {@link Externalpatientlist} entities.
     */
    @Override
    public Page<Externalpatientlist> getAllExternalpatientlist(Pageable pageable) {
        return externalpatientlistRepository.findAll(pageable);
    }


}



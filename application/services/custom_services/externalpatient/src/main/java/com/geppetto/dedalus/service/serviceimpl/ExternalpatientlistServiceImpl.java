package com.geppetto.dedalus.service.serviceimpl;

import com.geppetto.dedalus.dao.ExternalpatientlistDao;
import com.geppetto.dedalus.dto.ExternalpatientlistDto;
import com.geppetto.dedalus.exception.EntityNotFoundException;
import com.geppetto.dedalus.model.Externalpatientlist;
import com.geppetto.dedalus.service.ExternalpatientlistService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link ExternalpatientlistService} interface.
* Provides services related to Externalpatientlist, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class ExternalpatientlistServiceImpl implements ExternalpatientlistService {


    /**
     * Constructs a {@code ExternalpatientlistServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param externalpatientlistDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final ExternalpatientlistDao externalpatientlistDao;
  private final MongoTemplate mongoTemplate;

  public ExternalpatientlistServiceImpl(ExternalpatientlistDao  externalpatientlistDao, MongoTemplate mongoTemplate) {
    this. externalpatientlistDao =  externalpatientlistDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Retrieves externalpatientlist by its ID.
     *
     * @param id The ID of the externalpatientlist to retrieve. Must not be {@code null}.
     * @return The externalpatientlist data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no externalpatientlist with the specified ID is found.
     */
  @Override
  public ExternalpatientlistDto  getExternalpatientlistById(String id) {
    log.info("Enter into getExternalpatientlistById method");
    return externalpatientlistDao.getExternalpatientlistById(id)
    .map(externalpatientlist -> {
      ExternalpatientlistDto externalpatientlistDto = new ExternalpatientlistDto();
      BeanUtils.copyProperties(externalpatientlist, externalpatientlistDto);
      log.info("Exit from getExternalpatientlistById method");
      return externalpatientlistDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Creates new externalpatientlist.
     *
     * @param externalpatientlistDto The {@link ExternalpatientlistDto} to be created.
     * @return The created {@link ExternalpatientlistDto}.
     */
  @Override
  public ExternalpatientlistDto  createExternalpatientlist(ExternalpatientlistDto externalpatientlistDto) {
    log.info("Enter into createExternalpatientlist method");
    Externalpatientlist externalpatientlist = new Externalpatientlist();
  BeanUtils.copyProperties(externalpatientlistDto, externalpatientlist);
  Externalpatientlist createdExternalpatientlist= externalpatientlistDao.createExternalpatientlist(externalpatientlist);
  BeanUtils.copyProperties(createdExternalpatientlist, externalpatientlistDto);
  log.info("Exit from createExternalpatientlist method");
  return externalpatientlistDto;
  }
    
    /**
     * Deletes externalpatientlist by ID.
     *
     * @param id The ID of the externalpatientlist to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no externalpatientlist with the specified ID is found.
     */
  @Override
  public String  deleteExternalpatientlist(String id) {
    log.info("Enter into deleteExternalpatientlist method");
    return externalpatientlistDao.getExternalpatientlistById(id)
     .map(externalpatientlist -> {
     externalpatientlistDao.deleteExternalpatientlist(id);
  log.info("Exit from deleteExternalpatientlist method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Updates existing externalpatientlist.
     *
     * @param externalpatientlistDto The {@link ExternalpatientlistDto} containing updated information.
     * @return The updated {@link ExternalpatientlistDto}.
     * @throws EntityNotFoundException If no externalpatientlist with the specified ID is found.
     */
  @Override
  public ExternalpatientlistDto  updateExternalpatientlist(ExternalpatientlistDto externalpatientlistDto) {
    log.info("Enter into updateExternalpatientlist method");
    return externalpatientlistDao.getExternalpatientlistById(externalpatientlistDto.getId())
    .map(existingExternalpatientlist -> {
      BeanUtils.copyProperties(externalpatientlistDto, existingExternalpatientlist);
      externalpatientlistDao.createExternalpatientlist(existingExternalpatientlist);
      log.info("Exit from updateExternalpatientlist method");
      return externalpatientlistDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + externalpatientlistDto.getId()));
  }
    
    /**
     * Retrieves all externalpatientlist.
     *
     * @return A list of {@link ExternalpatientlistDto} representing all externalpatientlist.
     */
  @Override
  public Page<ExternalpatientlistDto>  getAllExternalpatientlist(int page, int size) {
    log.info("Enter into getAllExternalpatientlist method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Externalpatientlist> externalpatientlistPage =externalpatientlistDao.getAllExternalpatientlist(pageable);
    Page<ExternalpatientlistDto>externalpatientlistDtoPage = externalpatientlistPage.map(externalpatientlist -> {
    ExternalpatientlistDto externalpatientlistDto = ExternalpatientlistDto.builder().build();
    BeanUtils.copyProperties(externalpatientlist, externalpatientlistDto);
    return externalpatientlistDto;
    });
    log.info("Exit from getAllexternalpatientlistmethod");
    return externalpatientlistDtoPage;
  }
    

}

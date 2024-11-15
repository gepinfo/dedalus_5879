package com.geppetto.dedalus.service.serviceimpl;

import com.geppetto.dedalus.dao.HospitalorderlistDao;
import com.geppetto.dedalus.dto.HospitalorderlistDto;
import com.geppetto.dedalus.exception.EntityNotFoundException;
import com.geppetto.dedalus.model.Hospitalorderlist;
import com.geppetto.dedalus.service.HospitalorderlistService;
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
* Implementation of the {@link HospitalorderlistService} interface.
* Provides services related to Hospitalorderlist, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class HospitalorderlistServiceImpl implements HospitalorderlistService {


    /**
     * Constructs a {@code HospitalorderlistServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param hospitalorderlistDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final HospitalorderlistDao hospitalorderlistDao;
  private final MongoTemplate mongoTemplate;

  public HospitalorderlistServiceImpl(HospitalorderlistDao  hospitalorderlistDao, MongoTemplate mongoTemplate) {
    this. hospitalorderlistDao =  hospitalorderlistDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Retrieves hospitalorderlist by its ID.
     *
     * @param id The ID of the hospitalorderlist to retrieve. Must not be {@code null}.
     * @return The hospitalorderlist data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no hospitalorderlist with the specified ID is found.
     */
  @Override
  public HospitalorderlistDto  getHospitalorderlistById(String id) {
    log.info("Enter into getHospitalorderlistById method");
    return hospitalorderlistDao.getHospitalorderlistById(id)
    .map(hospitalorderlist -> {
      HospitalorderlistDto hospitalorderlistDto = new HospitalorderlistDto();
      BeanUtils.copyProperties(hospitalorderlist, hospitalorderlistDto);
      log.info("Exit from getHospitalorderlistById method");
      return hospitalorderlistDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Creates new hospitalorderlist.
     *
     * @param hospitalorderlistDto The {@link HospitalorderlistDto} to be created.
     * @return The created {@link HospitalorderlistDto}.
     */
  @Override
  public HospitalorderlistDto  createHospitalorderlist(HospitalorderlistDto hospitalorderlistDto) {
    log.info("Enter into createHospitalorderlist method");
    Hospitalorderlist hospitalorderlist = new Hospitalorderlist();
  BeanUtils.copyProperties(hospitalorderlistDto, hospitalorderlist);
  Hospitalorderlist createdHospitalorderlist= hospitalorderlistDao.createHospitalorderlist(hospitalorderlist);
  BeanUtils.copyProperties(createdHospitalorderlist, hospitalorderlistDto);
  log.info("Exit from createHospitalorderlist method");
  return hospitalorderlistDto;
  }
    
    /**
     * Deletes hospitalorderlist by ID.
     *
     * @param id The ID of the hospitalorderlist to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no hospitalorderlist with the specified ID is found.
     */
  @Override
  public String  deleteHospitalorderlist(String id) {
    log.info("Enter into deleteHospitalorderlist method");
    return hospitalorderlistDao.getHospitalorderlistById(id)
     .map(hospitalorderlist -> {
     hospitalorderlistDao.deleteHospitalorderlist(id);
  log.info("Exit from deleteHospitalorderlist method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Updates existing hospitalorderlist.
     *
     * @param hospitalorderlistDto The {@link HospitalorderlistDto} containing updated information.
     * @return The updated {@link HospitalorderlistDto}.
     * @throws EntityNotFoundException If no hospitalorderlist with the specified ID is found.
     */
  @Override
  public HospitalorderlistDto  updateHospitalorderlist(HospitalorderlistDto hospitalorderlistDto) {
    log.info("Enter into updateHospitalorderlist method");
    return hospitalorderlistDao.getHospitalorderlistById(hospitalorderlistDto.getId())
    .map(existingHospitalorderlist -> {
      BeanUtils.copyProperties(hospitalorderlistDto, existingHospitalorderlist);
      hospitalorderlistDao.createHospitalorderlist(existingHospitalorderlist);
      log.info("Exit from updateHospitalorderlist method");
      return hospitalorderlistDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + hospitalorderlistDto.getId()));
  }
    
    /**
     * Retrieves all hospitalorderlist.
     *
     * @return A list of {@link HospitalorderlistDto} representing all hospitalorderlist.
     */
  @Override
  public Page<HospitalorderlistDto>  getAllHospitalorderlist(int page, int size) {
    log.info("Enter into getAllHospitalorderlist method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Hospitalorderlist> hospitalorderlistPage =hospitalorderlistDao.getAllHospitalorderlist(pageable);
    Page<HospitalorderlistDto>hospitalorderlistDtoPage = hospitalorderlistPage.map(hospitalorderlist -> {
    HospitalorderlistDto hospitalorderlistDto = HospitalorderlistDto.builder().build();
    BeanUtils.copyProperties(hospitalorderlist, hospitalorderlistDto);
    return hospitalorderlistDto;
    });
    log.info("Exit from getAllhospitalorderlistmethod");
    return hospitalorderlistDtoPage;
  }
    

}

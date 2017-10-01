package com.mc.invoice.service.impl;

import com.mc.invoice.service.api.AccomidationService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.repository.AccomidationRepository;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = AccomidationServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = AccomidationService.class)
@Service
@Transactional(readOnly = true)
public class AccomidationServiceImpl implements AccomidationService {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private AccomidationRepository accomidationRepository;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param accomidationRepository
	 */
	@Autowired
	public AccomidationServiceImpl(AccomidationRepository accomidationRepository) {
		setAccomidationRepository(accomidationRepository);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return AccomidationRepository
	 */
	public AccomidationRepository getAccomidationRepository() {
		return accomidationRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidationRepository
	 */
	public void setAccomidationRepository(AccomidationRepository accomidationRepository) {
		this.accomidationRepository = accomidationRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidation
	 */
	@Transactional
	public void delete(Accomidation accomidation) {
		getAccomidationRepository().delete(accomidation);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entities
	 * @return List
	 */
	@Transactional
	public List<Accomidation> save(Iterable<Accomidation> entities) {
		return getAccomidationRepository().save(entities);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 */
	@Transactional
	public void delete(Iterable<Long> ids) {
		List<Accomidation> toDelete = getAccomidationRepository().findAll(ids);
		getAccomidationRepository().deleteInBatch(toDelete);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entity
	 * @return Accomidation
	 */
	@Transactional
	public Accomidation save(Accomidation entity) {
		return getAccomidationRepository().save(entity);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return Accomidation
	 */
	public Accomidation findOne(Long id) {
		return getAccomidationRepository().findOne(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return Accomidation
	 */
	public Accomidation findOneForUpdate(Long id) {
		return getAccomidationRepository().findOneDetached(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @return List
	 */
	public List<Accomidation> findAll(Iterable<Long> ids) {
		return getAccomidationRepository().findAll(ids);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return List
	 */
	public List<Accomidation> findAll() {
		return getAccomidationRepository().findAll();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Long
	 */
	public long count() {
		return getAccomidationRepository().count();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Accomidation> findAll(GlobalSearch globalSearch, Pageable pageable) {
		return getAccomidationRepository().findAll(globalSearch, pageable);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Accomidation> findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch,
			Pageable pageable) {
		return getAccomidationRepository().findByCustomerBooking(customerBooking, globalSearch, pageable);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return Long
	 */
	public long countByCustomerBooking(CustomerBooking customerBooking) {
		return getAccomidationRepository().countByCustomerBooking(customerBooking);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<Accomidation> getEntityType() {
		return Accomidation.class;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<Long> getIdType() {
		return Long.class;
	}
}

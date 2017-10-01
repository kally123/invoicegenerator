package com.mc.invoice.web;

import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.mc.invoice.service.api.AccomidationService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = AccomidationsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Accomidation.class, type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/accomidations", name = "AccomidationsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccomidationsCollectionJsonController {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private AccomidationService accomidationService;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param accomidationService
	 */
	@Autowired
	public AccomidationsCollectionJsonController(AccomidationService accomidationService) {
		this.accomidationService = accomidationService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return AccomidationService
	 */
	public AccomidationService getAccomidationService() {
		return accomidationService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidationService
	 */
	public void setAccomidationService(AccomidationService accomidationService) {
		this.accomidationService = accomidationService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return ResponseEntity
	 */
	@GetMapping(name = "list")
	public ResponseEntity<Page<Accomidation>> list(GlobalSearch globalSearch, Pageable pageable) {
		Page<Accomidation> accomidations = getAccomidationService().findAll(globalSearch, pageable);
		return ResponseEntity.ok(accomidations);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return UriComponents
	 */
	public static UriComponents listURI() {
		return MvcUriComponentsBuilder
				.fromMethodCall(
						MvcUriComponentsBuilder.on(AccomidationsCollectionJsonController.class).list(null, null))
				.build().encode();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidation
	 * @param result
	 * @return ResponseEntity
	 */
	@PostMapping(name = "create")
	public ResponseEntity<?> create(@Valid @RequestBody Accomidation accomidation, BindingResult result) {
		if (accomidation.getId() != null || accomidation.getVersion() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		Accomidation newAccomidation = getAccomidationService().save(accomidation);
		UriComponents showURI = AccomidationsItemJsonController.showURI(newAccomidation);
		return ResponseEntity.created(showURI.toUri()).build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidations
	 * @param result
	 * @return ResponseEntity
	 */
	@PostMapping(value = "/batch", name = "createBatch")
	public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Accomidation> accomidations,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		getAccomidationService().save(accomidations);
		return ResponseEntity.created(listURI().toUri()).build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param accomidations
	 * @param result
	 * @return ResponseEntity
	 */
	@PutMapping(value = "/batch", name = "updateBatch")
	public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Accomidation> accomidations,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		getAccomidationService().save(accomidations);
		return ResponseEntity.ok().build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @return ResponseEntity
	 */
	@DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
	public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
		getAccomidationService().delete(ids);
		return ResponseEntity.ok().build();
	}
}

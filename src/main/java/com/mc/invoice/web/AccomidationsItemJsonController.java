package com.mc.invoice.web;
import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.mc.invoice.service.api.AccomidationService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = AccomidationsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Accomidation.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/accomidations/{accomidation}", name = "AccomidationsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccomidationsItemJsonController {

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
    public AccomidationsItemJsonController(AccomidationService accomidationService) {
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
     * @param id
     * @return Accomidation
     */
    @ModelAttribute
    public Accomidation getAccomidation(@PathVariable("accomidation") Long id) {
        Accomidation accomidation = accomidationService.findOne(id);
        if (accomidation == null) {
            throw new NotFoundException(String.format("Accomidation with identifier '%s' not found", id));
        }
        return accomidation;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Accomidation accomidation) {
        return ResponseEntity.ok(accomidation);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @return UriComponents
     */
    public static UriComponents showURI(Accomidation accomidation) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(AccomidationsItemJsonController.class).show(accomidation)).buildAndExpand(accomidation.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedAccomidation
     * @param accomidation
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Accomidation storedAccomidation, @Valid @RequestBody Accomidation accomidation, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        accomidation.setId(storedAccomidation.getId());
        getAccomidationService().save(accomidation);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Accomidation accomidation) {
        getAccomidationService().delete(accomidation);
        return ResponseEntity.ok().build();
    }
}

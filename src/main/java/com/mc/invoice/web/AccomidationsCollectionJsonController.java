package com.mc.invoice.web;
import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = AccomidationsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Accomidation.class, type = ControllerType.COLLECTION)
@RooJSON
public class AccomidationsCollectionJsonController {
}

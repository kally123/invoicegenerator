package com.mc.invoice.web;
import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.mc.invoice.enumtype.AccomidationType;
import com.mc.invoice.service.api.AccomidationService;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Arrays;
import java.util.Locale;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = AccomidationsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Accomidation.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/accomidations/{accomidation}", name = "AccomidationsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class AccomidationsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<AccomidationsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private AccomidationService accomidationService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param accomidationService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public AccomidationsItemThymeleafController(AccomidationService accomidationService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setAccomidationService(accomidationService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(AccomidationsItemThymeleafController.class));
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
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<AccomidationsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<AccomidationsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Accomidation
     */
    @ModelAttribute
    public Accomidation getAccomidation(@PathVariable("accomidation") Long id, Locale locale, HttpMethod method) {
        Accomidation accomidation = null;
        if (HttpMethod.PUT.equals(method)) {
            accomidation = accomidationService.findOneForUpdate(id);
        } else {
            accomidation = accomidationService.findOne(id);
        }
        if (accomidation == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Accomidation", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return accomidation;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Accomidation accomidation, Model model) {
        model.addAttribute("accomidation", accomidation);
        return new ModelAndView("accomidations/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Accomidation accomidation, Model model) {
        model.addAttribute("accomidation", accomidation);
        return new ModelAndView("accomidations/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("accomidation")
    public void initAccomidationBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
        model.addAttribute("accomidationType", Arrays.asList(AccomidationType.values()));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Accomidation accomidation, Model model) {
        populateForm(model);
        model.addAttribute("accomidation", accomidation);
        return new ModelAndView("accomidations/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @param version
     * @param concurrencyControl
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Accomidation accomidation, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("accomidations/edit");
        }
        // Concurrency control
        Accomidation existingAccomidation = getAccomidationService().findOne(accomidation.getId());
        if (accomidation.getVersion() != existingAccomidation.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("accomidation", accomidation);
            model.addAttribute("concurrency", true);
            return new ModelAndView("accomidations/edit");
        } else if (accomidation.getVersion() != existingAccomidation.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("accomidation", existingAccomidation);
            model.addAttribute("concurrency", false);
            return new ModelAndView("accomidations/edit");
        } else if (accomidation.getVersion() != existingAccomidation.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            accomidation.setVersion(existingAccomidation.getVersion());
        }
        Accomidation savedAccomidation = getAccomidationService().save(accomidation);
        UriComponents showURI = getItemLink().to(AccomidationsItemThymeleafLinkFactory.SHOW).with("accomidation", savedAccomidation.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Accomidation accomidation) {
        getAccomidationService().delete(accomidation);
        return ResponseEntity.ok().build();
    }
}

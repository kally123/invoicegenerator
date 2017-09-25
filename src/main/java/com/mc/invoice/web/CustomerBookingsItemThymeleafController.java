package com.mc.invoice.web;
import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.mc.invoice.service.api.CustomerBookingService;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
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
 * = CustomerBookingsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = CustomerBooking.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/customerbookings/{customerBooking}", name = "CustomerBookingsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomerBookingsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CustomerBookingsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerBookingService customerBookingService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerBookingService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CustomerBookingsItemThymeleafController(CustomerBookingService customerBookingService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCustomerBookingService(customerBookingService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CustomerBookingsItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerBookingService
     */
    public CustomerBookingService getCustomerBookingService() {
        return customerBookingService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBookingService
     */
    public void setCustomerBookingService(CustomerBookingService customerBookingService) {
        this.customerBookingService = customerBookingService;
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
    public MethodLinkBuilderFactory<CustomerBookingsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CustomerBookingsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return CustomerBooking
     */
    @ModelAttribute
    public CustomerBooking getCustomerBooking(@PathVariable("customerBooking") Long id, Locale locale, HttpMethod method) {
        CustomerBooking customerBooking = null;
        if (HttpMethod.PUT.equals(method)) {
            customerBooking = customerBookingService.findOneForUpdate(id);
        } else {
            customerBooking = customerBookingService.findOne(id);
        }
        if (customerBooking == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "CustomerBooking", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute CustomerBooking customerBooking, Model model) {
        model.addAttribute("customerBooking", customerBooking);
        return new ModelAndView("customerbookings/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute CustomerBooking customerBooking, Model model) {
        model.addAttribute("customerBooking", customerBooking);
        return new ModelAndView("customerbookings/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("customerBooking")
    public void initCustomerBookingBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.setDisallowedFields("accomidation.id");
        dataBinder.setDisallowedFields("customer.id");
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
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute CustomerBooking customerBooking, Model model) {
        populateForm(model);
        model.addAttribute("customerBooking", customerBooking);
        return new ModelAndView("customerbookings/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param version
     * @param concurrencyControl
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute CustomerBooking customerBooking, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("customerbookings/edit");
        }
        // Concurrency control
        CustomerBooking existingCustomerBooking = getCustomerBookingService().findOne(customerBooking.getId());
        if (customerBooking.getVersion() != existingCustomerBooking.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customerBooking", customerBooking);
            model.addAttribute("concurrency", true);
            return new ModelAndView("customerbookings/edit");
        } else if (customerBooking.getVersion() != existingCustomerBooking.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customerBooking", existingCustomerBooking);
            model.addAttribute("concurrency", false);
            return new ModelAndView("customerbookings/edit");
        } else if (customerBooking.getVersion() != existingCustomerBooking.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            customerBooking.setVersion(existingCustomerBooking.getVersion());
        }
        CustomerBooking savedCustomerBooking = getCustomerBookingService().save(customerBooking);
        UriComponents showURI = getItemLink().to(CustomerBookingsItemThymeleafLinkFactory.SHOW).with("customerBooking", savedCustomerBooking.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute CustomerBooking customerBooking) {
        getCustomerBookingService().delete(customerBooking);
        return ResponseEntity.ok().build();
    }
}

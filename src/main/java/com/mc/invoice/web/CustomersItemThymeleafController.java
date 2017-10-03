package com.mc.invoice.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
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

import com.mc.invoice.domain.Customer;
import com.mc.invoice.service.api.CustomerService;

import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = CustomersItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Customer.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/customers/{customer}", name = "CustomersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomersItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerService customerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CustomersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CustomersItemThymeleafController(CustomerService customerService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCustomerService(customerService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CustomersItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerService
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
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
    public MethodLinkBuilderFactory<CustomersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CustomersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Customer
     */
    @ModelAttribute
    public Customer getCustomer(@PathVariable("customer") Long id, Locale locale, HttpMethod method) {
        Customer customer = null;
        if (HttpMethod.PUT.equals(method)) {
            customer = customerService.findOneForUpdate(id);
        } else {
            customer = customerService.findOne(id);
        }
        if (customer == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Customer", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }

        return customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder dataBinder) {
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
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Customer customer, Model model) {
        populateForm(model);
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param version
     * @param concurrencyControl
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Customer customer, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("customers/edit");
        }
        // Concurrency control
        Customer existingCustomer = getCustomerService().findOne(customer.getId());
        if (customer.getVersion() != existingCustomer.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customer", customer);
            model.addAttribute("concurrency", true);
            return new ModelAndView("customers/edit");
        } else if (customer.getVersion() != existingCustomer.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customer", existingCustomer);
            model.addAttribute("concurrency", false);
            return new ModelAndView("customers/edit");
        } else if (customer.getVersion() != existingCustomer.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            customer.setVersion(existingCustomer.getVersion());
        }
        Customer savedCustomer = getCustomerService().save(customer);
        UriComponents showURI = getItemLink().to(CustomersItemThymeleafLinkFactory.SHOW).with("customer", savedCustomer.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Customer customer) {
        getCustomerService().delete(customer);
        return ResponseEntity.ok().build();
    }
}

package com.mc.invoice.web;

import java.util.Map;

import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;

/**
 * = CustomerBookingsItemThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = CustomerBookingsItemThymeleafController.class)
@Component
public class CustomerBookingsItemThymeleafLinkFactory
		implements MethodLinkFactory<CustomerBookingsItemThymeleafController> {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String DELETE = "delete";

	public static final String EXPORTINVOICE = "generateinvoice";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String EDITFORM = "editForm";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String UPDATE = "update";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String SHOW = "show";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String SHOWINLINE = "showInline";

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<CustomerBookingsItemThymeleafController> getControllerClass() {
		return CustomerBookingsItemThymeleafController.class;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param methodName
	 * @param parameters
	 * @param pathVariables
	 * @return UriComponents
	 */
	public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
		if (methodName.equals(SHOW)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).show(null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(SHOWINLINE)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).showInline(null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EDITFORM)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).editForm(null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(UPDATE)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).update(null, null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(DELETE)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).delete(null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EXPORTINVOICE)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).generateinvoice(null, null, null))
					.buildAndExpand(pathVariables);
		}
		throw new IllegalArgumentException("Invalid method name: " + methodName);
	}
}

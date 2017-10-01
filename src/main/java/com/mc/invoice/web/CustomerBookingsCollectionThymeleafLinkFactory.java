package com.mc.invoice.web;

import java.util.Map;

import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;

/**
 * = CustomerBookingsCollectionThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = CustomerBookingsCollectionThymeleafController.class)
@Component
public class CustomerBookingsCollectionThymeleafLinkFactory
		implements MethodLinkFactory<CustomerBookingsCollectionThymeleafController> {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String SELECT2 = "select2";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CREATE = "create";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String EXPORTCSV = "exportCsv";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String DELETEBATCH = "deleteBatch";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String DATATABLES = "datatables";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String EXPORTPDF = "exportPdf";

	public static final String EXPORTINVOICE = "generateinvoice";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String LIST = "list";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CREATEFORM = "createForm";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String EXPORTXLS = "exportXls";

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<CustomerBookingsCollectionThymeleafController> getControllerClass() {
		return CustomerBookingsCollectionThymeleafController.class;
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
		if (methodName.equals(LIST)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).list(null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(DATATABLES)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).datatables(null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(SELECT2)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(
							SpringletsMvcUriComponentsBuilder.on(getControllerClass()).select2(null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(CREATE)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).create(null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(CREATEFORM)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).createForm(null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(DELETEBATCH)) {
			return SpringletsMvcUriComponentsBuilder
					.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).deleteBatch(null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EXPORTCSV)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).exportCsv(null, null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EXPORTPDF)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).exportPdf(null, null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EXPORTINVOICE)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).exportPdf(null, null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		if (methodName.equals(EXPORTXLS)) {
			return SpringletsMvcUriComponentsBuilder.fromMethodCall(
					SpringletsMvcUriComponentsBuilder.on(getControllerClass()).exportXls(null, null, null, null, null))
					.buildAndExpand(pathVariables);
		}
		throw new IllegalArgumentException("Invalid method name: " + methodName);
	}
}

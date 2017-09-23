package com.mc.invoice.web;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.service.api.AccomidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = AccomidationDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Accomidation.class)
public class AccomidationDeserializer extends JsonObjectDeserializer<Accomidation> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private AccomidationService accomidationService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param accomidationService
     * @param conversionService
     */
    @Autowired
    public AccomidationDeserializer(@Lazy AccomidationService accomidationService, ConversionService conversionService) {
        this.accomidationService = accomidationService;
        this.conversionService = conversionService;
    }
}

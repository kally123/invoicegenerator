package com.mc.invoice.web;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.service.api.AccomidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = AccomidationDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Accomidation.class)
@JsonComponent
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
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Accomidation
     * @throws IOException
     */
    public Accomidation deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Accomidation accomidation = accomidationService.findOne(id);
        if (accomidation == null) {
            throw new NotFoundException("Accomidation not found");
        }
        return accomidation;
    }
}

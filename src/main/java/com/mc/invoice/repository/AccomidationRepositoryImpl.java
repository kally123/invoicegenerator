package com.mc.invoice.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.Accomidation;

/**
 * = AccomidationRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = AccomidationRepositoryCustom.class)
public class AccomidationRepositoryImpl extends QueryDslRepositorySupportExt<Accomidation> {

    /**
     * TODO Auto-generated constructor documentation
     */
    AccomidationRepositoryImpl() {
        super(Accomidation.class);
    }
}
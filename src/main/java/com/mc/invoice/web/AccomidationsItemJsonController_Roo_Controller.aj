// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mc.invoice.web;

import com.mc.invoice.service.api.AccomidationService;
import com.mc.invoice.web.AccomidationsItemJsonController;

privileged aspect AccomidationsItemJsonController_Roo_Controller {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private AccomidationService AccomidationsItemJsonController.accomidationService;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return AccomidationService
     */
    public AccomidationService AccomidationsItemJsonController.getAccomidationService() {
        return accomidationService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param accomidationService
     */
    public void AccomidationsItemJsonController.setAccomidationService(AccomidationService accomidationService) {
        this.accomidationService = accomidationService;
    }
    
}

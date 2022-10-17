/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrow;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.borrow.FinishBorrowedForm;

/**
 *
 * @author ugur
 */
public final class FinishBorrowFormController extends ControllerImpl implements Initialize {

    private final FinishBorrowedForm finishBorrowedBookForm;
    public FinishBorrowFormController(FinishBorrowedForm finishBorrowedBookForm) {
        this.finishBorrowedBookForm = finishBorrowedBookForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

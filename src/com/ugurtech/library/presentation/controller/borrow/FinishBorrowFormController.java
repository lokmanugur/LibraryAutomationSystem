/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.borrow;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.borrow.FinishBorrowedForm;

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
        
    }

    @Override
    public void initController() {
        
    }

}

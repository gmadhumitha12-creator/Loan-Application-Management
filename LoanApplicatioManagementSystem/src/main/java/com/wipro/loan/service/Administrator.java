package com.wipro.loan.service;

import java.util.Date;
import java.util.List;

import com.wipro.loan.bean.LoanBean;
import com.wipro.loan.dao.LoanDAO;
import com.wipro.loan.util.InvalidInputException;

public class Administrator {

    LoanDAO dao = new LoanDAO();

    public String addRecord(LoanBean bean) {

        try {

            if (bean == null || bean.getApplicantName() == null ||
                bean.getLoanType() == null || bean.getApplicationDate() == null)
                throw new InvalidInputException();

            if (bean.getApplicantName().length() < 2)
                return "INVALID APPLICANT NAME";

            if (bean.getLoanAmount() <= 0)
                return "INVALID LOAN AMOUNT";

            if (bean.getLoanType().length() < 2)
                return "INVALID LOAN TYPE";

            if (dao.recordExists(bean.getApplicantName(), bean.getApplicationDate()))
                return "ALREADY EXISTS";

            String id = dao.generateLoanID(bean.getApplicantName(), bean.getApplicationDate());
            bean.setLoanId(id);

            return dao.createRecord(bean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public LoanBean viewRecord(String name, Date date) {
        return dao.fetchRecord(name, date);
    }

    public List<LoanBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}

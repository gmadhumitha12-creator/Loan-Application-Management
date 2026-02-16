package com.wipro.loan.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.loan.bean.LoanBean;
import com.wipro.loan.service.Administrator;

public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Administrator admin = new Administrator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        try {

            if (operation.equals("newRecord")) {

                LoanBean bean = new LoanBean();

                bean.setApplicantName(request.getParameter("applicantName"));
                bean.setLoanType(request.getParameter("loanType"));
                bean.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));

                Date date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("applicationDate"));

                bean.setApplicationDate(date);
                bean.setStatus(request.getParameter("status"));
                bean.setRemarks(request.getParameter("remarks"));

                String result = admin.addRecord(bean);

                if (result.equals("FAIL") || result.contains("INVALID") || result.equals("ALREADY EXISTS"))
                    response.sendRedirect("error.html");
                else
                    response.sendRedirect("success.html");
            }

            else if (operation.equals("viewRecord")) {

                String name = request.getParameter("applicantName");

                Date date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("applicationDate"));

                LoanBean bean = admin.viewRecord(name, date);

                request.setAttribute("bean", bean);

                RequestDispatcher rd = request.getRequestDispatcher("displayLoan.jsp");
                rd.forward(request, response);
            }

            else if (operation.equals("viewAllRecords")) {

                List<LoanBean> list = admin.viewAllRecords();

                request.setAttribute("list", list);

                RequestDispatcher rd = request.getRequestDispatcher("displayAllLoans.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}

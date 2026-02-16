package com.wipro.loan.dao;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import com.wipro.loan.bean.LoanBean;
import com.wipro.loan.util.DBUtil;

public class LoanDAO {

    public String createRecord(LoanBean bean) {

        String result = "FAIL";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO LOAN_TB VALUES(?,?,?,?,?,?,?)")) {

            ps.setString(1, bean.getLoanId());
            ps.setString(2, bean.getApplicantName());
            ps.setString(3, bean.getLoanType());
            ps.setDouble(4, bean.getLoanAmount());
            ps.setDate(5, new java.sql.Date(bean.getApplicationDate().getTime()));
            ps.setString(6, bean.getStatus());
            ps.setString(7, bean.getRemarks());

            int rows = ps.executeUpdate();

            if (rows > 0)
                result = bean.getLoanId();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean recordExists(String name, Date date) {

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT 1 FROM LOAN_TB WHERE APPLICANTNAME=? AND APPLICATIONDATE=?")) {

            ps.setString(1, name);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public String generateLoanID(String name, Date date) {

        try (Connection con = DBUtil.getDBConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT LOAN_SEQ.NEXTVAL FROM DUAL")) {

            int seq = 0;
            if (rs.next())
                seq = rs.getInt(1);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String datePart = sdf.format(date);

            String namePart = name.substring(0, 2).toUpperCase();

            return datePart + namePart + seq;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public LoanBean fetchRecord(String name, Date date) {

        LoanBean bean = null;

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM LOAN_TB WHERE APPLICANTNAME=? AND APPLICATIONDATE=?")) {

            ps.setString(1, name);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new LoanBean();
                bean.setLoanId(rs.getString("LOANID"));
                bean.setApplicantName(rs.getString("APPLICANTNAME"));
                bean.setLoanType(rs.getString("LOANTYPE"));
                bean.setLoanAmount(rs.getDouble("LOANAMOUNT"));
                bean.setApplicationDate(rs.getDate("APPLICATIONDATE"));
                bean.setStatus(rs.getString("STATUS"));
                bean.setRemarks(rs.getString("REMARKS"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public List<LoanBean> fetchAllRecords() {

        List<LoanBean> list = new ArrayList<>();

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM LOAN_TB");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LoanBean bean = new LoanBean();
                bean.setLoanId(rs.getString("LOANID"));
                bean.setApplicantName(rs.getString("APPLICANTNAME"));
                bean.setLoanType(rs.getString("LOANTYPE"));
                bean.setLoanAmount(rs.getDouble("LOANAMOUNT"));
                bean.setApplicationDate(rs.getDate("APPLICATIONDATE"));
                bean.setStatus(rs.getString("STATUS"));
                bean.setRemarks(rs.getString("REMARKS"));
                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

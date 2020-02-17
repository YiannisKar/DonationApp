package com.assignment.DonationApp.services;

import com.assignment.DonationApp.Donation;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DocumentService {

    boolean createPDF(List<Donation> donationList, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response);
}

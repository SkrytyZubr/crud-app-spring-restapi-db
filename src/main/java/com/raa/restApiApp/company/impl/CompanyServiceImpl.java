package com.raa.restApiApp.company.impl;

import com.raa.restApiApp.company.Company;
import com.raa.restApiApp.company.CompanyRepository;
import com.raa.restApiApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}

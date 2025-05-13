package com.raa.restApiApp.review.impl;

import com.raa.restApiApp.company.Company;
import com.raa.restApiApp.company.CompanyService;
import com.raa.restApiApp.review.Review;
import com.raa.restApiApp.review.ReviewRepository;
import com.raa.restApiApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }
}

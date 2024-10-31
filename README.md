## Features
- **Company Management**: Access detailed information about companies and their associated jobs and reviews.
- **Job Listings**: Fetch job listings along with relevant company details.
- **Review System**: Manage and retrieve reviews for companies.

## Architecture
This project is designed using a microservice architecture, consisting of the following services:
- **COMPANY_MS**: Manages company data and operations.
- **JOB_MS**: Handles job postings and related functionalities.
- **REVIEW_MS**: Manages reviews for different companies.

### Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework for building RESTful services.
- **Spring Cloud Eureka**: Service discovery.
- **OpenFeign**: Simplified interservice communication.
- **Relational Database**: For persistent data storage.

## API Endpoints

### Company Service
- **GET /COMPANY-SERVICE/company**: Retrieve all companies.
- **GET /COMPANY-SERVICE/company/{id}**: Get company details by ID.
- **POST /COMPANY-SERVICE/company**: Add a new company.
- **DELETE /COMPANY-SERVICE/company/{id}**: Delete a company by ID.

### Job Service
- **GET /JOB-SERVICE/jobs**: Retrieve all jobs.
- **GET /JOB-SERVICE/jobs/{jobid}**: Get job details by ID.
- **POST /JOB-SERVICE/jobs**: Add a new job.
- **PUT /JOB-SERVICE/jobs/{jobid}**: Update a job by ID.
- **DELETE /JOB-SERVICE/jobs/{id}**: Delete a job by ID.

### Review Service
- **GET /REVIEW-SERVICE/reviews**: Retrieve all reviews.
- **GET /REVIEW-SERVICE/reviews/{id}**: Get review details by ID.
- **POST /REVIEW-SERVICE/reviews**: Add a new review.
- **PUT /REVIEW-SERVICE/reviews/{id}**: Update a review by ID.
- **DELETE /REVIEW-SERVICE/reviews/{id}**: Delete a review by ID.

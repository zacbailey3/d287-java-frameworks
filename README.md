# Java Inventory Management Application

This project is a Spring Boot inventory management application for a retail storefront. It uses Java, Spring Boot, Spring Data JPA, Thymeleaf, H2, and JUnit to manage products, in-house parts, outsourced parts, inventory levels, and purchase behavior.

The application includes custom validation for minimum and maximum inventory rules, product pricing constraints, sample inventory bootstrapping, and a purchase flow that updates product inventory.

## Highlights

- Built MVC features using Spring Boot controllers, services, repositories, and Thymeleaf views
- Added product and part management for in-house and outsourced inventory
- Implemented custom validation for inventory minimums, maximums, and pricing rules
- Added purchase behavior that decrements product inventory
- Wrote unit tests for domain, repository, and service-layer behavior

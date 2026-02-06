# RevaStudio

# Media Manager Project
You and your team have been tasked with building a media management application for RevaStudio. The company has won a contract to rebuild the Chinook Media Company's web platform from the ground up, and this is where you come in. The Chinook Media Company plans on slowly migrating operations to the new platform, and they want to start with implementing core platform features.
## Application Features

### Client-Side MVP
Implement Angular for the following:
- Login/Logout feature for customers and employees
- Customers
    - dashboard to see tracks owned
        - album & artist data should also be available for tracks
        - only tracks purchased by the customer should be available to view at this time
    - feature to send a support ticket to the customer's assigned support employee and see responses
- Employees
    - dashboard to see sales metrics
        - what customers they have assisted with sales
        - what tracks were purchased
        - how much the customer was billed
    - feature to see and respond to customer support tickets
        - can close tickets

### Server-Side MVP
Implement Spring Boot to facilitate the Client-Side MVPs
- Should implement a RESTful API
- Authentication should be handled via JWT
- A Service layer should facilitate all business logic
- A Repository layer should facilitate all database interactions

## Persistence
An SQLite database should be used for persistence. Use the pre-provided [SQLite Chinook database](https://github.com/lerocha/chinook-database) and/or the startup script found in the ChinookDatabase/DataSources directory

## Entities
ERD for the database. Note you do not need an entity for every single table, just those necessary for the Client-Server MVPS.
![media manager erd](chinook-erd.png)


# Media Manager User Stories

## Customers

- As a customer, I want to log in and log out of my account so that I can securely access my media.
- As a customer, I want to view a dashboard showing all tracks I own, including album and artist information, so that I can browse my purchased music.
- As a customer, I want to send a support ticket to my assigned support employee so that I can get help with any issues.
- As a customer, I want to see responses to my support tickets so that I can stay updated on my requests.

## Employees

- As an employee, I want to log in and log out of my account so that I can securely access the system.
- As an employee, I want to view a dashboard with sales metrics so that I can track my performance.
- As an employee, I want to see which customers I have assisted with sales so that I can follow up if needed.
- As an employee, I want to see what tracks were purchased and how much the customer was billed so that I can understand sales details.
- As an employee, I want to view and respond to customer support tickets so that I can assist customers.
- As an employee, I want to close support tickets so that I can mark issues as resolved.

# MovieTicketBookingApplication

##  Desktop Application (JavaFX) for booking movies tickets.

## General Information
We built an application in JavaFX where the user can book movie tickets


## Specifications
The project includes the following files:

1. Main-Class

2. Customer class: to save and handle all customer-related data

3. Datasource class: two SQLlite database to save account information (name, emails, etc.) and booking details (Booking-ID, name of selected movie, total price, etc.)
  ![alt text](https://github.com/JannisMueller/Disaster-Response-Pipeline/blob/master/disaster_app_screenshot.png)

4. SelectMovie class (Stage 1): where the user chooses the movie he wants to watch, the date and number of tickets

5. LogInPage class (Stage 2): where the user is asked to sign in to continue the check out

6. CreateAccount class (Stage 3): if the user is not a customer yet, he needs to create an account 

7. Payment class (Stage 4): after sign in, the user is ask to fill in his payment information (only credit card payment) and finalize the payment

8. OrderConfirmation class (Stage 5): after the payment, the customer gets an overview over his order



# Installation
Clone the repository and open the files in an IDE of your choice.  

$ git clone https://github.com/JannisMueller/MovieTicketBookingApplication.git

# License 

[MIT License](https://opensource.org/licenses/MIT)


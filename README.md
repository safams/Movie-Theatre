# Movie Theatre Database

## Booking, deleting, and viewing reservations



The application is a **movie theatre database**, where you can see your account's current balance and booked tickets, book a  new seat and timing for a movie, 
delete a reservation, 
and look at current reservations. Just as a real movie theatre, there are multiple timings for each movie to choose from, and multiple seats 
to purchase as well. There is also a price for each seat bought that gets deducted from the account's balance, but no worries! (you can always 
reload your balance). It is suitable for all ages, for anyone who wants to buy a movie ticket online.

*I’ve really been missing going to the movies during quarantine, and this is a way to have fun with what I miss doing. I also liked how
interactive I can make this, where the options keep expanding as you choose a movie, then timings, then a seat.*




## **User Stories**

* *As a user*, I want to be able to **book** a new movie ticket and add it to my list of booked tickets

* *As a user*, I want to be able to **select seats** for a movie

* *As a user*, I want to be able to **select a timing** for a movie

* *As a user*, I want to be able to see my **current** booked tickets and account balance

* *As a user*, I want to be able to **reload** my account balance

* *As a user*, I want to be able to **delete** a booked ticket from my list of booked tickets

* *As a user*, I want to be able to **save** my current booked movie tickets to file

* *As a user*, I want to be able to **reload** my current booked movie tickets from file and add/remove tickets if desired

## Phase 4: Task 2
I chose to make my *Account* class more robust, by adding a *Negative Balance* exception when a negative amount
is loaded into the account balance. This exception involves the *reload* method in the *Account* class.
*


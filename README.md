# sore-rate-9569
Project Name

Tender Management System.

About Project 

This Tender Management System is a web application designed for companies to float tenders and vendors to bid on them. The system maintains an empaneled list of vendors who can bid for tenders. The company can view all the vendors and create new tenders. Vendors can view all current tenders, place bids, and view their bid history.

Project Logo

![tender](https://user-images.githubusercontent.com/99540875/235904254-ead3cbe0-7cd4-4d6e-b077-587728858bf6.jpg)


The system has two types of users:

Administrator: 

1.Can login

2.view all vendors

3.create new tenders

4.view all tenders

5.view all bids of a tender

6.and assign a tender to a vendor.


Vendor: 

1.Can SignUp With New Account

2.Can login

3.update account details

4.view all current tenders

5.place bids

6.view own bid history

7.search for a tender by tender id.


All above parts are working properly

Installation:

1: Clone the repository or download the zip file.

2: Import the project into a Java IDE.

3: Setup a database (MySQL) and configure the database connection in the persistence.xml file located in the src/main/resources/META-INF folder.


Technologies Used:

1: Java<br>
2: Hibernate ORM Framework<br>
3: MySQL Database<br>


Configuration:

The database connection can be configured in the persistence.xml file located in the src/main/resources/META-INF  folder.
The [username=>admin and password=>password] for the admin account are fixed and hardcoded in the code.

Usage:

1: Clone the repository or download the zip file.
2: Import the project into a Java IDE.
3: Login as either the Administrator or Vendor.
4: Perform the desired actions based on the user type.

Conclusion:

This Tender Management System provides a user-friendly interface for companies to float tenders and vendors to bid on them. It is a useful tool for streamlining the tendering process and improving efficiency.

ScreenShots->

MySql->
Database Name -> tenderCompany

Tables Inside tenderCompany

![tables](https://user-images.githubusercontent.com/99540875/236662358-a0ae66f8-26c3-4404-bf13-14a429055843.png)


Bid table Describe.

![bid desc](https://user-images.githubusercontent.com/99540875/236662649-de7483d3-97e8-4252-a35e-0b284511ddbd.png)


Tender table Describe.

![tender desc](https://user-images.githubusercontent.com/99540875/236662666-134e4caf-1df1-47b3-8687-5f164f1d4256.png)

Vendor table Describe.

![vendor desc](https://user-images.githubusercontent.com/99540875/236662685-5607e9bd-9273-43d1-b0f6-9d2a98ccd213.png)

Vendorbidsfortender Table Describe.

![vendorbidsfortenders desc](https://user-images.githubusercontent.com/99540875/236662704-16e37f44-a431-431a-8191-639228d652d8.png)




# deal provider system application 
## Spring boot
## mysql


1. Download the app
2. open with IDE of your choice.
3. run mysql server.
4. create a database name test.
5. run the application from IDE.
6. open http://localhost:8080/api/deals to list all the deals


To test the API use postman or other API tools
## Get all deals
http://localhost:8080/api/deals 

## delete a deal
http://localhost:8080/api/deals/3

## create a deal with post request and body
http://localhost:8080/api/deals with post 

body
[
        "dealCategory": "Rent",
        "dealPartner": "Theeb",
        "dealPrice": 80
 ]

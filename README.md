# Weather Forecast API
##### A simple and slight Java API implementation for weather forecasts
Operations and transactions provided by this API:

- Weather forecast by city code

## How To

### Start and Run app locally
After cloning source code to your local machine and at project's root dir:

`
$ mvn clean spring-boot:run
`

Application is started by embedded tomcat and your local server will look like that:
http://localhost:8080

### Running tests
There are unit tests for the services and integration tests for repositories using DBUnit
framework. To run those tests just execute:

`$ mvn test`

### Using RevoTransfer API
You can run and use the API locally as much as you can just sending REST requests 
to your local server or you can also use the server that has been deployed on Heroku at
https://revotransfer.herokuapp.com

#### API Endpoints
* Users
	* Get All 
	
		> `GET /users/all`
		
		* Response:
		
		```
		[{ 
		  "id" : 1,
		  "name" : "User 1"
		},
		{ 
		  "id" : 2,
		  "name" : "User 2"
		},
		 { 
		  "id" : 3,
		  "name" : "User 3"
		}]
		```
		
	* Find a given user by id 
	
  		> `GET /users/{id}`
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "name" : "User name"
		}
		```
		
		* Request to invalid user will return empty
		
	* Create a new user 
  		
		> ` POST /users/create` 
		
		* Body:
		
		```
		{ "name" : "User name" }
		```
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "name" : "User name"
		}
		```
	
		
	* Update a given user
	
  		> ` PUT /users/update` 
		
		* Body:
		
		```
		{ "name" : "New user name" }
		```
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "name" : "New user name"
		}
		```
		
		* Request to invalid user will do nothing and return empty
		
	* Delete an user
	
  		> ` DELETE /users/delete/{id}`
		
		* Response: 
		
    	`Status 200 OK`
		
		* Request to invalid user will return `400 Bad Request` status
		
* Accounts
 	* Find by id
	
		> `GET /accounts/{id}`
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "user" : {
		  		"id" : 1,
		  		"name" : "User 1"
		  },
		  "balance" : 100.00
		}
		```
		
		* Request to invalid account will return empty
		
 	* Find by user id
		
		> `GET /accounts/user/{userId}`
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "user" : {
		  		"id" : 1,
		  		"name" : "User 1"
		  },
		  "balance" : 999.99
		}
		```
		
		* Request passing an invalid user will return empty
		
 	* Create a new account
		
		> `POST /accounts/create` 
		
		* Body:
		
		```
		{ 
			"user" : {
				"id" : 1
			},
			"balance" : 200
		}
		```
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "user" : {
		  		"id" : 1,
		  		"name" : "User 1"
		  },
		  "balance" : 200
		}
		```
		
		
		* Request using negative balance will create account with ZERO funds
		
	
 	* Deposit money into account (E.g. User has 200 on his account)
	
		> ` PUT /accounts/deposit` 
	
		* Body:
		
		```
		{ 
			"account" : {
				"id" : 1
			},
			"amount" : 100
		}
		```
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "user" : {
		  		"id" : 1,
		  		"name" : "User 1"
		  },
		  "balance" : 300
		}
		```
		
 	* Withdraw money from account (E.g. User has $200 on his account)
	
		> ` PUT /accounts/withdraw` 
	
		* Body:
		
		```
		{ 
			"account" : {
				"id" : 1
			},
			"amount" : 100
		}
		```
		
		* Response:
		
		```
		{ 
		  "id" : 1,
		  "user" : {
		  		"id" : 1,
		  		"name" : "User 1"
		  },
		  "balance" : 100
		}
		```
		
		* If the account does not have enough funds, the service will return a `400 Bad Request` as status code

		
* Transfers
 	* Transfer money between accounts
	
		> `POST /transfers/send` (E.g. User 1 has $700 on his account and User 2 has $500, and User 1 transfers $200 to User 2)
		
		* Body:
		
		```
		{
			"amount" : 200,
			"from" : {
				"id" : 1
			},
			"to" : {
				"id" : 2
			}
		}
		```
		
		* Response:
		
		```
		{
			"id" : " 1,
			"amount" : 200,
			"from" : {
				"id" : 1,
				"user" : {
					"id" : 1,
					"name" : "User 1"
				},
				"balance" : 500
			},
			"to" : {
				"id" : 2,
				"user" : {
					"id" : 2,
					"name" : "User 2"
				},
				"balance" : 700
			},
			"timestamp" : ...
		}
		```
		
		* If sender does not have enough funds no changes will be applied
		
## Tech stack
1. Java 8
2. Maven
3. Jersey + JAX-RS
4. Hibernate
5. H2 Database
6. Apache Tomcat
7. DB Unit

# Test Service to Consume RESTful Service using User Input

## Basic Details
The service is written in `Java` and uses `Spring Web` to accept a user request for data. There will be a single endpoint the service will access which retrieves data from the [Project/REST Service Rest Countries](https://restcountries.com).

When a user wants to obtain basic details about a country, they will connect to the endpoint on `http://localhost:8080/countryDetails` and will pass the country name as a query parameter using the key/value pair `country={CountryName}`. Leaving the country query parameter blank will use United States as the default value.

Once the user connects to the endpoint, the endpoint will return the matching data in raw JSON format. Nothing else will occur, *for the time being*.
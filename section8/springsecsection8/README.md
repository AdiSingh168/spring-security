- Demo Spring Project having multiple controllers
- Changing the default security configurations and loading the user credentials from a PostgreSQL DB.
- We are storing the credentials in a PostgreSQL DB.
- Added a controller method so that Users can also be added in the DB.
- We have added a Custom Authentication Provider instead of using Spring's own default DAOAuthenticationProvider by
  implementing Spring's own Authentication Provider. In this currently, we are only doing normal password matching.
- Also, we have separated the prod and non-prod authentication processes based upon the spring boot's active profile.
  prod profile has authentication enabled for the restricted APIs. But non-prod doesn't have any authentication enabled,
  only the username needs to be a valid one.
- Added condition to accept only https requests for Prod environment, and accept only http requests for Non-Prod
  environments.
- Added CORS prevention from the browser by making the necessary changes in the security filter configuration bean.
- Added CSRF attack prevention by making the necessary changes in the security filter configuration bean.
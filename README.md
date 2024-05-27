# ts-sso-service-1727

## Features

* **Spring Security**: A powerful and highly customizable authentication and access-control framework.
* **OAuth JWT**: A secure and efficient way to handle authentication and authorization between different parties.
* **HttpOnly Cookie**: A cookie attribute that prevents client-side scripts from accessing the cookie.
* **AuthFilter**: A filter that intercepts requests and performs authentication and authorization checks.
* **MySQL Database**: A lightweight and fast in-memory database that supports SQL and JDBC.
* **Login Logout**: A mechanism to authenticate and de-authenticate users.
* **Refresh Token**: A technique to refresh the access token without requiring the user to re-authenticate.

OAuth2 and JWT serve different purposes. OAuth2 defines a protocol that specifies how tokens are transferred, while JWT defines a token format


## Concept : `Refresh token ` using `HttpOnly` Cookie and store it in database
1. Let's understand difference between `Access token` and `RefreshToken`

| Topics   | Access Token                                                              | Refresh Token                                                        |
|----------|---------------------------------------------------------------------------|----------------------------------------------------------------------|
| Purpose  | Used to access protected resources on behalf of a user. **Authorization** | Used to obtain a new access token after the previous one has expired |
| Duration | Short-lived (typically minutes to hours).                                 | Long-lived (typically days to weeks)                                 |
| Storage  | Generally returned as Response Object                                     | Must be secured, thus mostly using **HTTPOnly Cookie**               |

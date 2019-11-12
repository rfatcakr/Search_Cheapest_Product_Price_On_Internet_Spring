# Search_Cheapest_Product_Price_On_Internet_Spring

[Medium Article](https://medium.com/@rifatcakira/how-to-search-a-product-price-by-taking-a-picture-of-it-332a7a4ea30a)

Searching product price on the internet with Spring Boot

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. MogoDB - 4.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/rfatcakr/Search_Cheapest_Product_Price_On_Internet_Spring.git
```

**2. Change MongoDB username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.data.mongodb.host`, `spring.data.mongodb.port` and `spring.data.mongodb.database` as per your MongoDB installation

**3. Build and run the app using maven**

```bash
mvn package
java -jar target/springboot-mongodb-demo-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

# iLexCodingChallenge
#### Below are the detailed steps to guide you run the application locally

## 1. Prerequisites
#### 1.1 Make sure Java, Maven and Git are installed in your local enviroment
#### 1.2 Use your existing github account to fork this project

## 2. Create an empty folder and git clone this project
```
$ git clone git@github.com:VincentGeng/iLexCodingChallenge.git
```

## 3. Run iLexCodingChallenge project
```
$ cd iLexCodingChallenge
$ mvn spring-boot:run
```

## 4. Test API calls
#### Open another terminal to run below codes

### 4.1 Add user
```
> curl -v -X POST localhost:8080/users -H "Content-type:application/json" -d "{\"userName\":\"User 1\"}"
```

### 4.2 Add first product
```
> curl -v -X POST localhost:8080/products -H "Content-type:application/json" -d "{\"productName\":\"iPhone 12\",\"productDescription\":\"Smart Phone\",\"tagNames\":[\"phone\",\"electronic device\"]}"
```

### 4.3 Add second product
```
> curl -v -X POST localhost:8080/products -H "Content-type:application/json" -d "{\"productName\":\"MacBook Air\",\"productDescription\":\"MacBook Air with M1 chip\",\"tagNames\":[\"computer\",\"electronic device\"]}"
```

### 4.4 List products
```
> curl -v localhost:8080/products
```

### 4.5 Add order
```
> curl -v -X POST localhost:8080/orders -H "Content-type:application/json" -d "{\"products\":[{\"productId\":1,\"price\":\"1250.00\"},{\"productId\":2,\"price\":\"1439.00\"}],\"userId\":1}"
```

### 4.6 List orders
```
> curl -X GET "http://localhost:8080/orders?userId=1&fromDate=01/12/2020&toDate=01/01/2021"
```

## 5. Run unit test cases (make sure you are still under /iLexCodingChallenge folder)
```
$ mvn test
```

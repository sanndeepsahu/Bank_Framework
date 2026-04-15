////  WebDriver setup → BaseTest
////  Page Object → Routes/Payload
////  Reusable methods → Spec classes
//
////  given()  → prepare request
////  when()   → send request
////  then()   → validate response
//

//RestAssured
//👉 Entry point of API automation
//Just like:
//Selenium → WebDriver
//API → RestAssured
//
//given() → REQUEST SETUP
//        👉 This is where you prepare your request
//What happens here?
//Add headers
//Add body
//Add auth
//Add query params
//


//spec(RequestSpec.getRequestSpec())
//It loads reusable configuration like:
//
//log().all()
//    👉 Logs EVERYTHING about request:
//URL
//        Headers
//Body
//        Params
//👉 Example output:
//Request URI: https://jsonplaceholder.typicode.com/users
//Headers: Content-Type=application/json



//then() → RESPONSE VALIDATION
//👉 Now response is received
//You validate here
//🔹 .log().all()
//👉 Logs response:
//Status code
//Headers
//        Body



//
//given()      → prepare request
//spec()       → add base URI + headers
//log()        → print request
//
//when()       → send request
//get()        → call API
//
//then()       → validate response
//spec()       → apply validations
//log()        → print response
//
//extract()    → capture response
//response()   → store in variable
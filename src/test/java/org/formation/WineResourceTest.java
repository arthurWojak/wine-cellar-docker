package org.formation;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class WineResourceTest {
    @Test
    void testWinesEndpoint() {
        given()
          .when().get("/wines")
          .then()
             .statusCode(200);
    }

}
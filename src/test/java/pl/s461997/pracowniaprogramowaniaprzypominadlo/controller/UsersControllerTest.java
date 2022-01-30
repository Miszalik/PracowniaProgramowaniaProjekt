package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;

import javax.annotation.PostConstruct;

import java.util.HashSet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UsersControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAllUsers() {
        RestAssured.get(uri + "/users/")
                .then()
                .statusCode(200);
    }

    @Test
    void findUser() {
    }

    @Test
    void addUser() {
        Users user = new Users();
        user.setUsername("Sebek");
        user.setListname(new HashSet<>());

        given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(user)
                .post(uri + "/users/")
                .then()
                .statusCode(500);

        Users newUser = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(user)
                .post(uri + "/users/")
                .then()
                .statusCode(201)
                .extract().body().as(Users.class);

        assertNotNull(newUser);
        assertNotNull(newUser.getId());
    }

    @Test
    void deleteUser() {
        given()
                .pathParam("id", 300)
                .delete(uri + "/users/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }

    @Test
    void updateUser() {
    }

    @Test
    void exportData() {
    }

    @Test
    void importData() {
    }
}
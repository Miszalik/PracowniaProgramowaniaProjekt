package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Lists;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ListsControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAllLists() {
        RestAssured.get(uri + "/lists/")
                .then()
                .statusCode(200);
    }

    @Test
    void findList() {
    }

    @Test
    void addList() {
        Lists list = new Lists();
        list.setListname("Tostowe zadanie");

        Lists newList = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(list)
                .post(uri + "/lists/")
                .then()
                .statusCode(201)
                .extract().body().as(Lists.class);

        assertNotNull(newList);
        assertNotNull(newList.getId());
    }

    @Test
    void deleteList() {
        given()
                .pathParam("id", 30000)
                .delete(uri + "/lists/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }

    @Test
    void updateList() {
    }

    @Test
    void exportData() {
    }

    @Test
    void importData() {
    }
}
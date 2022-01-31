package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Tasks;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TasksControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAllTests() {
        RestAssured.get(uri + "/tasks/")
                .then()
                .statusCode(200);
    }

    @Test
    void findTask() {
    }

    @Test
    void addTask() {
        Tasks task = new Tasks();
        task.setTaskname("Tostowe zadanie");
        task.setDescription("Testowy opis");

        Tasks newTask = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(task)
                .post(uri + "/tasks/")
                .then()
                .statusCode(201)
                .extract().body().as(Tasks.class);

        assertNotNull(newTask);
        assertNotNull(newTask.getId());
    }

    @Test
    void deleteTask() {
        given()
                .pathParam("id", 30000)
                .delete(uri + "/tasks/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }

    @Test
    void updateTask() {
    }

    @Test
    void exportData() {
    }

    @Test
    void importData() {
    }
}
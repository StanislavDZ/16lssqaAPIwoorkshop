package reqres;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listenters.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class WorkShopTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";
    }

    @Test
    @DisplayName("Добавить товар 1 в корзину")
    void addJewelryToCart() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                //.cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("addproducttocart/catalog/14/1/1")
                .then()
                .log().all()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is(notNullValue()))
                .statusCode(200);
    }


    @Test
    @DisplayName("Добавить товар 2 в корзину")
    void addJewelry1ToCart() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                //.cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("addproducttocart/catalog/14/1/2")
                .then()
                .log().all()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is(notNullValue()))
                .statusCode(200);
    }

    @Test
    @DisplayName("Добавить товар в вишлист")
    void addJewelryToWishList() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                //.cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("addproducttocart/details/14/2")
                .then()
                .log().all()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                .body("updatetopwishlistsectionhtml", is(notNullValue()))
                .statusCode(200);
    }

}


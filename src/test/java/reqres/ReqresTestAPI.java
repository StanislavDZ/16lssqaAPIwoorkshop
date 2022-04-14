package reqres;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresTestAPI {

    @Test
    @DisplayName("Добавить товар в корзину")
    void addJewelryToCart() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/catalog/14/1/1")
                .then()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is(notNullValue()))
                .statusCode(200);
    }

    @Test
    @DisplayName("Добавить товар в вишлист")
    void addJewelryToWishList() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/14/2")
                .then()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                .body("updatetopwishlistsectionhtml", is(notNullValue()))
                .statusCode(200);
    }

}


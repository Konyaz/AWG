package tests;


import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AWGTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open students registration form", () -> {
            open("https://www.awg.ru/");
        });
        step(" Check Service", () -> {
            $(".animate .main-slider__title").shouldHave(text("Увеличим продажи и конверсию с помощью ускорения сайта"));
            $(byText("Услуги")).click();
            $(".page-title__title").shouldHave(text("Услуги"));



        });
    }
}
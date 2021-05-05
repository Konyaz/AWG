package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ShouldHave;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AWGTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open website", () -> {
            open("https://www.awg.ru/");
        });
       /*

            $(".animate .main-slider__title").shouldHave(text("Увеличим прибыль с омниканальной ИТ трансформацией"));

            */
             step(" Check Service", () -> {
            $(byText("Услуги")).click();
           // $(".page-title__title").shouldHave(text("Услуги"));
            $(".services__text").shouldHave(text("Мы ускоряем развитие бизнеса наших клиентов и выводим его на новый уровень с помощью информационных технологий (ИТ). Исходя из целей и проблем бизнеса, мы погружаемся в детали и помогаем найти решения, дающие быстрые и максимально эффективные результаты."));
        });
        step(" Check Download", () -> {
            Configuration.downloadsFolder = "./downloads";
            $(".footer__download-link").download();
            FileUtils.deleteDirectory(new File("./downloads"));
        });
    }
}
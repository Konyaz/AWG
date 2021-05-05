package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ShouldHave;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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


        //$(".animate .main-slider__title").shouldHave(text("Увеличим продажи и конверсию с помощью ускорения сайта"));


        step(" Check Service", () -> {
            $(byText("Услуги")).click();
            $(".page-title__title").shouldHave(text("Услуги"));
            $(".services__text").shouldHave(text("Мы ускоряем развитие бизнеса наших клиентов и выводим его на новый уровень с помощью информационных технологий (ИТ). Исходя из целей и проблем бизнеса, мы погружаемся в детали и помогаем найти решения, дающие быстрые и максимально эффективные результаты."));
        });
        step(" Check Contacts", () -> {
            $(byText("Контакты")).click();
            $(".contacts-info__phone").shouldHave(text("+7 495 278-07-08"));
            $(".contacts-info__email").shouldHave(text("info@awg.ru"));
        });
        step(" Check Download", () -> {
            Configuration.downloadsFolder = "./downloads";
            $(".footer__download-link").download();
            FileUtils.deleteDirectory(new File("./downloads"));
        });
        step(" Check language", () -> {
            $(".header-menu__lang").click();
            $(".main-services__title_white").shouldHave(text("Popular services,"));

        });
        step(" Check language", () -> {
            $(".main-slider__title").shouldHave(text("Увеличим продажи и конверсию с помощью ускорения сайта"));
        });
    }
}




package tests;


import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AWGTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open website", () -> {
            open("https://www.awg.ru/");
        });

        step(" Check Service", () -> {
            $(byText("Услуги")).click();
            $(".page-title__title").shouldHave(text("Услуги"));
            $(".services__text").shouldHave(text("Мы ускоряем развитие бизнеса наших клиентов и выводим его на новый уровень с помощью информационных технологий (ИТ)." +
                    " Исходя из целей и проблем бизнеса, мы погружаемся в детали и помогаем найти решения, дающие быстрые и максимально эффективные результаты."));
        });

        step(" Check Projects", () -> {
            $(byText("Проекты")).click();
            $(".filters-panel__search-button").click();
            $(byName("search")).val("Simple").pressEnter();
            $(".cases-item_hovered-big").click();
            $(".project__header-text").shouldHave(text("Поддержка и развитие интернет-магазина Simplewine.ru"));
        });

        step(" Check Clients", () -> {
            $(byText("Клиенты")).click();
            $(".clients__container").shouldHave(text("Желание понимать бизнес клиента, готовность развивать процессы в команде под его задачи," +
                    " гибкая методология разработки и особое внимание к качеству менеджмента — базовые принципы работы с нашими заказчиками."));
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
    }
}




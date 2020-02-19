package netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static netology.Data.methodTimestamp;
import static netology.Data.registration;


public class CardDeliveryTest {


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void cardHappyTest() {
        open("http://localhost:9999/");
        RegCardInfo myForm = registration.generateByCard("ru");
        Constants.MAIN_PAGE_TITLE.isDisplayed();
        Constants.CITY_FIELD.setValue(myForm.getCity());
        Constants.DATE_FIELD.click();
        Constants.CALENDAR.isDisplayed();
        long extendedTimestamp = methodTimestamp(Constants.FUTURE_DATE);
        String extended = String.valueOf(extendedTimestamp);
        $("tr.calendar__row  td.calendar__day[data-day=\"" + extended + "\"]").click();
        String date = Constants.DATE_FIELD.getText();
        Constants.NAME_FIELD.setValue(myForm.getFullName());
        Constants.PHONE_NUMBER_FIELD.setValue(myForm.getPhoneNumber());
        Constants.I_AGREE_CHECKBOX.click();
        Constants.CONFIRM_BUTTON.click();
        Constants.SUCCES_NOTIFY.waitUntil(Condition.visible, 15000);
        Constants.SUCCES_NOTIFY.shouldHave(text("Успешно!"));
        Constants.SUCCES_NOTIFY.shouldHave(text("Встреча успешно запланирована на " + date));
    }

    @Test
    void cardReplanDate() throws InterruptedException {
        open("http://localhost:9999/");
        RegCardInfo myForm = registration.generateByCard("ru");
        Constants.MAIN_PAGE_TITLE.isDisplayed();
        Constants.CITY_FIELD.setValue(myForm.getCity());
        Constants.DATE_FIELD.click();
        Constants.CALENDAR.isDisplayed();
        long extendedTimestamp = methodTimestamp(Constants.FUTURE_DATE);
        String extended = String.valueOf(extendedTimestamp);
        $("tr.calendar__row  td.calendar__day[data-day=\"" + extended + "\"]").click();
        String date = Constants.DATE_FIELD.getText();
        Constants.NAME_FIELD.setValue(myForm.getFullName());
        Constants.PHONE_NUMBER_FIELD.setValue(myForm.getPhoneNumber());
        Constants.I_AGREE_CHECKBOX.click();
        Constants.CONFIRM_BUTTON.click();
        Constants.SUCCES_NOTIFY.waitUntil(Condition.visible, 15000);
        Constants.SUCCES_NOTIFY.shouldHave(text("Успешно!"));
        Constants.SUCCES_NOTIFY.shouldHave(text("Встреча успешно запланирована на " + date));

        Constants.CONFIRM_BUTTON.click();
        Thread.sleep(2000);
        Constants.REPLAN_NOTIFY.waitUntil(visible, 15000);
        Constants.REPLAN_NOTIFY.shouldHave(text("Необходимо подтверждение"));
        Constants.REPLAN_NOTIFY.shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        Constants.REPLAN_BUTTON.isDisplayed();
    }
}
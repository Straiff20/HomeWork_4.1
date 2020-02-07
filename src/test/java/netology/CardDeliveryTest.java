package netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static netology.Data.Registration;
import static netology.Data.methodTimestamp;


public class CardDeliveryTest {


    // Доставка в Сочи, Тольяти не доступно - бага
    // Зинаида Артёмовна Кулакова (буква Ё)
    @Test
    void CardHappyTest() {
        open("http://localhost:9999/");
        RegCardInfo myForm = Registration.generateByCard("ru");
        Constants.mainTitle.isDisplayed();
        Constants.cityField.setValue(myForm.getCity());
        Constants.dateField.click();
        Constants.calendar.isDisplayed();
        long extendedTimestamp = methodTimestamp(Constants.future_date);
        String extended = String.valueOf(extendedTimestamp);
        $("tr.calendar__row  td.calendar__day[data-day=\"" + extended + "\"]").click();
        String date = Constants.dateField.getText();
        Constants.nameField.setValue(myForm.getFullName());
        Constants.phoneNumberField.setValue(myForm.getPhoneNumber());
        Constants.iAgreeCheckBox.click();
        Constants.confirmButton.click();
        Constants.succesNotify.waitUntil(Condition.visible, 15000);
        Constants.succesNotify.shouldHave(text("Успешно!"));
        Constants.succesNotify.shouldHave(text("Встреча успешно запланирована на " + date));
    }

    @Test
    void CardReplanDate() throws InterruptedException {
        open("http://localhost:9999/");
        RegCardInfo myForm = Registration.generateByCard("ru");
        Constants.mainTitle.isDisplayed();
        Constants.cityField.setValue(myForm.getCity());
        Constants.dateField.click();
        Constants.calendar.isDisplayed();
        long extendedTimestamp = methodTimestamp(Constants.future_date);
        String extended = String.valueOf(extendedTimestamp);
        $("tr.calendar__row  td.calendar__day[data-day=\"" + extended + "\"]").click();
        String date = Constants.dateField.getText();
        Constants.nameField.setValue(myForm.getFullName());
        Constants.phoneNumberField.setValue(myForm.getPhoneNumber());
        Constants.iAgreeCheckBox.click();
        Constants.confirmButton.click();
        Constants.succesNotify.waitUntil(Condition.visible, 15000);
        Constants.succesNotify.shouldHave(text("Успешно!"));
        Constants.succesNotify.shouldHave(text("Встреча успешно запланирована на " + date));

        Constants.confirmButton.click();
        Thread.sleep(2000);
        Constants.replanNotify.waitUntil(visible, 15000);
        Constants.replanNotify.shouldHave(text("Необходимо подтверждение"));
        Constants.replanNotify.shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        Constants.replanButton.isDisplayed();
    }
}
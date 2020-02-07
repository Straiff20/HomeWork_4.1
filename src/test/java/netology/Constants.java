package netology;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Constants {
    static final int future_date = 7;  //  через сколько дней запланировать доставку

    static final SelenideElement mainTitle = $(".heading");  //  Заголовок
    static final SelenideElement cityField = $("[placeholder=Город]");  //  поле ввода города
    static final SelenideElement dateField = $("[placeholder='Дата встречи']");  //  поле ввода даты
    static final SelenideElement calendar = $(".calendar[role=grid]");  //  всплывающий календарь
    static final SelenideElement nameField = $("[name=name]");  //  поле ввода имени
    static final SelenideElement phoneNumberField = $("[name=phone]");  //  поле ввода номера телефона
    static final SelenideElement iAgreeCheckBox = $("span.checkbox__box");  //  чекбокс для галочки "я согласен"
    static final SelenideElement confirmButton = $("span.button__text");  //  кнопка "Запланировать"
    static final SelenideElement succesNotify = $("[data-test-id='success-notification']");  //  popup окно с "Успешно!"
    static final SelenideElement replanNotify = $("[data-test-id='replan-notification']");
    static final SelenideElement replanButton = $("div.notification__content > button > span > span.button__text");
}
package netology;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Constants {
    public static final int future_date = 7;  //  через сколько дней

    static SelenideElement mainTitle = $(".heading");  //  Заголовок
    static SelenideElement cityField = $("[placeholder=Город]");  //  поле ввода города
    static SelenideElement dateField = $("[placeholder='Дата встречи']");  //  поле ввода даты
    static SelenideElement calendar = $(".calendar[role=grid]");  //  всплывающий календарь
    static SelenideElement nameField = $("[name=name]");  //  поле ввода имени
    static SelenideElement phoneNumberField = $("[name=phone]");  //  поле ввода номера телефона
    static SelenideElement iAgreeCheckBox = $("span.checkbox__box");  //  чекбокс для галочки "я согласен"
    static SelenideElement confirmButton = $("span.button__text");  //  кнопка "Запланировать"
    static SelenideElement succesNotify = $("[data-test-id='success-notification']");  //  popup окно с "Успешно!"
}
package netology;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Constants {
    static final int FUTURE_DATE = 7;  //  через сколько дней запланировать доставку

    static final SelenideElement MAIN_PAGE_TITLE = $(".heading");  //  Заголовок
    static final SelenideElement CITY_FIELD = $("[placeholder=Город]");  //  поле ввода города
    static final SelenideElement DATE_FIELD = $("[placeholder='Дата встречи']");  //  поле ввода даты
    static final SelenideElement CALENDAR = $(".calendar[role=grid]");  //  всплывающий календарь
    static final SelenideElement NAME_FIELD = $("[name=name]");  //  поле ввода имени
    static final SelenideElement PHONE_NUMBER_FIELD = $("[name=phone]");  //  поле ввода номера телефона
    static final SelenideElement I_AGREE_CHECKBOX = $("span.checkbox__box");  //  чекбокс для галочки "я согласен"
    static final SelenideElement CONFIRM_BUTTON = $("span.button__text");  //  кнопка "Запланировать"
    static final SelenideElement SUCCES_NOTIFY = $("[data-test-id='success-notification']");  //  popup окно с "Успешно!"
    static final SelenideElement REPLAN_NOTIFY = $("[data-test-id='replan-notification']");
    static final SelenideElement REPLAN_BUTTON = $("div.notification__content > button > span > span.button__text");
}
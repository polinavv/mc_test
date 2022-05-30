import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static steps.GenericSteps.*;

public class TextBoxTest extends BaseTest {
    private TextBoxPage textBoxPage;

    @Test
    @DisplayName("Валидация полей email и full name")
    //Предположим, что для поля имени установлено ограничение на ввод спецсимволов
    //(кроме - для двойных имен) и цифр
    public void fieldValidation() {
        textBoxPage = openPage(TextBoxPage.class);
        //берем значения из класса TestData и проверяем border-color элемента
        validateData(textBoxPage.getNameField(), "valid", "FULL_NAME");
        validateData(textBoxPage.getEmailField(), "invalid", "EMAIL");
        validateData(textBoxPage.getEmailField(), "valid", "EMAIL");
        validateData(textBoxPage.getNameField(), "invalid", "FULL_NAME");
    }

    @Test
    @DisplayName("Проверка ввода пустых полей")
    //Предположим, что ввод пустых полей не принимается
    public void checkEmptyFields() {
        textBoxPage = openPage(TextBoxPage.class);
        clickOnBtn(textBoxPage.getButton());
        elementDoesNotExist(textBoxPage.getOutputBlock());
        typeIntoElement(textBoxPage.getNameField(), " ");
        typeIntoElement(textBoxPage.getEmailField(), " ");
        typeIntoElement(textBoxPage.getCurAddressField(), " ");
        typeIntoElement(textBoxPage.getPerAddressField(), " ");
        clickOnBtn(textBoxPage.getButton());
        elementDoesNotExist(textBoxPage.getEmailResLabel());
        elementDoesNotExist(textBoxPage.getNameResLabel());
        elementDoesNotExist(textBoxPage.getCurAddressResLabel());
        elementDoesNotExist(textBoxPage.getPerAddressResLabel());
    }

    @Test
    @DisplayName("Проверка результата заполнения полей")
    public void checkResultFillingFields() {
        textBoxPage = openPage(TextBoxPage.class);
        typeIntoElement(textBoxPage.getNameField(), "text");
        typeIntoElement(textBoxPage.getEmailField(), "test@mail.com");
        typeIntoElement(textBoxPage.getCurAddressField(), "г. Москва");
        typeIntoElement(textBoxPage.getPerAddressField(), "г. Тула");
        elementEqualsText(textBoxPage.getNameField(), "text");
        elementEqualsText(textBoxPage.getEmailField(), "test@mail.com");
        elementEqualsText(textBoxPage.getCurAddressField(), "г. Москва");
        elementEqualsText(textBoxPage.getPerAddressField(), "г. Тула");
        clickOnBtn(textBoxPage.getButton());
        elementEqualsText(textBoxPage.getNameResLabel(), "Name:text");
        elementEqualsText(textBoxPage.getEmailResLabel(), "Email:test@mail.com");
        elementEqualsText(textBoxPage.getCurAddressResLabel(), "Current Address :г. Москва");
        elementEqualsText(textBoxPage.getPerAddressResLabel(), "Permananet Address :г. Тула");
    }

    @Test
    @DisplayName("Проверка максимально допустимого кол-ва символов")
    //Предположим, что поля должны иметь ограничения на кол-во символов
    //поле ввода адреса ограничено 500 символами
    //поле ввода email - 254 символа
    //поле ввода имени - 70 символов
    public void checkMaxFillingFields() {
        textBoxPage = openPage(TextBoxPage.class);
        typeIntoElementNumberOfCharset(textBoxPage.getNameField(), 71);
        typeIntoElementNumberOfCharset(textBoxPage.getCurAddressField(), 501);
        typeIntoElementNumberOfCharset(textBoxPage.getPerAddressField(), 501);
        typeIntoElement(textBoxPage.getEmailField(), generateEmail(255));
        clickOnBtn(textBoxPage.getButton());
        elementHasCssPropertyWithValue(textBoxPage.getNameField(), "border-color", "rgb(255, 0, 0)");
        elementHasCssPropertyWithValue(textBoxPage.getCurAddressField(), "border-color", "rgb(255, 0, 0)");
        elementHasCssPropertyWithValue(textBoxPage.getPerAddressField(), "border-color", "rgb(255, 0, 0)");
        elementHasCssPropertyWithValue(textBoxPage.getEmailField(), "border-color", "rgb(255, 0, 0)");
        elementDoesNotExist(textBoxPage.getOutputBlock());

        clearTextField(textBoxPage.getEmailField());
        clearTextField(textBoxPage.getCurAddressField());
        clearTextField(textBoxPage.getPerAddressField());
        clearTextField(textBoxPage.getNameField());
        typeIntoElementNumberOfCharset(textBoxPage.getNameField(), 70);
        typeIntoElementNumberOfCharset(textBoxPage.getCurAddressField(), 500);
        typeIntoElementNumberOfCharset(textBoxPage.getPerAddressField(), 500);
        typeIntoElement(textBoxPage.getEmailField(), generateEmail(254));
        clickOnBtn(textBoxPage.getButton());
        textMatchRegexp(textBoxPage.getNameResLabel(), "Name:.*");
        textMatchRegexp(textBoxPage.getEmailResLabel(), "Email:.*");
        textMatchRegexp(textBoxPage.getCurAddressResLabel(), "Current Address :.*");
        textMatchRegexp(textBoxPage.getPerAddressResLabel(), "Permananet Address :.*");
    }

    @Test
    @DisplayName("Проверка отображения элементов")
    public void checkDisplayElement() {
        textBoxPage = openPage(TextBoxPage.class);
        elementHasPropertyWithValue(textBoxPage.getNameField(), "placeholder", "Full Name");
        elementHasPropertyWithValue(textBoxPage.getEmailField(), "placeholder", "name@example.com");
        elementHasPropertyWithValue(textBoxPage.getCurAddressField(), "placeholder", "Current Address");
        elementEqualsText(textBoxPage.getButton(), "Submit");
        elementEqualsText(textBoxPage.getNameLabel(), "Full Name");
        elementEqualsText(textBoxPage.getEmailLabel(), "Email");
        elementEqualsText(textBoxPage.getPerAddressLabel(), "Permanent Address");
        elementEqualsText(textBoxPage.getCurAddressLabel(), "Current Address");
    }

    //Проверка заполнения обязательных полей
}

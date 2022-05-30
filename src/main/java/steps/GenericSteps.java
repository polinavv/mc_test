package steps;

import com.codeborne.selenide.SelenideElement;
import elements.Page;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Map;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static testData.TestData.invalidData;
import static testData.TestData.validData;

public class GenericSteps {
    private static final Logger log = Logger.getLogger(GenericSteps.class.getName());

    public static <T> T openPage(Class<T> pageClass) {
        String url = pageClass.getAnnotation(Page.class).url();
        log.info("###### navigate to " + url);
        return open(url, pageClass);
    }

    public static void typeIntoElement(SelenideElement element, String text) {
        element.shouldBe(visible).sendKeys(text);
        log.info("###### entered text '" + text + "' for element #'" + element.attr("id") + "with enter'");
    }

    public static void elementEqualsText(SelenideElement element, String expectedText) {
        element.shouldBe(visible);
        String actualText = element.getText();
        String actualValue = element.getValue();
        assertTrue(actualText.equals(expectedText) || actualValue.equals(expectedText),
                "Element text doesn't equal text '" + expectedText + "'.\nActual text is '" +
                        actualText + "'.\nActual value is '" + actualValue + "'.");
    }

    public static void clickOnBtn(SelenideElement element) {
        element.scrollTo().click();
    }

    public static void clearTextField(SelenideElement element) {
        log.info("###### clearing text for element #'" + element.attr("id") + "'");
        element.clear();
    }

    public static void elementHasCssPropertyWithValue(SelenideElement element, String cssProperty, String value) {
        element.shouldHave(cssValue(cssProperty, value));
    }

    public static void elementHasPropertyWithValue(SelenideElement element, String property, String value) {
        element.shouldHave(visible);
        assertTrue(element.attr(property).contains(value), "Element #" + element.attr("id")
                + " doesn't have '" + property + "' with value '" + value + "'");
    }

    public static void validateData(SelenideElement element, String option, String typeData) {
        Map<String, String> data = validData;
        if (option.equals("invalid")) {
            data = invalidData;
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (typeData.equals(entry.getValue())) {
                clearTextField(element);
                typeIntoElement(element, entry.getKey());
                clickOnBtn($("#submit"));
                if (option.equals("invalid")) {
                    elementHasCssPropertyWithValue(element, "border-color", "rgb(255, 0, 0)");
                } else {
                    elementHasCssPropertyWithValue(element, "border-color", "rgb(206, 212, 218)");
                }
            }
        }
    }

    public static void typeIntoElementNumberOfCharset(SelenideElement element, int lengthText) {
        typeIntoElement(element, RandomStringUtils.random(lengthText, true, false));
    }

    public static void textMatchRegexp(SelenideElement element, String regExp) {
        assertTrue(element.getText().matches(regExp) || element.getValue().matches(regExp),
                "Text of element '" + element.attr("id") + "' doesn't match regexp '" + regExp + "'");
    }

    public static String generateEmail(int lengthEmail) {
        return RandomStringUtils.random(lengthEmail - 10, true, true) + "@domain.ru";
    }

    public static void elementDoesNotExist(SelenideElement element) {
        if (element.isDisplayed()) {
            fail("Element '#" + element.attr("id") + "' exists on the page");
        }
    }

}

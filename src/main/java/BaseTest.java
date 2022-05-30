import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        WebDriverFactory.init();
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

}

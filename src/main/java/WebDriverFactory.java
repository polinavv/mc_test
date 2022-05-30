import com.codeborne.selenide.Configuration;

public class WebDriverFactory {
    public static void init() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }
}

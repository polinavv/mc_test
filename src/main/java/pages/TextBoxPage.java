package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Page;

import static com.codeborne.selenide.Selenide.$;

@Page(url = "/text-box")
public class TextBoxPage {
    private static final SelenideElement nameField = $("#userName");
    private static final SelenideElement emailField = $("#userEmail");
    private static final SelenideElement curAddressField = $("textarea#currentAddress");
    private static final SelenideElement perAddressField = $("textarea#permanentAddress");
    private static final SelenideElement button = $("#submit");

    private static final SelenideElement outputBlock = $("#output>div>p");
    private static final SelenideElement nameResLabel = $("#name");
    private static final SelenideElement emailResLabel = $("#email");
    private static final SelenideElement curAddressResLabel = $("p#currentAddress");
    private static final SelenideElement perAddressResLabel = $("p#permanentAddress");

    private static final SelenideElement nameLabel = $("#userName-label");
    private static final SelenideElement emailLabel = $("#userEmail-label");
    private static final SelenideElement curAddressLabel = $("#currentAddress-label");
    private static final SelenideElement perAddressLabel = $("#permanentAddress-label");

    public SelenideElement getNameField() {
        return nameField;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getCurAddressField() {
        return curAddressField;
    }

    public SelenideElement getPerAddressField() {
        return perAddressField;
    }

    public SelenideElement getButton() {
        return button;
    }

    public SelenideElement getCurAddressResLabel() {
        return curAddressResLabel;
    }

    public SelenideElement getPerAddressResLabel() {
        return perAddressResLabel;
    }

    public SelenideElement getEmailResLabel() {
        return emailResLabel;
    }

    public SelenideElement getNameResLabel() {
        return nameResLabel;
    }

    public SelenideElement getOutputBlock() {
        return outputBlock;
    }

    public SelenideElement getCurAddressLabel() {
        return curAddressLabel;
    }

    public SelenideElement getEmailLabel() {
        return emailLabel;
    }

    public SelenideElement getNameLabel() {
        return nameLabel;
    }

    public SelenideElement getPerAddressLabel() {
        return perAddressLabel;
    }
}

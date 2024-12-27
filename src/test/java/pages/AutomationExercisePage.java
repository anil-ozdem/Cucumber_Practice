package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.logging.XMLFormatter;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLink;

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement kayitSayfasindakiSignupButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement cinsiyetButonu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement daySelectBox;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement monthSelectBox;

    @FindBy(xpath = "//*[@id='years']")
    public WebElement yearSelectBox;

    @FindBy(xpath = "//*[@data-qa='first_name']")
    public WebElement kayitSayfasindakiFirstName;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement countrySelectBox;

    @FindBy(xpath = "//*[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedText;


}

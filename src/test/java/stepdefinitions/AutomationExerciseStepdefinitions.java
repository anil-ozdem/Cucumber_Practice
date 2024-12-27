package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExerciseStepdefinitions {
    AutomationExercisePage automationExercisePage = new AutomationExercisePage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String emailAdress = faker.internet().emailAddress();
    String password = faker.internet().password();

    @Given("kullanici test data dosyasinda verilen {string} anasayfaya gider")
    public void kullaniciTestDataDosyasindaVerilenAnasayfayaGider(String configIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configIstenenUrl));
    }

    @When("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        automationExercisePage.signUpLink.click();

    }
    @Then("new user signup bolumune bilgileri girer")
    public void user_create_an_account_bölümüne_email_adresi_girer() {
        automationExercisePage.signupName.sendKeys(firstName);
        automationExercisePage.signupEmail.sendKeys(emailAdress);

    }
    @Then("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        automationExercisePage.kayitSayfasindakiSignupButton.click();

    }
    @Then("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        automationExercisePage.cinsiyetButonu.click();
        automationExercisePage.passwordBox.sendKeys(password);
        Select monthsDdm = new Select(automationExercisePage.monthSelectBox);
        Select daysDdm = new Select(automationExercisePage.daySelectBox);
        Select yearsDdm = new Select(automationExercisePage.yearSelectBox);

        monthsDdm.selectByValue("5");
        daysDdm.selectByValue("10");
        yearsDdm.selectByValue("1995");

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        automationExercisePage.kayitSayfasindakiFirstName.sendKeys(firstName);
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).perform();

        Select countrySelectBox = new Select(automationExercisePage.countrySelectBox);
        countrySelectBox.selectByValue("Canada");

    }
    @Then("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
        automationExercisePage.createAccountButton.click();

    }
    @Then("hesap olustugunu test edin")
    public void hesap_olustugunu_test_edin() {
        //String expectedFinallyText = "Account Created!";
        Assertions.assertTrue(automationExercisePage.accountCreatedText.isDisplayed());

    }


}

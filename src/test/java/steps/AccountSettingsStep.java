package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.AccountSettings;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

public class AccountSettingsStep {

    AccountSettings page;

    public AccountSettingsStep() {
        page = new AccountSettings();
    }

    @Step("upload image to avatar image field")
    public void uploadImage() throws AWTException, URISyntaxException, InterruptedException {
        Allure.step("navigate to account settings");
        page.getAccountSettingButton().click();
        Allure.step("opening upload window");
        page.openUploadWindow();
        Allure.step("uploading a file");
        File file =
                new File(Objects.requireNonNull(ProjectSettingsStep.class.getClassLoader().getResource("R.jfif")).toURI());
        StringSelection str = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step("adding to username field incorrect characters")
    public void changeUsername() {
        page.getUsernameInput().sendKeys("\"");
    }

    @Step("checking is avatar image is set")
    public Boolean isImageOnAPage() {
        return !page.getImage().isEmpty();
    }

    @Step("send too many characters to first name input field")
    public void sendManyCharactersInFirstNameInput() {
        page.getFirstNameInput().sendKeys("kjbdskjbfkjdsnbfkjdsnfkjdnsjkfkjrbfkrekjhvbjkwbjkcbjvbkrbkjv");
    }
}

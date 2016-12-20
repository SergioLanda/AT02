package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.SettingsWorkspaceModel;
import org.fundacion.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David on 12/16/2016.
 */
public class SettingsWorkspacePage {

  WebDriver driver;
  WebDriverWait wait;

  public SettingsWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(name = SettingsWorkspaceModel.workspaceName)
  WebElement workspaceName;

  @FindBy(id = SettingsWorkspaceModel.deleteLink)
  WebElement deleteLink;

  @FindBy(name = SettingsWorkspaceModel.saveButton)
  WebElement saveButton;

  @FindBy(css = SettingsWorkspaceModel.cancel)
  WebElement cancel;

  @FindBy(id = SettingsWorkspaceModel.deleteButton)
  WebElement deleteButton;

  public void deleteWorkspace() {
    wait.until(ExpectedConditions.elementToBeClickable(deleteLink));
    deleteLink.click();

  }

  public HomePage confirmDeleteWorkspace(){
    wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    deleteButton.click();
    return new HomePage(driver);
  }
}
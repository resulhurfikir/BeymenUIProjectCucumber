package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

   @After
   public void after(Scenario scenario){

       ExcelUtility.writeDataExcel("src/test/java/Utilities/resource/ScenarioStatus.xlsx",
               scenario, GWD.threadBrowserGet());

       if (scenario.isFailed()){
           TakesScreenshot ts=(TakesScreenshot) GWD.getDriver();
           final byte[] ssInMemory=ts.getScreenshotAs(OutputType.BYTES);
           scenario.attach(ssInMemory, "image/png","screenshot name");
       }
       GWD.quitDriver();
   }
}
package foradacaixa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Utils {
	public static void logPrint(String strLog) {
		ExtentTest extentTest = TestRule.getExtentTest();
		try {
			efetuarPrintTela(strLog);
			extentTest.log(Status.INFO, strLog,
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									System.getProperty("user.dir") + "/src/test/resources/report/" + strLog + ".png")
							.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void efetuarPrintTela(String strLog) {
		File scrFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(
					"C:/Users/ruehlein/eclipse-workspace/foradacaixa/src/test/resources/report/" + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logPass(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.PASS, strMensagem);
	}

	public static void logFail(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.FAIL, strMensagem);
	}
}

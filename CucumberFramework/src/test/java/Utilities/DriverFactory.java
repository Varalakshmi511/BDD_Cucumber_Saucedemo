package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

        private static WebDriver driver;

        public static WebDriver initDriver(String browser) {

                    if (browser.equalsIgnoreCase("chrome")) {

                        WebDriverManager.chromedriver().setup();

                        ChromeOptions options = new ChromeOptions();

                        // 🔹 Disable password manager & notifications
                        Map<String, Object> prefs = new HashMap<>();
                        prefs.put("credentials_enable_service", false);
                        prefs.put("profile.password_manager_enabled", false);
                        prefs.put("profile.default_content_setting_values.notifications", 2);

                        options.setExperimentalOption("prefs", prefs);

                        // 🔥 CRITICAL OPTIONS
                        options.addArguments("--incognito");   // ✅ avoids login popup
                        options.addArguments("--disable-save-password-bubble");
                        options.addArguments("--disable-notifications");
                        options.addArguments("--disable-infobars");
                        options.addArguments("--disable-extensions");
                        options.addArguments("--disable-blink-features=AutomationControlled");

                        driver = new ChromeDriver(options);

                    } else if (browser.equalsIgnoreCase("firefox")) {

                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();

                    } else {
                        throw new RuntimeException("Unsupported browser: " + browser);
                    }

                    driver.manage().window().maximize();
                    return driver;
                }

                public static WebDriver getDriver() {
                    return driver;
                }
            }


            /*WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // 🔹 Disable password manager
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);

            options.setExperimentalOption("prefs", prefs);

            // 🔥 THESE ARE CRITICAL
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--incognito");   // 🔑 VERY IMPORTANT

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            return driver;
        }

        public static WebDriver getDriver() {
            return driver;
        }*/



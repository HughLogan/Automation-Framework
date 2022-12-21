package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class WebDriverManager {

    final static String userDir = System.getProperty("user.dir");

    public static void main(String[] args) {
        System.out.print("Enter a number to select browser\n");
        System.out.println("Enter 1 for Chrome and 2 for Firefox");
        String osName = System.getProperty("os.name");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (osName.equalsIgnoreCase("Mac OS X")) {
            switch (a) {
                case 1:
                    Ch1run();
                    break;
                case 2:
                    firun();
                    break;
                default:
                    run();
            }
        } else {
            switch (a) {
                case 1:
                    ChWinrun();
                    break;
                case 2:
                    fiWinrun();
                    break;
                default:
                    run();
            }
        }
    }


    public static void Ch1run() {

        System.setProperty("webdriver.chrome.driver", userDir + "/src/main/resources/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://mars.nasa.gov/insight/");
        chrome.manage().window().maximize();
        chrome.quit();
        System.out.println();
    }

    public static void ChWinrun() {

        System.setProperty("webdriver.chrome.driver", userDir + "/src/main/resources/chromedriver.exe");
        WebDriver winChrome = new ChromeDriver();
        winChrome.get("https://mars.nasa.gov/insight/");
        winChrome.manage().window().maximize();
        //winChrome.quit();
        System.out.println();
    }

    public static void firun() {

        System.setProperty("webdriver.gecko.driver", userDir + "/src/main/resources/geckodriver");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://mars.nasa.gov/insight/");
        firefox.manage().window().maximize();
        firefox.quit();
        System.out.println();
    }

    public static void fiWinrun() {

        System.setProperty("webdriver.gecko.driver", userDir + "/src/main/resources/wingeckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://mars.nasa.gov/insight/");
        firefox.manage().window().maximize();
        firefox.quit();
        System.out.println();
    }

    public static void run() {

        WebDriver safari = new SafariDriver();
        safari.get("https://mars.nasa.gov/insight/");
        safari.manage().window().maximize();
        safari.quit();
        System.out.println();
    }
}
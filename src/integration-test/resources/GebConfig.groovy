import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver

environments {

    remote {

        //dev is hostname of the machine where the code is running.
        //aqui está o ip do host, esse mesmo ip tem que está configurado para ser o endereço de retorno
        //criar no docker compose um extra_hosts para esse dominio
        baseUrl = "http://localhost:8080/" //ip do host

        driver = {
            //def url = new URL("http://selenium-hub:4444")
            //endereço do hub
            def url = new URL("http://localhost:4444")


            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPlatformName("Linux")
            new RemoteWebDriver(url, firefoxOptions);
        }
    }


    // run via “./gradlew -Dgeb.env=chrome iT”
    chrome {
        driver = { new ChromeDriver() }
    }

    // run via “./gradlew -Dgeb.env=chromeHeadless iT”
    chromeHeadless {
        driver = {
            ChromeOptions o = new ChromeOptions()
            o.addArguments('headless')
            new ChromeDriver(o)
        }
    }

    // run via “./gradlew -Dgeb.env=firefox iT”
    firefox {
        driver = { new FirefoxDriver() }
    }
}

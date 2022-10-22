package com.fernando

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.springframework.boot.test.context.SpringBootTest

@Integration
@Rollback
//Without this annotation it works
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LoginSpec extends GebSpec {

    def cleanupSpec() {
        //driver.quit()
    }

    void 'login'() {
        when: 'Login is corret'
            go '/login'
            sleep(20000l)
            $("input[name='username']").value '123'
            $("input[name='password']").value '123'
            $('#button').click()
            sleep(5000l)
        then: 'The title is correct'
            driver.pageSource == '<html><head></head><body>Logged</body></html>'
            driver.quit()
    }
}

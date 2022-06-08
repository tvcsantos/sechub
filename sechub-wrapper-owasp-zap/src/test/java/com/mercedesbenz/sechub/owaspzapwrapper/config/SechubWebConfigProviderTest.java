// SPDX-License-Identifier: MIT
package com.mercedesbenz.sechub.owaspzapwrapper.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mercedesbenz.sechub.commons.model.SecHubWebScanConfiguration;
import com.mercedesbenz.sechub.commons.model.login.BasicLoginConfiguration;
import com.mercedesbenz.sechub.commons.model.login.WebLoginConfiguration;
import com.mercedesbenz.sechub.owaspzapwrapper.cli.MustExitRuntimeException;

class SechubWebConfigProviderTest {

    private SechubWebConfigProvider providerToTest;

    @BeforeEach
    void beforeEach() {
        providerToTest = new SechubWebConfigProvider();
    }

    @Test
    void get_sechub_web_config_by_sechub_file_works_when_file_can_be_read() {
        /* prepare */
        File testFile = new File("src/test/resources/sechub-config-examples/basic-auth.json");

        /* execute */
        SecHubWebScanConfiguration sechubWebConfig = providerToTest.getSecHubWebConfiguration(testFile);

        /* test */
        assertEquals(sechubWebConfig.getUri().toString(), "https://127.0.0.1:8080");
        assertTrue(sechubWebConfig.getLogin().isPresent());

        WebLoginConfiguration webLoginConfiguration = sechubWebConfig.getLogin().get();
        assertEquals(webLoginConfiguration.getUrl().toExternalForm(), "https://127.0.0.1:8080/login");
        assertTrue(webLoginConfiguration.getBasic().isPresent());

        BasicLoginConfiguration basicLoginConfiguration = webLoginConfiguration.getBasic().get();
        assertEquals(basicLoginConfiguration.getRealm().get(), "realm");

        String user = new String(basicLoginConfiguration.getUser());
        assertEquals(user, "user");

        String password = new String(basicLoginConfiguration.getPassword());
        assertEquals(password, "password");
    }

    @Test
    void get_sechub_web_config_by_sechub_file_throws_mustexitruntimeexception() {
        /* prepare */
        File testFile = new File("not-existing-file");

        /* execute + test */
        assertThrows(MustExitRuntimeException.class, () -> providerToTest.getSecHubWebConfiguration(testFile));

    }

}
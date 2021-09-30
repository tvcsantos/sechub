// SPDX-License-Identifier: MIT
package com.daimler.sechub.integrationtest.scenario6;

import static com.daimler.sechub.integrationtest.api.TestAPI.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daimler.sechub.integrationtest.api.IntegrationTestSetup;
import com.daimler.sechub.integrationtest.api.PDSIntTestProductIdentifier;
import com.daimler.sechub.integrationtest.internal.IntegrationTestDefaultExecutorConfigurations;

/**
 * Integration test directly using REST API of integration test PDS (means
 * without sechub). The test will inspect stream data of current output and
 * error streams.
 * 
 * @author Albert Tregnaghi
 *
 */
public class DirectPDSAPIJobStreamDataScenario6IntTest {

    private static final Logger LOG = LoggerFactory.getLogger(DirectPDSAPIJobStreamDataScenario6IntTest.class);

    @Rule
    public IntegrationTestSetup setup = IntegrationTestSetup.forScenario(Scenario6.class);

    @Rule
    public Timeout timeOut = Timeout.seconds(6000);

    @Test
    public void pds_admin_fetch_job_data_streams_for_given_pds_job_uuids() {
        /* @formatter:off */
        /* prepare */
        
        UUID sechubJobUUID = UUID.randomUUID();
        
        Map<String, String> customParameters = new HashMap<>();
        // we use variant f, which does lazy stream handling, see IntegrationTestDefaultProfiles#PROFILE_5_PDS_CODESCAN_LAZY_STREAMS javadoc 
        customParameters.put(IntegrationTestDefaultExecutorConfigurations.JOBPARAM_PDS_KEY_FOR_VARIANTNAME,IntegrationTestDefaultExecutorConfigurations.PDS_CODESCAN_VARIANT_F);
        
        String createResult = asPDSUser(PDS_ADMIN).createJobFor(sechubJobUUID, PDSIntTestProductIdentifier.PDS_INTTEST_CODESCAN, customParameters);
        UUID pdsJobUUID = assertPDSJobCreateResult(createResult).hasJobUUID().getJobUUID();
        asPDSUser(PDS_TECH_USER).
            upload(pdsJobUUID, "sourcecode.zip", "pds/codescan/upload/zipfile_contains_inttest_codescan_with_critical.zip").
            markJobAsReadyToStart(pdsJobUUID);
        /* @formatter:on */

        Set<String> errorTextSet = new LinkedHashSet<>();
        Set<String> outputTextSet = new LinkedHashSet<>();

        String lastOutput = null;
        String lastError = null;

        /* execute */
        boolean ended = false;
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            LOG.info("Fetching last output and last error for PDS job:{}", pdsJobUUID);

            lastOutput = asPDSUser(PDS_ADMIN).getJobOutputStreamText(pdsJobUUID);
            lastError = asPDSUser(PDS_ADMIN).getJobErrorStreamText(pdsJobUUID);

            if (lastOutput == null) { // when body is empty, happens when job has not yet been started
                LOG.info("No output data found for job:{}", pdsJobUUID);
                continue;
            } else if (lastError == null) { // when body is empty, happens when job has not yet been started
                LOG.info("No error data found for job:{}", pdsJobUUID);
                continue;
            } else {

                if (outputTextSet.add(lastOutput)) {
                    LOG.info("Found new output:\n{}", lastOutput);
                } else {
                    LOG.info("Found old output");
                }

                if (errorTextSet.add(lastError)) {
                    LOG.info("Found new error:\n{}", lastError);

                } else {
                    LOG.info("Found old error");
                }

                ended = lastOutput.trim().endsWith("WORKING3") && lastError.trim().endsWith("ERRORS3");
            }

        } while (!ended);

        /* test */
        assertEquals(4, outputTextSet.size());
        assertEquals(4, errorTextSet.size());

        Iterator<String> outIt = outputTextSet.iterator();
        Iterator<String> errIt = errorTextSet.iterator();

        assertNextEndsWith(outIt, "STARTING");
        assertNextEndsWith(outIt, "WORKING1");
        assertNextEndsWith(outIt, "WORKING2");
        assertNextEndsWith(outIt, "WORKING3");

        assertNextEndsWith(errIt, "NO-PROBLEMS");
        assertNextEndsWith(errIt, "ERRORS1");
        assertNextEndsWith(errIt, "ERRORS2");
        assertNextEndsWith(errIt, "ERRORS3");

    }

    private void assertNextEndsWith(Iterator<String> it, String expectedEnd) {
        int maxLength = 30;
        String next = it.next().trim(); // we trim to get rid of the last new line...
        if (!next.endsWith(expectedEnd)) {
            String show = next;
            int length = show.length();
            if (length > maxLength) {
                show = next.substring(length - maxLength - 1, length);
            }
            fail("expected to end with:\n'" + expectedEnd + "'\n, but was:\n...'" + show + "'");
        }
    }

}

// SPDX-License-Identifier: MIT
package com.mercedesbenz.sechub.domain.schedule;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.mercedesbenz.sechub.domain.schedule.access.ScheduleUserAccessToProjectValidationService;
import com.mercedesbenz.sechub.domain.schedule.config.SchedulerProjectConfigService;
import com.mercedesbenz.sechub.domain.schedule.job.ScheduleSecHubJob;
import com.mercedesbenz.sechub.domain.schedule.job.SecHubJobRepository;
import com.mercedesbenz.sechub.domain.schedule.whitelist.ProjectWhiteListSecHubConfigurationValidationService;
import com.mercedesbenz.sechub.sharedkernel.configuration.SecHubConfiguration;
import com.mercedesbenz.sechub.sharedkernel.error.ForbiddenException;
import com.mercedesbenz.sechub.sharedkernel.error.NotFoundException;
import com.mercedesbenz.sechub.sharedkernel.validation.AssertValidation;
import com.mercedesbenz.sechub.sharedkernel.validation.ProjectIdValidation;

import jakarta.validation.Valid;

@Service
public class ScheduleAssertService {

    @Autowired
    private SecHubJobRepository jobRepository;

    @Autowired
    ScheduleUserAccessToProjectValidationService userAccessValidation;

    @Autowired
    ProjectWhiteListSecHubConfigurationValidationService executionIsInWhiteListValidation;

    @Lazy
    @Autowired
    SchedulerProjectConfigService projectConfigService;

    @Autowired
    ProjectIdValidation projectIdValidation;

    /**
     * Assert current logged in user has access to project
     *
     * @param projectId
     */
    public void assertUserHasAccessToProject(String projectId) {
        userAccessValidation.assertUserHasAccessToProject(projectId);
    }

    /**
     * Asserts execution is allowed for given configuration
     *
     * @param configuration
     */
    public void assertExecutionAllowed(@Valid SecHubConfiguration configuration) {
        executionIsInWhiteListValidation.assertAllowedForProject(configuration);
    }

    /**
     * Asserts a job is existing and returns the job
     *
     * @param projectId
     * @param jobUUID
     * @return job, never <code>null</code>
     */
    public ScheduleSecHubJob assertJob(String projectId, UUID jobUUID) {
        Optional<ScheduleSecHubJob> secHubJob = jobRepository.findForProject(projectId, jobUUID);
        if (!secHubJob.isPresent()) {
            // we say "... or you have no access - just to obfuscate... so it's not clear to
            // malicious actors they got a target...
            throw new NotFoundException("Job does not exist, or you have no access.");
        }
        return secHubJob.get();
    }

    public void assertProjectIdValid(String projectId) {
        AssertValidation.assertValid(projectId, projectIdValidation);
    }

    public void assertProjectAllowsReadAccess(String projectId) {
        if (!projectConfigService.isReadAllowed(projectId)) {
            throw new ForbiddenException("Project " + projectId + " does currently not allow read access.");
        }
    }

    public void assertProjectAllowsWriteAccess(String projectId) {
        if (!projectConfigService.isWriteAllowed(projectId)) {
            throw new ForbiddenException("Project " + projectId + " does currently not allow write access.");
        }
    }

}

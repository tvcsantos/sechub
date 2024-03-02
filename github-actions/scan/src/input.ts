// SPDX-License-Identifier: MIT

import * as core from '@actions/core';

export const configPath = core.getInput('config-path') || null;
export const url = core.getInput('url') || null;
export const apiToken = core.getInput('api-token') || null;
export const user = core.getInput('user') || null;
export const projectName = core.getInput('project-name') || null;
export const sechubCLIVersion = core.getInput('version');
export const debug = getDebug();
export const includeFolders = core.getInput('include-folders') || null;
export const excludeFolders = core.getInput('exclude-folders') || null;
export const reportFormat = core.getInput('report-format') || null;
export const failJobOnFindings = core.getBooleanInput('fail-job-with-findings');

function getDebug(): boolean | null {
    const debug = core.getInput('debug')?.toLowerCase()?.trim() || null;
    if (debug === null) return null;
    return debug === 'true';
}

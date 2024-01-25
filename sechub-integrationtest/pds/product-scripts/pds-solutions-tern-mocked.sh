#!/bin/bash 
# SPDX-License-Identifier: MIT

source ./../sechub-integrationtest/pds/product-scripts/shared-functions.sh
echo "Current directory:"
pwd

echo "PDS solutions TERN mock starting"
cp "./../sechub-pds-solutions/tern/docker/mocks/sechub-test-alpine.spdx.json" "$PDS_JOB_RESULT_FILE"

warnMessage "mocked result"
infoMessage "product:tern"
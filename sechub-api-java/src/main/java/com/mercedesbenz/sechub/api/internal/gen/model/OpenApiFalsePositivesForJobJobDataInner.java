// SPDX-License-Identifier: MIT
/*
 * SecHub API
 * SecHub API description
 *
 * The version of the OpenAPI document: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.mercedesbenz.sechub.api.internal.gen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * OpenApiFalsePositivesForJobJobDataInner
 */
@JsonPropertyOrder({ OpenApiFalsePositivesForJobJobDataInner.JSON_PROPERTY_JOB_U_U_I_D, OpenApiFalsePositivesForJobJobDataInner.JSON_PROPERTY_FINDING_ID,
        OpenApiFalsePositivesForJobJobDataInner.JSON_PROPERTY_COMMENT })

public class OpenApiFalsePositivesForJobJobDataInner implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_JOB_U_U_I_D = "jobUUID";
    private String jobUUID;

    public static final String JSON_PROPERTY_FINDING_ID = "findingId";
    private BigDecimal findingId;

    public static final String JSON_PROPERTY_COMMENT = "comment";
    private String comment;

    public OpenApiFalsePositivesForJobJobDataInner() {
    }

    public OpenApiFalsePositivesForJobJobDataInner jobUUID(String jobUUID) {
        this.jobUUID = jobUUID;
        return this;
    }

    /**
     * SecHub job uuid where finding was
     *
     * @return jobUUID
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOB_U_U_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getJobUUID() {
        return jobUUID;
    }

    @JsonProperty(JSON_PROPERTY_JOB_U_U_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJobUUID(String jobUUID) {
        this.jobUUID = jobUUID;
    }

    public OpenApiFalsePositivesForJobJobDataInner findingId(BigDecimal findingId) {
        this.findingId = findingId;
        return this;
    }

    /**
     * SecHub finding identifier - identifies problem inside the job which shall be
     * markeda as a false positive. *ATTENTION*: at the moment only code scan false
     * positive handling is supported. Infra and web scan findings will lead to a
     * non accepted error!
     *
     * @return findingId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FINDING_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getFindingId() {
        return findingId;
    }

    @JsonProperty(JSON_PROPERTY_FINDING_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFindingId(BigDecimal findingId) {
        this.findingId = findingId;
    }

    public OpenApiFalsePositivesForJobJobDataInner comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * A comment describing why this is a false positive
     *
     * @return comment
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getComment() {
        return comment;
    }

    @JsonProperty(JSON_PROPERTY_COMMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Return true if this FalsePositivesForJob_jobData_inner object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OpenApiFalsePositivesForJobJobDataInner falsePositivesForJobJobDataInner = (OpenApiFalsePositivesForJobJobDataInner) o;
        return Objects.equals(jobUUID, falsePositivesForJobJobDataInner.jobUUID) && Objects.equals(findingId, falsePositivesForJobJobDataInner.findingId)
                && Objects.equals(comment, falsePositivesForJobJobDataInner.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobUUID, findingId, comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenApiFalsePositivesForJobJobDataInner {\n");
        sb.append("    jobUUID: ").append(toIndentedString(jobUUID)).append("\n");
        sb.append("    findingId: ").append(toIndentedString(findingId)).append("\n");
        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Convert the instance into URL query string.
     *
     * @return URL query string
     */
    public String toUrlQueryString() {
        return toUrlQueryString(null);
    }

    /**
     * Convert the instance into URL query string.
     *
     * @param prefix prefix of the query string
     * @return URL query string
     */
    public String toUrlQueryString(String prefix) {
        String suffix = "";
        String containerSuffix = "";
        String containerPrefix = "";
        if (prefix == null) {
            // style=form, explode=true, e.g. /pet?name=cat&type=manx
            prefix = "";
        } else {
            // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
            prefix = prefix + "[";
            suffix = "]";
            containerSuffix = "]";
            containerPrefix = "[";
        }

        StringJoiner joiner = new StringJoiner("&");

        // add `jobUUID` to the URL query string
        if (getJobUUID() != null) {
            joiner.add(String.format("%sjobUUID%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getJobUUID()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `findingId` to the URL query string
        if (getFindingId() != null) {
            joiner.add(String.format("%sfindingId%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getFindingId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `comment` to the URL query string
        if (getComment() != null) {
            joiner.add(String.format("%scomment%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getComment()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        return joiner.toString();
    }
}

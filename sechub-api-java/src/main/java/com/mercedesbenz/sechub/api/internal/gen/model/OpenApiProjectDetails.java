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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * OpenApiProjectDetails
 */
@JsonPropertyOrder({ OpenApiProjectDetails.JSON_PROPERTY_OWNER, OpenApiProjectDetails.JSON_PROPERTY_META_DATA, OpenApiProjectDetails.JSON_PROPERTY_ACCESS_LEVEL,
        OpenApiProjectDetails.JSON_PROPERTY_DESCRIPTION, OpenApiProjectDetails.JSON_PROPERTY_WHITE_LIST, OpenApiProjectDetails.JSON_PROPERTY_PROJECT_ID,
        OpenApiProjectDetails.JSON_PROPERTY_USERS })

public class OpenApiProjectDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_OWNER = "owner";
    private String owner;

    public static final String JSON_PROPERTY_META_DATA = "metaData";
    private OpenApiProjectDetailsMetaData metaData;

    public static final String JSON_PROPERTY_ACCESS_LEVEL = "accessLevel";
    private String accessLevel;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_WHITE_LIST = "whiteList";
    private List<String> whiteList;

    public static final String JSON_PROPERTY_PROJECT_ID = "projectId";
    private String projectId;

    public static final String JSON_PROPERTY_USERS = "users";
    private List<String> users;

    public OpenApiProjectDetails() {
    }

    public OpenApiProjectDetails owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Username of the owner of this project. An owner is the person in charge.
     *
     * @return owner
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OWNER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOwner() {
        return owner;
    }

    @JsonProperty(JSON_PROPERTY_OWNER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public OpenApiProjectDetails metaData(OpenApiProjectDetailsMetaData metaData) {
        this.metaData = metaData;
        return this;
    }

    /**
     * Get metaData
     *
     * @return metaData
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_META_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OpenApiProjectDetailsMetaData getMetaData() {
        return metaData;
    }

    @JsonProperty(JSON_PROPERTY_META_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMetaData(OpenApiProjectDetailsMetaData metaData) {
        this.metaData = metaData;
    }

    public OpenApiProjectDetails accessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    /**
     * The project access level
     *
     * @return accessLevel
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACCESS_LEVEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAccessLevel() {
        return accessLevel;
    }

    @JsonProperty(JSON_PROPERTY_ACCESS_LEVEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public OpenApiProjectDetails description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The project description.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public OpenApiProjectDetails whiteList(List<String> whiteList) {
        this.whiteList = whiteList;
        return this;
    }

    public OpenApiProjectDetails addWhiteListItem(String whiteListItem) {
        if (whiteList == null) {
            whiteList = new ArrayList<>();
        }
        whiteList.add(whiteListItem);
        return this;
    }

    /**
     * A list of all whitelisted URIs. Only these ones can be scanned for the
     * project!
     *
     * @return whiteList
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WHITE_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getWhiteList() {
        return whiteList;
    }

    @JsonProperty(JSON_PROPERTY_WHITE_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }

    public OpenApiProjectDetails projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * The name of the project
     *
     * @return projectId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProjectId() {
        return projectId;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public OpenApiProjectDetails users(List<String> users) {
        this.users = users;
        return this;
    }

    public OpenApiProjectDetails addUsersItem(String usersItem) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(usersItem);
        return this;
    }

    /**
     * A list of all users having access to the project
     *
     * @return users
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getUsers() {
        return users;
    }

    @JsonProperty(JSON_PROPERTY_USERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsers(List<String> users) {
        this.users = users;
    }

    /**
     * Return true if this ProjectDetails object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OpenApiProjectDetails projectDetails = (OpenApiProjectDetails) o;
        return Objects.equals(owner, projectDetails.owner) && Objects.equals(metaData, projectDetails.metaData)
                && Objects.equals(accessLevel, projectDetails.accessLevel) && Objects.equals(description, projectDetails.description)
                && Objects.equals(whiteList, projectDetails.whiteList) && Objects.equals(projectId, projectDetails.projectId)
                && Objects.equals(users, projectDetails.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, metaData, accessLevel, description, whiteList, projectId, users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenApiProjectDetails {\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    metaData: ").append(toIndentedString(metaData)).append("\n");
        sb.append("    accessLevel: ").append(toIndentedString(accessLevel)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    whiteList: ").append(toIndentedString(whiteList)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

        // add `owner` to the URL query string
        if (getOwner() != null) {
            joiner.add(String.format("%sowner%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getOwner()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `metaData` to the URL query string
        if (getMetaData() != null) {
            joiner.add(getMetaData().toUrlQueryString(prefix + "metaData" + suffix));
        }

        // add `accessLevel` to the URL query string
        if (getAccessLevel() != null) {
            joiner.add(String.format("%saccessLevel%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getAccessLevel()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `description` to the URL query string
        if (getDescription() != null) {
            joiner.add(String.format("%sdescription%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getDescription()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `whiteList` to the URL query string
        if (getWhiteList() != null) {
            for (int i = 0; i < getWhiteList().size(); i++) {
                joiner.add(String.format("%swhiteList%s%s=%s", prefix, suffix,
                        "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
                        URLEncoder.encode(String.valueOf(getWhiteList().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
            }
        }

        // add `projectId` to the URL query string
        if (getProjectId() != null) {
            joiner.add(String.format("%sprojectId%s=%s", prefix, suffix,
                    URLEncoder.encode(String.valueOf(getProjectId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }

        // add `users` to the URL query string
        if (getUsers() != null) {
            for (int i = 0; i < getUsers().size(); i++) {
                joiner.add(
                        String.format("%susers%s%s=%s", prefix, suffix, "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
                                URLEncoder.encode(String.valueOf(getUsers().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
            }
        }

        return joiner.toString();
    }
}

package com.daimler.sechub.sarif.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * From <a href="https://github.com/microsoft/sarif-tutorials/blob/main/docs/2-Basics.md#property-bags">Sarif documentation</a>:
 * <quote> Before we go any further, let's address an issue that almost every
 * tool vendor cares about: What do I do if my tool produces information that
 * the SARIF specification doesn't mention?
 * 
 * The answer is that every object in the SARIF object model — from logs to runs
 * to results to locations to messages, without exception — defines a property
 * named properties. The spec calls a property named properties a property bag.
 * </quote>
 * 
 * @author Albert Tregnaghi
 *
 */
public class PropertyBag {

    @JsonIgnore
    private Map<String, String> additionalProperties;

    public PropertyBag() {
        this.additionalProperties = new HashMap<String, String>();
    }

    public PropertyBag(Map<String, String> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    /**
     * adds the key-value pair to the PropertyBag, if none of them equals null.
     * 
     * @param key
     * @param value
     */
    public void addAdditionalProperty(String key, String value) {
        this.additionalProperties.put(key, value);
    }

    @JsonProperty
    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonIgnore
    public void setAdditionalProperties(Map<String, String> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "PropertyBag [additionalProperties=" + additionalProperties + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyBag)) {
            return false;
        }
        PropertyBag other = (PropertyBag) obj;
        return Objects.equals(additionalProperties, other.additionalProperties);
    }
}

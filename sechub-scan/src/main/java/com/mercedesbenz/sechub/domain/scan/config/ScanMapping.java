// SPDX-License-Identifier: MIT
package com.mercedesbenz.sechub.domain.scan.config;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = ScanMapping.TABLE_NAME)
public class ScanMapping {

    /* +-----------------------------------------------------------------------+ */
    /* +............................ SQL ......................................+ */
    /* +-----------------------------------------------------------------------+ */
    public static final String TABLE_NAME = "SCAN_MAPPING";

    public static final String COLUMN_MAPPING_ID = "MAPPING_ID";

    public static final String COLUMN_DATA = "MAPPING_DATA";

    /* +-----------------------------------------------------------------------+ */
    /* +............................ JPQL .....................................+ */
    /* +-----------------------------------------------------------------------+ */
    public static final String CLASS_NAME = ScanMapping.class.getSimpleName();

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DATA = "data";

    @Id
    @Column(name = COLUMN_MAPPING_ID, unique = true, nullable = false)
    String id;

    @Column(name = COLUMN_DATA, unique = true, nullable = false)
    String data;

    @Version
    @Column(name = "VERSION")
    Integer version;

    /* JPA only */
    ScanMapping() {

    }

    public ScanMapping(String key) {
        this.id = key;
    }

    public void setData(String json) {
        this.data = json;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ScanMapping other = (ScanMapping) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
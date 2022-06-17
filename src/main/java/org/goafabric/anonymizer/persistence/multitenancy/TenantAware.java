package org.goafabric.anonymizer.persistence.multitenancy;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TenantAware {
    public static final String TENANT_FILTER = "TENANT_FILTER";

    @Access(AccessType.PROPERTY)
    public String getTenantId() {return "0";}
    
    public void setTenantId(String tenantId) {}

    public abstract String getId();
}

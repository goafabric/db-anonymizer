package org.goafabric.anonymizer.persistence.domain;

import lombok.*;
import org.goafabric.anonymizer.persistence.multitenancy.TenantAware;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class PersonBo extends TenantAware {
    @Id
    @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NonNull
    private AddressBo address;

    @Version //optimistic locking
    private Long version;
}

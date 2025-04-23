package com.milind.encryption.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(
        name = "encrypted_data_details",
        indexes = {
                @Index(name = "idx_organization_id", columnList = "organization_id")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EncryptedDataDetails {

    @Id
    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @ElementCollection
    @MapKeyColumn(name = "data_key") // Key column for the map
    @Column(name = "data_value") // Value column for the map
    @CollectionTable(
            name = "encrypted_data", // Name of the collection table
            joinColumns = {
                    @JoinColumn(name = "entry_id", referencedColumnName = "entry_id"),
                    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
            }
    )
    private Map<String, String> encryptedData;


}

package com.creativefusion.spring6restmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private UUID id;
    private String name;

    @Version
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}

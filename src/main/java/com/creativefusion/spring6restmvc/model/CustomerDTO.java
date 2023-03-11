package com.creativefusion.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
@Data
@Builder
public class CustomerDTO {
    private UUID id;
    private String name;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}

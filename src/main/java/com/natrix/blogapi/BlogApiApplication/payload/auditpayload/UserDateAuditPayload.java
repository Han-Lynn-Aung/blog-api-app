package com.natrix.blogapi.BlogApiApplication.payload.auditpayload;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class UserDateAuditPayload extends DateAuditPayload{

    private Long createdBy;

    private Long updatedBy;
}

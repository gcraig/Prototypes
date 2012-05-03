package com.csr.services.audit;

import java.util.List;

public class AuditLog {

	private Long id;
	private String entity;
	private String entityId;


	private List entries;


	public AuditLog() {
		System.out.println("1.4.1");
	}

	public AuditLog(Object entity, String entityId) {
		this.entity = entity.toString();
		this.entityId = entityId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setEntity(Object entity) {
		this.entity = entity.toString();
	}

	public String getEntity() {
		return entity;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityId() {
		return entityId;
	}
}

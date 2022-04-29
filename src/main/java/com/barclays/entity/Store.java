package com.barclays.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {

	@EmbeddedId
	private StoreId storeId;

	@Column(name = "version")
	private int version;

	@Column(name = "maturity_date")
	private String maturityDate;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "expired")
	@Enumerated(EnumType.STRING)
	private Expired expired;

	public Store() {
		super();
	}

	public Store(StoreId storeId, int version, String maturityDate, String createdDate, Expired expired) {
		super();
		this.storeId = storeId;
		this.version = version;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public StoreId getStoreId() {
		return storeId;
	}

	public void setStoreId(StoreId storeId) {
		this.storeId = storeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Expired getExpired() {
		return expired;
	}

	public void setExpired(Expired expired) {
		this.expired = expired;
	}
}

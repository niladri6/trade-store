package com.barclays.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StoreId implements Serializable {
	private static final long serialVersionUID = 3455440978128699458L;

	@Column(name = "trade_id", nullable = false)
	private String tradeId;

	@Column(name = "container_party_id", nullable = false)
	private String counterPartyId;

	@Column(name = "book_id", nullable = false)
	private String bookId;

	public StoreId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreId(String tradeId, String counterPartyId, String bookId) {
		super();
		this.tradeId = tradeId;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
	}


	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, counterPartyId, tradeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreId other = (StoreId) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(counterPartyId, other.counterPartyId)
				&& Objects.equals(tradeId, other.tradeId);
	}
	
}

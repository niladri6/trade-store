package com.barclays.entity;

public class TradeDTO {
	private String tradeId;
	private String counterPartyId;
	private String bookId;
	private int version;
	private String maturityDate;

	public TradeDTO(String tradeId, String counterPartyId, String bookId, int version, String maturityDate) {
		super();
		this.tradeId = tradeId;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.version = version;
		this.maturityDate = maturityDate;
	}

	public TradeDTO() {
		super();
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

	public StoreId getStoreId() {
		return new StoreId(this.tradeId, this.counterPartyId, this.bookId);
	}

}

package com.nvrs.transaction.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "merchantId", "customerId", "tranProdut", "amount", "status" })
public class TransactionBean {

	@JsonProperty("merchantId")
	private Long merchantId;
	@JsonProperty("customerId")
	private Long customerId;
	@JsonProperty("tranProdut")
	private List<TranProductBean> tranProdut = null;
	@JsonProperty("amount")
	private Long amount;
	@JsonProperty("status")
	private String status;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("merchantId")
	public Long getMerchantId() {
		return merchantId;
	}

	@JsonProperty("merchantId")
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	@JsonProperty("customerId")
	public Long getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("tranProdut")
	public List<TranProductBean> getTranProdut() {
		return tranProdut;
	}

	@JsonProperty("tranProdut")
	public void setTranProdut(List<TranProductBean> tranProdut) {
		this.tranProdut = tranProdut;
	}

	@JsonProperty("amount")
	public Long getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [merchantId=" + merchantId + ", customerId=" + customerId + ", tranProdut=" + tranProdut
				+ ", amount=" + amount + ", status=" + status + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

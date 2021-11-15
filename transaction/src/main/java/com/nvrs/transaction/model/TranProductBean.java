package com.nvrs.transaction.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "productId", "description", "price", "quantity" })
public class TranProductBean {

	@Override
	public String toString() {
		return "TranProduct [productId=" + productId + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("productId")
	private Long productId;
	@JsonProperty("description")
	private String description;
	@JsonProperty("price")
	private Long price;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("productId")
	public Long getProductId() {
		return productId;
	}

	@JsonProperty("productId")
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("price")
	public Long getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Long price) {
		this.price = price;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
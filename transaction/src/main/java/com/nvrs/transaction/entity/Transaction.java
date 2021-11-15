package com.nvrs.transaction.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Customer
 */

@Entity
public class Transaction {
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", merchantId=" + merchantId + ", products=" + products + ", customerId="
				+ customerId + ", amount=" + amount + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified
				+ ", status=" + status + ", getProducts()=" + getProducts() + ", getCustomerId()=" + getCustomerId()
				+ ", getAmount()=" + getAmount() + ", getMerchantId()=" + getMerchantId() + ", getId()=" + getId()
				+ ", getDateModified()=" + getDateModified() + ", getDateCreated()=" + getDateCreated()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "transaction_id_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	@Column(name="TRAN_ID")
	private Long id = null;
	
	private Long merchantId = null;
	
    @OneToMany(fetch = FetchType.LAZY,mappedBy="transaction",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TranProduct> products = null;

    private Long customerId = null;
	public List<TranProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TranProduct> products) {
		this.products = products;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}


	private long amount;
	
	
	private Date dateCreated = null;
	
	private Date dateModified = null;

	private String status = null;

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	
	public Transaction id(Long id) {
		this.id = id;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateModified() {
		return dateModified;
	}

	@PostPersist
	public void setDateModified() {
		this.dateModified = new Date();
	}

	@PrePersist
	public void setDateCreated() {
		this.dateCreated = this.dateModified = new Date();
	}

	
	public Date getDateCreated() {
		return dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

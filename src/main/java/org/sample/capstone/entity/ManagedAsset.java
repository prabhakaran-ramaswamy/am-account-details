package org.sample.capstone.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "MANAGED_ASSET")
public class ManagedAsset implements Serializable {

	private static final long serialVersionUID = -655325088406930921L;

	@Id
    @SequenceGenerator(name = "managedAssetGen", sequenceName = "MANAGED_ASSET_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managedAssetGen")
    @Column(name = "MANAGED_ASSET_ID")
    private Long id;

	@JsonBackReference(value="asset")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ASSET_ID")
    private AssetDetail asset;
    
    @JsonBackReference(value="account")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssetDetail getAsset() {
		return asset;
	}

	public void setAsset(AssetDetail asset) {
		this.asset = asset;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

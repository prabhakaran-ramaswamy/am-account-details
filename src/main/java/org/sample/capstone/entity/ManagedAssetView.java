package org.sample.capstone.entity;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ManagedAssetView implements Serializable {

	private static final long serialVersionUID = 8948808607025989323L;

	private Long id;

    private AssetDetailView asset;
    
    private AccountView account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssetDetailView getAsset() {
		return asset;
	}

	public void setAsset(AssetDetailView asset) {
		this.asset = asset;
	}

	public AccountView getAccount() {
		return account;
	}

	public void setAccount(AccountView account) {
		this.account = account;
	}

}

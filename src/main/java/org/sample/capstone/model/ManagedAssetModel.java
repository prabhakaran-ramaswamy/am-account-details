package org.sample.capstone.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ManagedAssetModel implements Serializable {

	private static final long serialVersionUID = 9089462019821117346L;

	private Long id;

	@NotNull
	private AssetDetailModel asset;

	@NotNull
	private AccountModel account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssetDetailModel getAsset() {
		return asset;
	}

	public void setAsset(AssetDetailModel asset) {
		this.asset = asset;
	}

	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
		this.account = account;
	}

}

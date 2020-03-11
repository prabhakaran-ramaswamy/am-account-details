package org.sample.capstone.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AssetDetailView implements Serializable {

	private static final long serialVersionUID = -6266864939189925395L;

	private Long id;

	private String description;

	private String assetNumber;

	private String serial;

	private String status;

	private Set<ManagedAssetView> managedAssets = new HashSet<ManagedAssetView>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ManagedAssetView> getManagedAssets() {
		return managedAssets;
	}

	public void setManagedAssets(Set<ManagedAssetView> managedAssets) {
		this.managedAssets = managedAssets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetDetailView other = (AssetDetailView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

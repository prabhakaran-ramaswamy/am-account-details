package org.sample.capstone.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AssetDetailModel implements Serializable {

	private static final long serialVersionUID = -1456487290977748876L;

	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String description;

	@NotNull
	@Size(min = 3, max = 30)
	private String assetNumber;

	@NotNull
	@Size(min = 3, max = 30)
	private String serial;

	@NotNull
	@Size(min = 3, max = 30)
	private String taggedTo;

	private String status;

	private Set<ManagedAssetModel> managedAssets = new HashSet<ManagedAssetModel>();

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

	public String getTaggedTo() {
		return taggedTo;
	}

	public void setTaggedTo(String taggedTo) {
		this.taggedTo = taggedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ManagedAssetModel> getManagedAssets() {
		return managedAssets;
	}

	public void setManagedAssets(Set<ManagedAssetModel> managedAssets) {
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
		AssetDetailModel other = (AssetDetailModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

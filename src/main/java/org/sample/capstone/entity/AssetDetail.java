package org.sample.capstone.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_DETAIL")
public class AssetDetail {

	@Id
	@SequenceGenerator(name = "assetDetailsGen", sequenceName = "ASSET_DETAIL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assetDetailsGen")
	@Column(name = "ASSET_DETAIL_ID")
	private Long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ASSET_NUMBER")
	private String assetNumber;

	@Column(name = "SERIAL")
	private String serial;

	@Column(name = "TAGGED_TO")
	private String taggedTo;

	@Column(name = "STATUS")
	private String status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	private Set<ManagedAsset> managedAssets;

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

	public Set<ManagedAsset> getManagedAssets() {
		return managedAssets;
	}

	public void setManagedAssets(Set<ManagedAsset> managedAssets) {
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
		AssetDetail other = (AssetDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

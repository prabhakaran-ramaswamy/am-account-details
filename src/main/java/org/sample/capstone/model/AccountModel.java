package org.sample.capstone.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountModel implements Serializable {

	private static final long serialVersionUID = -5990558755697311339L;

	private Long id;

	@NotNull
	@Size(min = 3, max = 30)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 30)
	private String lastName;

	@NotNull
	@Size(min = 3, max = 30)
	private String email;

	@NotNull
	@Size(max = 15)
	private String mobile;

	private Set<ManagedAssetModel> managedAssets = new HashSet<ManagedAssetModel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		AccountModel other = (AccountModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

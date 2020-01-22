package org.sample.capstone.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "MANAGED_ASSET")
public class ManagedAsset {

    @Id
    @SequenceGenerator(name = "managedAssetGen", sequenceName = "MANAGED_ASSET_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managedAssetGen")
    @Column(name = "MANAGED_ASSET_ID")
    private Long id;

    @Column(name="ASSET_ID")
    private AssetDetail asset;
    
    @Column(name="ACCOUNT_ID")
    private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    
}

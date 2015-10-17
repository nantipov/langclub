package org.langclub.api.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CONNECTED_ACCOUNT")
public class UserConnectedAccount {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_CACCT_ID")
	private String id;
	
	@JoinColumn(name = "USER_ID")
	@ManyToOne
	private UserEntity user;
	
	@Column(name = "CACCT_TYPE")
	@Enumerated(EnumType.STRING)
	private ConnectedAccountType connectedAccountType;
	
	@Column(name = "KEY")
	private String key;
	
	@Column(name = "EXTRA_DATA")
	private String extraData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ConnectedAccountType getConnectedAccountType() {
		return connectedAccountType;
	}

	public void setConnectedAccountType(ConnectedAccountType connectedAccountType) {
		this.connectedAccountType = connectedAccountType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
	
}

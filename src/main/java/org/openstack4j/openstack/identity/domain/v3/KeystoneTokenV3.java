package org.openstack4j.openstack.identity.domain.v3;

import java.util.Date;

import org.openstack4j.model.identity.Tenant;
import org.openstack4j.model.identity.Token;

public class KeystoneTokenV3 implements Token {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private Date expires;

	public KeystoneTokenV3(String id, Date expires) {
		this.id = id;
		this.expires = expires;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Date getExpires() {
		// TODO Auto-generated method stub
		return expires;
	}

	@Override
	public Tenant getTenant() {
		// TODO Auto-generated method stub
		return null;
	}

}

package org.openstack4j.openstack.identity.domain.v3;

import org.openstack4j.openstack.identity.domain.KeystoneRole;

import com.google.common.base.Objects;

public final class AccessRole extends KeystoneRole{
	
	private static final long serialVersionUID = 1L;

	public String toString() {
		return Objects.toStringHelper(this).omitNullValues()
				.add("id", getId()).add("name", getName()).toString();
	}
}

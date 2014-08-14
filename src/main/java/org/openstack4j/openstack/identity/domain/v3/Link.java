package org.openstack4j.openstack.identity.domain.v3;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Objects;

public class Link {
	@JsonProperty
	String self;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}
	public String toString() {
		return Objects.toStringHelper(this).omitNullValues().add("self", self).toString();
	}
}

package org.openstack4j.openstack.identity.domain.v3;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AccessProject {

	private String id;
	private String name;
	private Domain domain;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return Objects.toStringHelper(this).omitNullValues().add("id", id)
				.add("name", name).add("domain", domain).add("id", id)
				.toString();
	}

}
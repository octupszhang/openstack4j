package org.openstack4j.openstack.identity.domain.v3;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Domain {
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
	@JsonProperty
	private Link links;

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

	public Link getLinks() {
		return links;
	}

	public void setLinks(Link links) {
		this.links = links;
	}

	public String toString() {
		return Objects.toStringHelper(this).omitNullValues().add("id", id).add("name", name).add("links", links).toString();
	}
}

package org.openstack4j.openstack.identity.domain.v3;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack4j.api.types.ServiceType;
import org.openstack4j.model.common.Link;
import org.openstack4j.model.identity.Access;
import org.openstack4j.model.identity.Endpoint;
import org.openstack4j.model.identity.Role;
import org.openstack4j.model.identity.Token;
import org.openstack4j.openstack.common.GenericLink;
import org.openstack4j.openstack.common.ListResult;
import org.openstack4j.openstack.identity.domain.KeystoneEndpoint;
import org.openstack4j.openstack.identity.domain.KeystoneRole;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.identity.Service;

import com.google.common.base.Objects;

@JsonRootName("token")
@SuppressWarnings("unused")
public class KeystoneAccessV3 implements Access {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Date issued_at;
	@JsonProperty
	private Date expires_at;
	@JsonProperty
	private List<AccessService> catalog;
	@JsonProperty
	private AccessUser user;
	@JsonProperty
	private AccessProject project;
	@JsonProperty
	private List<String> methods;
	@JsonProperty
	private List<AccessRole> roles;

	private Credentials credentials;
	private String endpoint;
	private Token token;

	public Credentials getCredentials() {
		return credentials;
	}

	public KeystoneAccessV3 applyContext(String endpoint,	Credentials credentials, Token token) {
		this.credentials = credentials;
		this.endpoint = endpoint;
		this.token = token;
		return this;
	}

	public Token getToken() {
		return token;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public String toString() {
		return Objects.toStringHelper(this).omitNullValues()
				.add("issued_at", issued_at).add("expires_at", expires_at)
				.add("serviceCatalog", catalog).add("users", user).toString();
	}

	public Date getIssued_at() {
		return issued_at;
	}

	public Date getExpires_at() {
		return expires_at;
	}

	public List<AccessService> getCatalog() {
		return catalog;
	}

	public AccessProject getProject() {
		return project;
	}

	public List<String> getMethods() {
		return methods;
	}

	public List<AccessRole> getRoles() {
		return roles;
	}

	@Override
	public List<? extends Service> getServiceCatalog() {
		return catalog;
	}

	@Override
	@Deprecated
	public UserDetails getUser() {
		// it should never be used,just to compatible with Access interface here
		new Exception("it should never be used,just to compatible with Access interface here").printStackTrace();
		return null;
		
	}

}

package org.openstack4j.openstack.identity.domain.v3;

import java.util.List;

import org.openstack4j.api.types.ServiceType;
import org.openstack4j.model.identity.Endpoint;
import org.openstack4j.openstack.common.GenericLink;
import org.openstack4j.openstack.identity.domain.KeystoneEndpoint;
import org.openstack4j.model.identity.Access.Service;

import com.google.common.base.Objects;

public class AccessService implements Service{
	/**
	 * 
	 */
	private String type;
	private String name;
	private String id;
	private List<KeystoneEndpoint> endpoints;
	private ServiceType serviceType;
	private List<GenericLink> endpointsLinks;

	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public ServiceType getServiceType() {
		if (serviceType == null)
			serviceType = ServiceType.forName(name);
		return serviceType;
	}

	/**
	 * @return the endpoints
	 */
	@Override
	public List<? extends Endpoint> getEndpoints() {
		return endpoints;
	}

	/**
	 * @return the endpointsLinks
	 */
	@Override
	public List<? extends org.openstack4j.model.common.Link> getEndpointsLinks() {
		return endpointsLinks;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return Objects.toStringHelper(this).omitNullValues()
				.add("name", name).add("type", type).add("id", id)
				.add("endpoints", endpoints).toString();
	}


}

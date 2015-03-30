package org.openstack4j.api.sahara;

import org.openstack4j.common.RestService;

/**
 * (Sahara) Data Processing Operations API
 * 
 * @author Ekasit Kijsipongse
 */
public interface SaharaService extends RestService {

	/**
	 * Cluster Service API
	 *
	 * @return the cluster service
	 */
	ClusterService clusters();
	
	/**
	 * Node Group Template Service API
	 *
	 * @return the node group template service
	 */
	NodeGroupTemplateService nodeGroupTemplates();

	/**
	 * Cluster Template Service API
	 *
	 * @return the cluster template service
	 */
	ClusterTemplateService clusterTemplates();

	/**
	 * Image Service API
	 *
	 * @return the image service
	 */
	SaharaImageService images();

	/**
	 * Plugin Service API
	 *
	 * @return the plugin service
	 */
	SaharaPluginService plugins();
}

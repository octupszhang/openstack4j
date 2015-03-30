package org.openstack4j.api.network;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.api.Builders;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.HealthMonitor;
import org.openstack4j.model.network.ext.HealthMonitorAssociate;
import org.openstack4j.model.network.ext.LbPool;
import org.openstack4j.model.network.ext.LbPoolUpdate;
import org.openstack4j.openstack.networking.domain.ext.LbMethod;
import org.openstack4j.openstack.networking.domain.ext.Protocol;
import org.testng.annotations.Test;

@Test(suiteName="Network/lbpool", enabled=true)
public class LbPoolTests extends AbstractTest {

    private static final String LBPOOLS_JSON = "/network/lbpools.json";
    private static final String LBPOOL_JSON = "/network/lbpool.json";
    private static final String LBPOOL_UPDATE_JSON = "/network/lbpool_update.json";
    
	public void testListPool() throws IOException {
	    respondWith(LBPOOLS_JSON);
		List<? extends LbPool> list = os().networking().loadbalancers().lbPool().list();
		assertEquals(1, list.size());
		assertEquals(list.get(0).getSubnetId(), "8032909d-47a1-4715-90af-5153ffe39861");
	}

	public void testListPoolFilter() throws IOException {
	    respondWith(LBPOOLS_JSON);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "pool");
		List<? extends LbPool> list = os().networking().loadbalancers().lbPool().list(map);
		assertEquals(1, list.size());
	}

	public void testGetPool() throws IOException {
	    respondWith(LBPOOL_JSON);
		String id = "4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5";
		LbPool pool = os().networking().loadbalancers().lbPool().get(id);
		assertNotNull(pool);
		assertEquals(id, pool.getId());
	}

	public void testCreatePool() throws IOException {
	    respondWith(LBPOOL_JSON);
		String name = "pool1";
		String protocol = Protocol.HTTP.toString();
		LbPool create = Builders.lbPool().adminStateUp(true)
				.description("pool").lbMethod(LbMethod.ROUND_ROBIN.toString())
				.name(name).provider("haproxy")
				.subnetId("7d1dab60-cf8a-4f75-af5c-44aab98b0c42")
				.tenantId("d7fd03242ffa4933863bc528ed884fb6")
				.protocol(protocol).build();
		LbPool result = os().networking().loadbalancers().lbPool().create(create);
		assertEquals(name, result.getName());
		assertEquals(result.getLbMethod(), LbMethod.ROUND_ROBIN.toString());
		assertEquals(protocol, result.getProtocol());
	}
	public void testUpdatePool() throws IOException {
	    respondWith(LBPOOL_UPDATE_JSON);
		String poolId = "db083bf7-c455-4758-b1ad-203cf441a73a";
		String name = "update";
		LbPoolUpdate update = Builders.lbPoolUpdate().adminStateUp(false)
				.description("update")
				.lbMethod(LbMethod.LEAST_CONNECTIONS.toString()).name(name)
				.build();
		LbPool result = os().networking().loadbalancers().lbPool().update(poolId, update);
		assertEquals(name, result.getName());
		assertEquals(LbMethod.LEAST_CONNECTIONS.toString(),
				result.getLbMethod());
		assertFalse(result.isAdminStateUp());
	}

	@Test(enabled=false)
	public void testAssociateHealthMonitor() {
		String poolId = "db083bf7-c455-4758-b1ad-203cf441a73a";
		String healthId = "8767284a-b542-4db6-8393-0a404a959c1d";
		HealthMonitorAssociate associate = Builders.lbPoolAssociateHealthMonitor().id(healthId).build();
		HealthMonitor result = os().networking().loadbalancers().lbPool().associateHealthMonitor(poolId, associate);
		assertTrue(result != null);
	}
	
    @Test(enabled=false)
	public void testDisAssociateHealthMonitor() {
		String poolId = "db083bf7-c455-4758-b1ad-203cf441a73a";
		String healthId = "8767284a-b542-4db6-8393-0a404a959c1d";
		ActionResponse result = os().networking().loadbalancers().lbPool()
				.disAssociateHealthMonitor(poolId, healthId);
		assertTrue(result.isSuccess());
	}
	
	public void testDeletePool() {
	    respondWith(200);
		ActionResponse result = os().networking().loadbalancers().lbPool().delete("02ae87ec-5502-469e-8c41-f2c57d185054");
		assertTrue(result.isSuccess());
	}
	
	@Override
	protected Service service() {
		return Service.NETWORK;
	}

}

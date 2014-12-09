package org.openstack4j.openstack.compute.domain.actions;

import org.openstack4j.model.compute.actions.MigrateOptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Migration Action for a Server
 * 
 * @author zhangjihai
 */
@JsonRootName("migrate")
public class MigrationAction implements ServerAction {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String host;
    
    public static MigrationAction create(MigrateOptions options) {
        MigrationAction action = new MigrationAction();
        action.host = options.getHost();
        return action;
    }

    public String getHost() {
        return host;
    }
    
}

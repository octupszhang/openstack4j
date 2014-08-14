package org.openstack4j.openstack.identity.domain.v3;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * construct a entity like for keystone v3 token get
 * {
    "auth": {
        "identity": {
            "methods": [
                "password"
            ],
            "password": {
                "user": {
                    "domain": {
                        "id": "383a81135e2e46b59057286f9c511513"
                    },
                    "name": "admin",
                    "password": "password"
                }
            }
        }
    }
}
 * @author octopus zhang
 */

@SuppressWarnings("unused")
@JsonRootName("auth")
public class Credentials extends Auth {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "identity")
	private Identity identity = new Identity();
	
	public Credentials(String username, String password, String domainName, String domianId) {
		Domain domain = new Domain(domainName, domianId);
		User user = new User(username, password, domain);
		Password pass = new Password();
		pass.setUser(user);
		identity.setPassword(pass);
	}
	
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	private static final class Identity {
		@JsonProperty
		private List<String> methods;
		@JsonProperty
		private Password password;
		
		public Identity(){
			methods = new ArrayList<String>();
			methods.add("password");
		}
		public void setPassword(Password password) {
			this.password = password;
		}

	}

	private static final class Password {
		@JsonProperty
		User user;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	}

	private static final class User {
		@JsonProperty
		String name;
		@JsonProperty
		String password;
		@JsonProperty
		Domain domain;

		public String getName() {
			return name;
		}

		public String getPassword() {
			return password;
		}

		public Domain getDomain() {
			return domain;
		}

		public User(String name, String password, Domain domain) {
			this.domain = domain;
			this.name = name;
			this.password = password;
		}

	}

	private static final class Domain {
		@JsonProperty
		private String id;
		@JsonProperty
		private String name;

		public Domain(String domainName, String domianId) {
			this.id = domianId;
			this.name = domainName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}

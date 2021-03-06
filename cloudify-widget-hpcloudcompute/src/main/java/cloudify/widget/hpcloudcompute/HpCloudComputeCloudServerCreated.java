package cloudify.widget.hpcloudcompute;


import cloudify.widget.api.clouds.CloudServerCreated;
import cloudify.widget.api.clouds.MachineCredentials;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.domain.LoginCredentials;

/**
 * User: evgeny
 * Date: 2/10/14
 * Time: 6:55 PM
 */
public class HpCloudComputeCloudServerCreated implements CloudServerCreated {

	private final NodeMetadata newNode;

	public HpCloudComputeCloudServerCreated(NodeMetadata newNode){
		this.newNode = newNode;
	}

	public NodeMetadata getNewNode() {
		return newNode;
	}

    @Override
    public String getId() {
        return newNode.getId();
    }

    @Override
    public MachineCredentials getCredentials() {
        LoginCredentials loginCredentials = newNode.getCredentials();
        if (loginCredentials != null) {
            return new MachineCredentials()
                    .setUser(loginCredentials.getUser())
                    .setPassword(loginCredentials.getPassword())
                    .setPrivateKey(loginCredentials.getPrivateKey());
        }
        return null;
    }

    @Override
	public String toString() {
		return "HpCloudComputeCloudServerCreated [newNode=" + newNode + "], id=" + newNode.getId();
	}
}
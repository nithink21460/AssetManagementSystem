package assetManagement;

import java.util.*;
class Device
{
    private String device_id;
    private Employee owner;
    private List<Installation> installations;
    public Device(String device_id, Employee owner)
    {
        this.device_id = device_id;
        this.owner = owner;
        this.installations = new ArrayList<>();
    }
    public String getDeviceId()
    {
        return device_id;
    }
    public Employee getOwner()
    {
        return owner;
    }
    public List<Installation> getInstallations()
    {
        return installations;
    }
    public void addInstallations(Installation installation)
    {
        installations.add(installation);
    }
    
}
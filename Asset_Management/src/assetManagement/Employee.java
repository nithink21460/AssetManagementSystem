package assetManagement;

import java.util.*;
class Employee
{
    private String employee_id;
    private String name;
    private List<Device> devices;
    public Employee(String employee_id, String name)
    {
        this.employee_id = employee_id;
        this.name = name;
        this.devices = new ArrayList<>();
    }
    public String getEmployeeId()
    {
        return employee_id;
    }
    public String getName()
    {
        return name;
    }
    public List<Device> getDevices()
    {
        return devices;
    }
    public void addDevice(Device device)
    {
        devices.add(device);
    }
}

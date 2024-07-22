package assetManagement;

import java.util.*;
class Software
{
    private Vendor vendor;
    private String name;
    private double cost_per_device;
    private Date expiry_date;
    public Software(Vendor vendor, String name, double cost_per_device, Date expiry_date)
    {
        this.vendor = vendor;
        this.name = name;
        this.cost_per_device = cost_per_device;
        this.expiry_date = expiry_date;
    }
    public Vendor getVendor()
    {
        return vendor;
    }
    public String getName()
    {
        return name;
    }
    public double getCostPerDevice()
    {
        return cost_per_device;
    }
    public Date getExpiryDate()
    {
        return expiry_date;
    }
}

package assetManagement;

class Vendor
{
    private String vendor_id;
    private String name;
    public Vendor(String vendor_id, String name)
    {
        this.vendor_id = vendor_id;
        this.name = name;
    }
    public String getVendorId()
    {
        return vendor_id;
    }
    public String getName()
    {
        return name;
    }
}

package assetManagement;

import java.util.*;
class Installation
{
    private Software software;
    private Date installation_date;
    public Installation(Software software, Date installation_date)
    {
        this.software = software;
        this.installation_date = installation_date;
    }
    public Software getSoftware()
    {
        return software;
    }
    public Date getInstallationDate()
    {
    	return installation_date;
    }
}

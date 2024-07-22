package assetManagement;

import java.text.SimpleDateFormat;
import java.util.*;
public class AssetManagementSystem
{
    List<Vendor> vendors;
    List<Employee> employees;
    List<Device> devices;
    List<Software> softwares;
    Scanner sc;
    
    public AssetManagementSystem()
    {
        this.vendors = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.softwares = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }
    
    public void addVendor(Vendor vendor)
    {
        vendors.add(vendor);
    }
    
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    
    public void addDevice(Device device)
    {
        devices.add(device);
    }
    
    public void addSoftware(Software software)
    {
        softwares.add(software);
    }
    
    public Employee findEmployeeById(String employeeId)
    {
        for(Employee e : employees)
        {
            if(e.getEmployeeId().equals(employeeId))
            {
                return e;
            }
        }
        return null;
    }
    
    public Vendor findVendorById(String vendorId)
    {
        for(Vendor v : vendors)
        {
            if(v.getVendorId().equals(vendorId));
            {
                return v;
            }
        }
        return null;
    }
    
    public Software findSoftwareByName(String softwareName)
    {
        for(Software s : softwares)
        {
            if(s.getName().equals(softwareName))
            {
                return s;
            }
        }
        return null;
    }
    
    public Device findDeviceById(String device_id)
    {
    	for(Device device : devices)
    	{
    		if(device.getDeviceId().equals(device_id))
    		{
    			return device;
    		}
    	}
    	return null;
    }
    
    public void InstallSoftwareOnDevice(Device device, Software software, Date date)
    {
        Installation installation = new Installation(software, date);
        device.addInstallations(installation);
    }
    
    public void run()
    {
        while(true)
        {
            System.out.println("***Menu***");
            System.out.println("1. Add Vendor!");
            System.out.println("2. Add Employee!");
            System.out.println("3. Add Device!");
            System.out.println("4. Add Software!");
            System.out.println("5. Install Software on Device!");
            System.out.println("6. Generate Report!");
            System.out.println("7. Exit!");
            System.out.print("Choose an Option: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    addVendor();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    addDevice();
                    break;
                case 4:
                    addSoftware();
                    break;
                case 5:
                    InstallSoftware();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option! Please try again!");
                    break;
            }
        }
    }
    private void addVendor()
    {
        System.out.print("Enter Vendor Id: ");
        String vendor_id = sc.nextLine();
        System.out.print("Enter Vendor Name: ");
        String name = sc.nextLine();
        Vendor vendor = new Vendor(vendor_id, name);
        addVendor(vendor);
        System.out.println("Vendor added successfully!!!");
    }
    
    private void addEmployee()
    {
        System.out.print("Enter Employee Id: ");
        String employee_id = sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        Employee employee = new Employee(employee_id, name);
        addEmployee(employee);
        System.out.println("Employee added successfully!!!");
    }
    
    private void addDevice()
    {
        System.out.print("Enter Device Id: ");
        String device_id = sc.nextLine();
        System.out.print("Enter Employee Id: ");
        String employee_id = sc.nextLine();
        Employee employee = findEmployeeById(employee_id);
        if(employee == null)
        {
            System.out.println("Invalid Employee Id, Employee not found!!!");
            return;
        }
        Device device = new Device(device_id, employee);
        employee.addDevice(device);
        addDevice(device);
        System.out.println("Device added successfully!!!");
    }
    
    private void addSoftware()
    {
        System.out.print("Enter Software Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Vendor Id: ");
        String vendor_id = sc.nextLine();
        Vendor vendor = findVendorById(vendor_id);
        if(vendor == null)
        {
            System.out.println("Invalid Vendor Id, Vendor not found!!!");
            return;
        }
        System.out.print("Enter cost per device: ");
        double cost = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Expiration Date(YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        Date date = parseDate(dateStr);
        if(date == null)
        {
            System.out.print("Invalid Date, enter a valid date!!!");
            return;
        }
        Software software = new Software(vendor, name, cost, date);
        addSoftware(software);
        System.out.println("Software added successfully!!!");
    }
    
    private void InstallSoftware()
    {
        System.out.print("Enter Device Id: ");
        String device_id = sc.nextLine();
        Device device = findDeviceById(device_id);
        if(device == null)
        {
            System.out.print("Invalid Device Id, Device not found!!!");
            return;
        }
        System.out.print("Enter Software Name: ");
        String name = sc.nextLine();
        Software software = findSoftwareByName(name);
        if(software == null)
        {
            System.out.print("Invalid Software Name, Software not found!!!");
            return;
        }
        System.out.print("Enter Installation Date(YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        Date date = parseDate(dateStr);
        if(date == null)
        {
            System.out.print("Invalid Date, enter a valid date!!!");
            return;
        }
        InstallSoftwareOnDevice(device, software, date);
        System.out.println("Software installed successfully!!!");
    }
    
    private void generateReport()
    {
        System.out.println("***Report Menu***");
        System.out.println("1. No. of installations of a particular software");
        System.out.println("2. No. of software installed on a device");
        System.out.println("3. No. of software installed for an employee");
        System.out.println("4. Amount spent on a software");
        System.out.println("5. Amount spent for an employee");
        System.out.println("6. No. of installations from a vendor");
        System.out.println("7. Devices with expired software");
        System.out.println("choose a report option: ");
        int option = sc.nextInt();
        sc.nextLine();
        switch(option)
        {
            case 1:
                System.out.print("Enter software name: ");
                String name = sc.nextLine();
                System.out.println("No. of installations of " + name + "is: " + numberOfInstallations(name));
                break;
            case 2:
                System.out.print("Enter device id: ");
                String device_id = sc.nextLine();
                System.out.println("No. of softwares installed on device " + device_id + "is: " + numberOfSoftwaresDevice(device_id));
                break;
            case 3:
                System.out.print("Enter employee id: ");
                String employee_id = sc.nextLine();
                System.out.println("No. of softwares installed for an employee " + employee_id + "is: " + numberOfSoftwaresEmployee(employee_id));
                break;
            case 4:
                System.out.print("Enter software name: ");
                String softwareName = sc.nextLine();
                System.out.println("Amount spent for " + softwareName + "is: " + amountSpentSoftware(softwareName));
                break;
            case 5:
                System.out.print("Enter employee id: ");
                String id = sc.nextLine();
                System.out.println("Amount spent for an employee " + id + "is: " + amountSpentEmployee(id));
                break;
            case 6:
                System.out.print("Enter vendor id: ");
                String vendor_id = sc.nextLine();
                System.out.println("No. of installations from a vendor " + vendor_id + "is: " + numberOfInstallationsVendor(vendor_id));
                break;
            case 7:
                System.out.print("Enter Current Date(YYYY-MM-DD): ");
                String dateStr = sc.nextLine();
                Date date = parseDate(dateStr);
                if(date == null)
                {
                    System.out.println("Invalid Date!!!");
                    return;
                }
                System.out.println("Devices with expired Software are: " + expiredDevices(date));
                break;
            default:
                System.out.println("Invalid Option! Enter a valid option!");
                break;
        }
    }
    
    public int numberOfInstallations(String name)
    {
        int count = 0;
        for(Device device : devices)
        {
            for(Installation installation : device.getInstallations())
            {
                if(installation.getSoftware().getName().equals(name))
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public int numberOfSoftwaresDevice(String device_id)
    {
        for(Device device : devices)
        {
            if(device.getDeviceId().equals(device_id))
            {
                return device.getInstallations().size();
            }
        }
        return 0;
    }
    
    public int numberOfSoftwaresEmployee(String employee_id)
    {
        int count = 0;
        for(Employee emp : employees)
        {
            if(emp.getEmployeeId().equals(employee_id))
            {
                for(Device device : emp.getDevices())
                {
                    count += device.getInstallations().size();
                }
            }
        }
        return count;
    }
    
    public double amountSpentSoftware(String name)
    {
        double total = 0;
        for(Device device : devices)
        {
            for(Installation installation : device.getInstallations())
            {
                if(installation.getSoftware().getName().equals(name))
                {
                    total += installation.getSoftware().getCostPerDevice();
                }
            }
        }
        return total;
    }
    
    public double amountSpentEmployee(String employee_id)
    {
        int total = 0;
        for(Employee emp : employees)
        {
            if(emp.getEmployeeId().equals(employee_id))
            {
                for(Device device : emp.getDevices())
                {
                    for(Installation installation : device.getInstallations())
                    {
                        total += installation.getSoftware().getCostPerDevice();
                    }
                }
            }
        }
        return total;
    }
    
    public int numberOfInstallationsVendor(String vendor_id)
    {
        int count = 0;
        for(Device device : devices)
        {
            for(Installation installation : device.getInstallations())
            {
                if(installation.getSoftware().getVendor().getVendorId().equals(vendor_id))
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public List<Device> expiredDevices(Date currentDate)
    {
        List<Device> deviceList = new ArrayList<>();
        for(Device device : devices)
        {
            for(Installation installation : device.getInstallations())
            {
                if(installation.getSoftware().getExpiryDate().before(currentDate))
                {
                    deviceList.add(device);
                }
            }
        }
        return deviceList;
    }
    
    private Date parseDate(String dateStr)
    {
        try
        {
            return new SimpleDateFormat("YYYY-MM-DD").parse(dateStr);
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
	public static void main(String[] args)
	{
	    AssetManagementSystem as = new AssetManagementSystem();
	    as.run();
	}
}

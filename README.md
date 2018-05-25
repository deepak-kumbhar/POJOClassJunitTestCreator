# POJOClassJunitTestCreator
This application will create basic POJO class test cases easily by providing class name and variables of that particular class.

This application is created in JSP, Servlet, Have added screenshots as well to see the output.

For now initial phase I have only assumed the **String, Integer, Double and Boolean** values. Currently working on other Datatypes.

**Example,**

Let's consider you have POJO class name **EmployeeModel** and it has two to three variables as follows
```
class EmployeeModel{
  	private String employeeName;
  	private Integer empId;
  	private Boolean isActive;
}
```

Then output will be,
```
EmployeeModel employeeModel = new EmployeeModel();

employeeModel.setEmployeeName("employeeName");
assertEquals("employeeName",employeeModel.getEmployeeName());
employeeModel.setEmpId(1);
assertEquals(1,employeeModel.getEmpId());
employeeModel.setIsActiv(true);
assertEquals(true,employeeModel.getIsActiv());

```

Currently I have only worked on creating test cases of variables. Add on will be added later.



The contribution will be welcome.

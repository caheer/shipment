
- make use of inheritance - introduce 
- 
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    private UUID employeeId;

    private String employeeName;

    private String employeeEmail;

username
}
and clacces that extend Employee

courier and assistant - extending employee

courier specific fields
courier_phone_number
courier_area

IN SQL it is : 

CREATE TABLE employees (
employee_id UUID PRIMARY KEY,
employee_name VARCHAR(255) NOT NULL
);

CREATE TABLE couriers (
employee_id UUID PRIMARY KEY,
courier_phone_number VARCHAR(30),

    CONSTRAINT fk_courier_employee
        FOREIGN KEY (employee_id)
        REFERENCES employees(employee_id)
);
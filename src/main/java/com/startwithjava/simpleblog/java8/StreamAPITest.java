package com.startwithjava.simpleblog.java8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamAPITest {
    public static void main(String args[]){
        List<Double> numbers = Arrays.asList(1.0,10.5);
        double s = numbers.stream()
                       .mapToDouble(n->n)
                       .sum();
        System.out.println(s);
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1,"Gaurav",20000);
        Employee e2 = new Employee(1,"Gaurav",30000);
        Employee e3 = new Employee(1,"Gaurav",40000);
        Employee e4 = new Employee(1,"Gaurav",50000);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        List<EmployeeList> employeeLists = employees.stream()
                                                    .filter(e->e.getSalary()>20000)
                                                    .map(EmployeeList::new)
                                                    .collect(Collectors.toList());
        System.out.println(employeeLists);

    }
}

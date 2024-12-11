package com.hr.mapper;

import com.hr.dto.EmployeeDTO;
import com.hr.entity.Employee;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Mapping(source = "firstName", target = "empFirstName")
    @Mapping(source = "lastName", target = "empLastName")
    @Mapping(source = "salary", target = "empSalary")
//    @Mapping(target = "fullName", ignore = true)
    @Mapping(expression = "java(entity.getFirstName() + ' ' + entity.getLastName())", target = "fullName")
    EmployeeDTO map(Employee entity);

    List<EmployeeDTO> map(List<Employee> entities);

//    @AfterMapping
//    default void handleFullName(Employee entity, @MappingTarget EmployeeDTO dto) {
//        if (entity.getFirstName() != null && entity.getLastName() != null) {
//            dto.setFullName(entity.getFirstName() + " "+ entity.getLastName());
//        }
//    }

@AfterMapping
default void handleFullName(Employee entity, @MappingTarget EmployeeDTO dto) {
    String firstName = entity.getFirstName() != null ? entity.getFirstName() : "";
    String lastName = entity.getLastName() != null ? entity.getLastName() : "";
    dto.setFullName(firstName.trim() + " " + lastName.trim());
}


    @Mapping(source = "empFirstName", target = "firstName")
    @Mapping(source = "empLastName", target = "lastName")
    @Mapping(source = "empSalary", target = "salary")
    Employee unMap(EmployeeDTO dto);


    //Using in update
    //Note In this case there is new object generated
    @Mapping(source = "empFirstName", target = "firstName")
    @Mapping(source = "empLastName", target = "lastName")
    @Mapping(source = "empSalary", target = "salary")
    Employee unMap(EmployeeDTO dto,@MappingTarget Employee entity);
}

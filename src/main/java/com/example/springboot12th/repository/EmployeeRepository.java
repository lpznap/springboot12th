package com.example.springboot12th.repository;

import com.example.springboot12th.domain.Employee;
import com.example.springboot12th.response.EmployeeDepartmentResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDepartmentResponse getEmployeeDepartment(Integer id){
        //HQL
        Query query = entityManager
                .createNativeQuery("select id, firstname, lastname, 'IT' as department from EMPLOYEE where id = :ID", EmployeeDepartmentResponse.class);
        query.setParameter("ID", id);

        List<EmployeeDepartmentResponse> result = query.getResultList();

        System.out.println("Result : =====>" +result);

        if(!result.isEmpty()){
            return result.get(0);
        }
        return null;
    }

    @Transactional
    public void save(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> list(){
        //JPQL
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public List<Employee> getName(String firstName){
        Query query = entityManager.createQuery("from Employee o where o.firstName like :FIRSTNAME");
        query.setParameter("FIRSTNAME", "%"+firstName+"%");
        return query.getResultList();
    }

    public Employee get(Integer id){
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void delete(Employee employee){
        entityManager.remove(employee);
    }


}

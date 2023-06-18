package com.example.spring_data_jpa.dao;


import com.example.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository <Employee, Integer>  {

    public List <Employee> findAllByName (String name); //создали метод по определенным правилам.
    // В этом случае переопределять данный мето также не нужно
}

/*
Больше не прописываем методы. в первом generic указываем с каким типом entity будет работать данный repository.
второй generic означает тип primary key нашего entity. Главное заэкстендить JPARepository. Если предоставленных
методов недостаточно, можем без проблем добавить их в репозиторий
 */

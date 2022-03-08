package com.example.wsdevoir.service;

import com.example.wsdevoir.model.Employe;

import java.util.List;

public interface EmployeService {
    List<Employe> getAllEmploye();
    void saveEmploye(Employe employe);
    Employe getEmployeById(long id);
    void deleteEmployeById(long id);
}

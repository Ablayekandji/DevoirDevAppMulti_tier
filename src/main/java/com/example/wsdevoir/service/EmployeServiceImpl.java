package com.example.wsdevoir.service;

import com.example.wsdevoir.model.Employe;
import com.example.wsdevoir.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public List<Employe> getAllEmploye() {
        return this.employeRepository.findAll();
    }

    @Override
    public void saveEmploye(Employe employe) {
        this.employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(long id) {
        Optional<Employe> optional = this.employeRepository.findById(id);
        Employe employe=new Employe();
        if (optional.isPresent())
            employe=optional.get();
        else
            throw new RuntimeException("un employe avec cet id n'existe pas");
        return employe;
    }

    @Override
    public void deleteEmployeById(long id) {
        this.employeRepository.deleteById(id);
    }
}

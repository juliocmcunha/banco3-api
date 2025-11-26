package org.juliocmcnha.banco3.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Client
{
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    private int idade;

    private double dinheiro;

    public Client(String name, String cpf, String pass, LocalDate bornDate)
    {
        this.nome = name;
        this.cpf = cpf;
        this.senha = pass;

        idade = (int)ChronoUnit.YEARS.between(LocalDate.now(), bornDate);
    }

    /// GETTERS&SETTERS
    public String getName(){return nome;}
    public String getCpf(){return cpf;}
    public String getEmail(){return email;}
    public String getPass() {return senha;}

    public int getAge(){return idade;}

    public double getMoney(){return dinheiro;}


    public void setName(String newName){nome=newName;}
    public void setEmail(String newEmail){email=newEmail;}
    public void setCpf(String newCpf) {cpf=newCpf;}
    public void setPass(String newPass) {senha=newPass;}
    
    public void setMoney(double newMoney) {dinheiro=newMoney;}
    public void setAge(int newAge) {idade=newAge;}
}

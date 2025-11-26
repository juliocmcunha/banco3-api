package org.juliocmcnha.banco3.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.juliocmcnha.banco3.data.ClientManage;
import org.juliocmcnha.banco3.entity.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ClientController
{
	@PostMapping("/login")
    public static ResponseEntity<Map<String, Object>> userLogin(@RequestBody Client clientVerify)
    {
		try
		{
			Client current = ClientManage.GetClient(clientVerify.getCpf());
			if(current.getPass().equals(current.getPass()))
			{
				LocalDateTime age = LocalDateTime.now().minus(current.getAge(), ChronoUnit.YEARS);
				
				Map<String, Object> dados = Map.of("status", "sucesso",
	                    "name", current.getName(),
	                    "email", current.getEmail(),
	                    "cpf", current.getCpf(),
	                    "bornAge", age,
	                    "money", current.getMoney()
	            );
				
	            System.out.println("Logou com sucesso!");
	            return ResponseEntity.ok(dados);
			}
			throw new Exception("Usuário ou senha incorretos!");
		}catch(Exception ex)
		{
			System.out.println("Não foi possivel fazer login! "+ex.getMessage());
		}
		return null;
    }
	
	@PostMapping("/register")
	public static void userReg(@RequestBody Client newClient)
	{
		try
		{
			ClientManage.RegistryClient(newClient);
		}catch(Exception ex)
		{
			System.out.println("Não foi possivel cadastrar o cliente! Erro: "+ex.getMessage());
		}
	}
	
	@PutMapping("/{userCPF}")
	public static void userUpd(@PathVariable String userCPF, @RequestBody Client updClient)
	{
		try
		{
			ClientManage.UpdateClient(userCPF, updClient);
		}catch(Exception ex)
		{
			System.out.println("Erro ao tentar atualizar os registros do cliente! "+ex.getMessage());
		}
	}
	
	@DeleteMapping("/{userCPF}")
	public static void userDel(@PathVariable String userCPF)
	{
		try
		{
			ClientManage.DelClient(userCPF);
		}catch(Exception ex)
		{
			System.out.println("Erro ao tentar deletar cliente! "+ex.getMessage());
		}
	}
}

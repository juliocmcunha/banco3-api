package org.juliocmcnha.banco3.data;

import org.juliocmcnha.banco3.entity.Client;

import java.util.ArrayList;

public class ClientManage
{
    private static final ArrayList<Client> clients = new ArrayList<>();

    private static Client findClient(String cpf)
    {
        for(Client client : clients)
        {
            if(client.getCpf().equals(cpf))
            {
                return client;
            }
        }
        return null;
    }


    public static void RegistryClient(Client newClient) throws Exception
    {
        Client get = findClient(newClient.getCpf());
        if(get != null)
        {
            throw new Exception("Cliente ja cadastrado!");
        }

        clients.add(newClient);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void UpdateClient(String cpf, Client newConfig) throws Exception
    {
        Client get = findClient(cpf);
        if(get == null) throw new Exception("Cliente não cadastrado para atualização!");

        get.setName(newConfig.getName());
        get.setEmail(newConfig.getEmail());
        
        System.out.println("Usuário atualizado com sucesso!");
    }

    public static Client GetClient(String cpf) throws Exception
    {
        Client get = findClient(cpf);
        if(get == null) throw new Exception("Cpf inválido!");

        return get;
    }

    public static void DelClient(String cpf) throws Exception
    {
        Client get = findClient(cpf);
        if(get == null) throw new Exception("Cliente não cadastrado para exclusão!");
        clients.remove(get);
        
        System.out.println("Usuário removido com sucesso!");
    }
}

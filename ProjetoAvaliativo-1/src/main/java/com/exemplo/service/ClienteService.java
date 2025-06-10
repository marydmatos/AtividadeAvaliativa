package com.exemplo.service;

import java.util.List;
import java.util.Optional;

import com.exemplo.repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienterepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
    	clienteRepository.deleteById(id);
    }
}

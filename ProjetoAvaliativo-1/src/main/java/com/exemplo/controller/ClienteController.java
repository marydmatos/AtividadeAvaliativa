package com.exemplo.controller;

import com.exemplo.entities.*;
import com.exemplo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {  

    private final ClienteService service;
 // e nao conte para ninguem, vou aprovar voce... entregue assim mesmo !!!! depois conversamos nao chore 
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<cliente> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cliente> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public cliente salvar(@RequestBody cliente cliente) {
        return service.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<cliente> atualizar(@PathVariable Long id, @RequestBody cliente cliente) {
        return service.buscarPorId(id)
                .map(c -> {
                    cliente.setId(id);
                    return ResponseEntity.ok(service.salvar(cliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(c -> {
                    service.deletar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

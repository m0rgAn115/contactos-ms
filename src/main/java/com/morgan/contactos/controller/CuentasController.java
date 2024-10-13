package com.morgan.contactos.controller;

import com.morgan.contactos.entity.Contacto;
import com.morgan.contactos.entity.Cuenta;
import com.morgan.contactos.service.IContactoService;
import com.morgan.contactos.service.client.CuentasFeingClient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CuentasController {

    IContactoService contactoService;
    CuentasFeingClient cuentasFeingClient;

    @PostMapping("/crear")
    public ResponseEntity<Contacto> createAccount(@Valid @RequestBody Contacto contacto) {
            Cuenta cuenta = cuentasFeingClient.getAccount(contacto.getIdCuentaContacto()).getBody();
            contactoService.crearContacto(contacto);
            return new ResponseEntity<>(contacto, HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public ResponseEntity<List<Contacto>> getContactos() {
        List<Contacto> cuentas = contactoService.getContactos();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/get/usuario/{id}")
    public ResponseEntity<List<Contacto>> getCuentasByUsuarioID(@PathVariable("id") Long idUsuario) {
        List<Contacto> cuentas =  contactoService.getContactosByUsuarioId(idUsuario);
        return ResponseEntity.ok(cuentas);
    }

}

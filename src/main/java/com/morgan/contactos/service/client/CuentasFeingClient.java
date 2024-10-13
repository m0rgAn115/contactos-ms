package com.morgan.contactos.service.client;

import com.morgan.contactos.entity.Cuenta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cuentas")
public interface CuentasFeingClient {

    @GetMapping("/api/get/{id}")
    public ResponseEntity<Cuenta> getAccount(@PathVariable("id") Long idCuenta);
}

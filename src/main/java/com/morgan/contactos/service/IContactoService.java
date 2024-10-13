package com.morgan.contactos.service;

import com.morgan.contactos.entity.Contacto;

import java.util.List;

public interface IContactoService {
    void crearContacto(Contacto contacto);

    List<Contacto> getContactosByUsuarioId(Long id);

    List<Contacto> getContactos();


}

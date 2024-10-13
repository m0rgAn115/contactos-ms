package com.morgan.contactos.service.Impl;

import com.morgan.contactos.entity.Contacto;
import com.morgan.contactos.repository.ContactoRepository;
import com.morgan.contactos.service.IContactoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactoServiceImp implements IContactoService {

    private final ContactoRepository contactoRepository;


    @Override
    public void crearContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public List<Contacto> getContactosByUsuarioId(Long id) {
        return contactoRepository.findByIdUsuarioCreador(id);
    }

    @Override
    public List<Contacto> getContactos() {
        return contactoRepository.findAll();
    }
}

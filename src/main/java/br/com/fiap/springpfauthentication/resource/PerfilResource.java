package br.com.fiap.springpfauthentication.resource;


import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import br.com.fiap.springpfauthentication.repository.PermissaoRepository;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

    @Autowired
    PerfilRepository repo;

    @Autowired
    PermissaoRepository permissaoRepository;


    @Autowired
    SistemaRepository sistemaRepository;


    @GetMapping
    public List<Perfil> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Perfil save(@RequestBody Perfil p) {
        p.setId( null );
        return repo.save( p );
    }


    @Transactional
    @PostMapping(value = "/{id}/permissoes")
    public Permissao addPermissao(@PathVariable Long id, @RequestBody Permissao p) {
        if (Objects.isNull( p )) return null;
        if (Objects.nonNull( p.getId() )) {
            p = permissaoRepository.findById( p.getId() ).orElseThrow();
        }
        Perfil perfil = repo.findById( id ).orElseThrow();
        if (Objects.nonNull( p.getSistema().getId() )) {
            var sistema = sistemaRepository.findById( p.getSistema().getId() ).orElseThrow();
            p.setSistema( sistema );
        }
        perfil.getPermissoes().add( p );
        return permissaoRepository.save( p );
    }

    @GetMapping(value = "/{id}/permissoes")
    public List<Permissao> getPermissao(@PathVariable Long id) {
        Perfil perfil = repo.findById( id ).orElseThrow();
        return perfil.getPermissoes().stream().toList();
    }




}

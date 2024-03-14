package br.com.fiap.springpfauthentication.resource;


import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PermissaoRepository;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoResource {

    @Autowired
    PermissaoRepository repo;

    @Autowired
    SistemaRepository sistemaRepository;


    @GetMapping
    public List<Permissao> findAll() {
        return repo.findAll();
    }


    @GetMapping(value = "/{id}")
    public Permissao findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Permissao save(@RequestBody Permissao p) {

        if (Objects.isNull( p )) return null;

        p.setId( null );

        if (Objects.nonNull( p.getSistema().getId() )) {
            var sistema = sistemaRepository.findById( p.getSistema().getId() ).orElseThrow();
            p.setSistema( sistema );
        }

        return repo.save( p );

    }


}

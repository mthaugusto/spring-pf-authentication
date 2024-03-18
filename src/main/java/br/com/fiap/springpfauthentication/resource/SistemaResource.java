package br.com.fiap.springpfauthentication.resource;


import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import br.com.fiap.springpfauthentication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @GetMapping(value = "/{id}/responsaveis")
    public Set<Usuario> getResponsaveis(@PathVariable Long id) {
        Sistema sistema = repo.findById( id ).orElseThrow();
        return sistema.getResponsaveis();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema s) {
        if (Objects.isNull( s )) return null;
        s.setId( null );

        return repo.save( s );
    }

    @Transactional
    @PostMapping(value = "/{id}/responsaveis")
    public Sistema addResponsavel(@PathVariable Long id, @RequestBody Usuario responsavel) {

        if (Objects.isNull( responsavel )) return null;

        Sistema sistema = repo.findById( id ).orElseThrow();

        //Se e o usuário mandar o id de um usuário eu verifico....
        //Será que já tenho um usuário com o id informado no banco de dados?
        //Se tiver ótimo; mas se ele me manda um id de usuário que não existe?
        // eu considero isso um envio malicioso e retorno um erro
        if (Objects.nonNull( responsavel.getId() )) {
            responsavel = usuarioRepository.findById( responsavel.getId() ).orElseThrow();
        }

        //Adiciono o responsável à lista de responsáveis
        sistema.getResponsaveis().add( responsavel );

        //Como confio no JPA e na transação, eu nem dou o comando de salvar o usuário.
        //Eu já mando pegar a listagem de responsáveis do sistema
        return sistema;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipam.resource;

import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.service.TarefaService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Cueio
 */
@Path("tarefa") //domínio/contextPath/api/v1/tarefa
public class TarefaResource {

    @Inject
    private TarefaService tarefaService;

    @GET
    @Path("list") //domínio/contextPath/api/v1/tarefa/list
    public List<Tarefa> listarTodos()
    {
        List<Tarefa> tarefaList = tarefaService.listarTodos();
        return tarefaList;
    }

    @GET
    @Path("user_list") //domínio/contextPath/api/v1/tarefa/user_list
    public List<Tarefa> listarPorUsuario (Long id)
    {
        Usuario user = usuarioService.localizarPorId(id);
        return entityManager.createQuery(
                "select t from Tarefa t where t.usuario = :user", Tarefa.class)
                .setParameter("user", user)
                .getResultList();
        return ResultList;
    }

}
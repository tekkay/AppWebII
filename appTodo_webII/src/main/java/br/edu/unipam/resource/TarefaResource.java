package br.edu.unipam.resource;

import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.service.TarefaService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("tarefa")
public class TarefaResource {

    @Inject
    private TarefaService tarefaService;

    @GET
    @Path("list")
    public Response listar() {
        List<Tarefa> tarefaList = tarefaService.listarTodos();
        return Response.ok(tarefaList).build();
    }

    @GET
    @Path("listByUser/{id}")
    public Response listarPorUsuario(@PathParam("id") Long id) {
        List<Tarefa> tarefaList = tarefaService.listarPorUsuario(id);
        return Response.ok(tarefaList).build();
    }
}

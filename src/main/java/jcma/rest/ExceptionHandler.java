package jcma.rest;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<NoResultException> {
// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ExceptionMapper ---------------------

    @Override
    public Response toResponse(NoResultException exception)
    {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

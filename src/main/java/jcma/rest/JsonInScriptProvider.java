package jcma.rest;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces({"application/json-in-script"})
public class JsonInScriptProvider extends JacksonJsonProvider {
// ------------------------------ FIELDS ------------------------------

    @Context
    private UriInfo uriInfo;

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface MessageBodyWriter ---------------------

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException
    {
        final String methodName = uriInfo.getQueryParameters().getFirst("methodName");
        if (StringUtils.isBlank(methodName)) {
            super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
        } else {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, outputStream);
            final StringBuilder response = new StringBuilder(methodName).append("(");
            response.append(outputStream.toString()).append(")");
            entityStream.write(response.toString().getBytes());
        }
    }

    @Override
    protected boolean isJsonType(MediaType mediaType)
    {
        if (super.isJsonType(mediaType)) {
            return true;
        }
        if (mediaType != null) {
            String subtype = mediaType.getSubtype();
            return "json-in-script".equalsIgnoreCase(subtype);
        }
        return true;
    }
}

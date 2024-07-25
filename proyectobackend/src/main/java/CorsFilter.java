import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
	
	/** @description Lista de las url permitidas por nuestra api*/
	
	private static final List<String> ALLOWED_ORIGINS = Arrays.asList(
			"http://localhost:4200",
			"http://localhost:58184"
			
			);

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		
		String origin = requestContext.getHeaderString("Origin");
		if (ALLOWED_ORIGINS.contains(origin)) {
			// Agregar encabezados CORS
			responseContext.getHeaders().add("Access-Control-Allow-Origin", origin);
			responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
			responseContext.getHeaders().add("Access-Control-Allow-Headers",
					"origin, content-type, accept, authorization");
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
			responseContext.getHeaders().add("Access-Control-Max-Age", "3600"); // Cache preflight response

			// Log para verificar que los encabezados se están añadiendo
			System.out.println("CORS headers added");
			System.out.println("Access-Control-Allow-Origin: "
					+ responseContext.getHeaders().getFirst("Access-Control-Allow-Origin"));
			System.out.println("Access-Control-Allow-Credentials: "
					+ responseContext.getHeaders().getFirst("Access-Control-Allow-Credentials"));
			System.out.println("Access-Control-Allow-Headers: "
					+ responseContext.getHeaders().getFirst("Access-Control-Allow-Headers"));
			System.out.println("Access-Control-Allow-Methods: "
					+ responseContext.getHeaders().getFirst("Access-Control-Allow-Methods"));
		}
	}
}

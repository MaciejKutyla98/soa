package pl.edu.agh.soa.lab;

import com.auth0.jwt.exceptions.JWTCreationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
@Api(value = "Authentication Controller")
public class AuthController {
    @Inject
    AuthService authService;

    private void authorize(String username, String password) throws NotAuthorizedException{
        if(!(username.equals("adminadmin") && password.equals("passwordpassword")))
            throw new NotAuthorizedException("Invalid credentials");
    }

    @GET
    @Path("/auth")
    @ApiOperation(
            value = "Returns a tokenr",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource."),
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public Response createToken(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (username == null || password == null)
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("WWW-Authenticate", "Missing credentials").build();

        try {
            authorize(username, password);
            String token = authService.generateToken();
            return Response.status(Response.Status.OK).entity(token).build();
        } catch (NotAuthorizedException e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Bearer realm=\"DefaultRealm\"")
                    .build();
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

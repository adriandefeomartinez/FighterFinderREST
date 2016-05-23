/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enma.proven.ffinder.resources;

import com.google.gson.Gson;
import enma.proven.ffinder.entities.ACharacter;
import enma.proven.ffinder.services.CharacterService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adrian
 */
@Path("character")
public class CharacterResource {
    CharacterService aCharService;

    public CharacterResource() {
        aCharService = new CharacterService();
    }
    
    public CharacterResource(@Context ServletContext context) {
        aCharService = new CharacterService();
    }
    
    
    /**
     * getCharacterFromDatabaseUserUse
     * Function to return all the character from one game
     * @param aGameID
     * @param aUserID
     * @return Response
     */
    @Path("getCharacterUserUse")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterFromDatabaseUserUse(@FormParam("gameID") int aGameID, @FormParam("userID") int aUserID)
    {
        aCharService = new CharacterService();
        //Collection<ACharacter> aCharCollection = aCharService.getAllCharacterFromGame(aGameID, aUserID);
        //GenericEntity<Collection<ACharacter>> result = new GenericEntity<Collection<ACharacter>>(aCharCollection){};
        Gson gson = new Gson();
        List<ACharacter> aList = aCharService.getAllCharacterUserUseFromGame(aGameID, aUserID);
        HashMap<String, List<ACharacter>> aMap = new HashMap();
        aMap.put("characterUse", aList);
        String jsonResult = gson.toJson(aMap);
        return Response.ok().entity(jsonResult).build();       
    }
    
    /**
     * getCharacterFromDatabaseUserNoUse
     * Function to return all the character from one game
     * @param aGameID
     * @param aUserID
     * @return Response
     */
    @Path("getCharacterUserNoUse")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterFromDatabaseUserNoUse(@FormParam("gameID") int aGameID, @FormParam("userID") int aUserID)
    {
        aCharService = new CharacterService();
        //Collection<ACharacter> aCharCollection = aCharService.getAllCharacterFromGame(aGameID, aUserID);
        //GenericEntity<Collection<ACharacter>> result = new GenericEntity<Collection<ACharacter>>(aCharCollection){};
        Gson gson = new Gson();
        List<ACharacter> aList = aCharService.getAllCharacterUserNoUseFromGame(aGameID, aUserID);
        HashMap<String, List<ACharacter>> aMap = new HashMap();
        aMap.put("characterDontUse", aList);
        String jsonResult = gson.toJson(aMap);
        return Response.ok().entity(jsonResult).build();       
    }
    
    /**
     * addCharacterToUser
     * Function to add a cahracter to a user.
     * @param uID
     * @param cID
     * @return Response
     */
    @POST
    @Path("addCharToUser")
    public Response addCharacterToUser(@FormParam("userID") int uID, @FormParam("charID") int cID)
    {
        aCharService = new CharacterService();
        int result = aCharService.addCharacerToUser(uID, cID);

        return Response.ok(result).build();
    }
    
    
    /**
     * deletCharacterFromUser
     * Function to delete a character from a User
     * @param uID
     * @param cID
     * @return Response
     */
    @POST
    @Path("deleteCharUser")
    public Response deletCharacterFromUser(@FormParam("userid") int uID, @FormParam("characterid") int cID)
    {
        aCharService = new CharacterService();
        int result = aCharService.deleteCHaracterFromUser(uID, cID);
        return Response.ok(result).build();
    }
    
    
    /**
     * addCharacterToGame
     * Function to add a character to a game
     * @param cName
     * @param gID
     * @return Response
     */
    @POST
    @Path("addCharacterToGame")
    public Response addCharacterToGame(@FormParam("cName") String cName, @FormParam("gID") int gID)
    {
        aCharService = new CharacterService();
        int result = aCharService.addCharacterToGame(cName, gID);
        return Response.ok(result).build();
    }
    
    /**
     * modCharacterFromGame
     * Function to add a character to a game
     * @param cName
     * @param gID
     * @return Response
     */
    @POST
    @Path("modCharacterFromGame")
    public Response modCharacterFromGame(@FormParam("cName") String cName, @FormParam("gID") int gID)
    {
        aCharService = new CharacterService();
        int result = aCharService.modCharacterFromGame(cName, gID);
        return Response.ok(result).build();
    }
    
}

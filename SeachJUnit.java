import static org.junit.Assert.*;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SeachJUnit {
	private WebResource webResource;
	
	@Before
	public void setUp() throws Exception {
		 Client client = new Client();
		 webResource = client.resource("https://itunes.apple.com/");
	}
	
	public ClientResponse getServiceResponse(MultivaluedMap<String, String> requestParsms) {
		ClientResponse response =  
                webResource
                         .path("/search")
                         .queryParams(requestParsms)
                         .get(ClientResponse.class);
		return response;
	}

	
	@Test
	public void testCase1() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "US");
		params.add("limit", "50");
		params.add("media", "all");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			
			assertEquals(50, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("USA", obj.get("country"));
				assertNotEquals("", obj.get("kind"));
			}
		}
	}
	
	@Test
	public void testCase2() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "DO");
		params.add("limit", "100");
		params.add("media", "software");
		
		ClientResponse response = getServiceResponse(params);
		
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(100, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("DO", obj.get("country"));
				assertNotEquals("software", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase3() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", ""); 
		params.add("country", "US");
		params.add("limit", "150");
		params.add("media", "shortFilm");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(150, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("US", obj.get("country"));
				assertNotEquals("shortFilm", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase4() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("limit", "200");
		params.add("country", "");
		params.add("media", "ebook");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(200, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("", obj.get("country"));
				assertNotEquals("ebook", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase5() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "PPP");
		params.add("limit", "150");
		params.add("media", "tvShow");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(200, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("PPP", obj.get("country"));
				assertNotEquals("tvShow", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase6() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "US");
		params.add("limit", "50");
		params.add("media", "all");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(50, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("US", obj.get("country"));
				assertNotEquals("all", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase7() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "DO");
		params.add("limit", "100");
		params.add("media", "software");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(100, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("DO", obj.get("country"));
				assertNotEquals("software", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase8() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", ""); 
		params.add("country", "US");
		params.add("limit", "150");
		params.add("media", "podcast");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(150, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("US", obj.get("country"));
				assertNotEquals("podcast", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase9() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "");
		params.add("limit", "150");
		params.add("media", "music");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(150, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("", obj.get("country"));
				assertNotEquals("music", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase10() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "jack johnson"); 
		params.add("country", "DO");
		params.add("limit", "100");
		params.add("media", "software");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(100, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("DO", obj.get("country"));
				assertNotEquals("software", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase11() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", ""); 
		params.add("country", "PPP");
		params.add("limit", "150");
		params.add("media", "podcast");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(1500, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("PPP", obj.get("country"));
				assertNotEquals("podcast", obj.get("kind"));
			}
		}
	}
	@Test
	public void testCase12() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", "US"); 
		params.add("country", "US");
		params.add("limit", "150");
		params.add("media", "pencil");
		
		ClientResponse response = getServiceResponse(params);
		
		assertEquals(200,response.getStatus());
		{
			String responseMessage = response.getEntity(String.class);

			JSONObject json = new JSONObject(responseMessage);
			JSONArray resultsArray =  json.getJSONArray("results");
			assertEquals(150, resultsArray.length());
			
			for(int iCount = 0; iCount < resultsArray.length() ; iCount++) {
				JSONObject obj = resultsArray.getJSONObject(iCount);
				assertEquals("US", obj.get("country"));
				assertNotEquals("pencil", obj.get("kind"));
			}
		}
	}
	
	

}

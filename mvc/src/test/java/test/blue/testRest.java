package test.blue;

import com.blue.domin.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/6
 **/
public class testRest {
    static String REST_SERVICE_URI = "http://localhost:8080/mvc/api/user_resource";

    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user_query?id=123", User.class);
        System.out.println(user);
    }

    private static void updateUser(){
        System.out.println("Testing updateUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("123","old");
        restTemplate.put(REST_SERVICE_URI+"/user_update/123", user, User.class);

        //使用resttemplate的put方法得不到返回值
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> userRequest = new HttpEntity<User>(user, headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange(REST_SERVICE_URI+"/user_update/123", HttpMethod.PUT, userRequest, User.class);
        System.out.println(responseEntity.getBody().toString());
    }

    private static void updateUserMap(){
        System.out.println("Testing updateUserMap API----------");
        RestTemplate restTemplate = new RestTemplate();
        Map map = new HashMap<String,String>();
        map.put("name","mm");
        restTemplate.put(REST_SERVICE_URI+"/user_update/map", map, Map.class);
    }

    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("123","old");
        user = restTemplate.postForObject(REST_SERVICE_URI+"/user_create", user, User.class);
        System.out.println(user.toString());

        ResponseEntity<User> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI+"/user_create", user, User.class);
        System.out.println(responseEntity.getBody().toString());
    }

    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user_delete?id=123");
        System.out.println("deleted");

        //使用resttemplate的put方法得不到返回值
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> userRequest = new HttpEntity<User>(headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange(REST_SERVICE_URI+"/user_delete", HttpMethod.DELETE, userRequest, User.class);
        System.out.println(responseEntity.getBody().toString());
    }

    public static void main(String args[]){
        getUser();
        updateUser();
        updateUserMap();
        createUser();
        deleteUser();
    }

}

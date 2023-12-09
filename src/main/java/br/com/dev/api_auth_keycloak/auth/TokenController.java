package br.com.dev.api_auth_keycloak.auth;

import br.com.dev.api_auth_keycloak.models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/v1/token")
public class TokenController {


  @PostMapping("/")
  public ResponseEntity<String> token(@RequestBody User user) {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    formData.add("username", user.getUsername());
    formData.add("password", user.getPassword());
    formData.add("client_id", user.getClientId());
    formData.add("grant_type", user.getGrantType());

    RestTemplate restTemplate = new RestTemplate();

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

    return restTemplate.postForEntity(
            "http://0.0.0.0:8080/realms/labs/protocol/openid-connect/token",
            request,
            String.class);
  }

}

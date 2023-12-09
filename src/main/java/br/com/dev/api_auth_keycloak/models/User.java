package br.com.dev.api_auth_keycloak.models;

import lombok.Data;

@Data
public class User {
  private String username;
  private String password;
  private String clientId;
  private String grantType;
}

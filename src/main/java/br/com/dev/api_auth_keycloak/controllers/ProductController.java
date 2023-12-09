package br.com.dev.api_auth_keycloak.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

  @RequestMapping
  @PreAuthorize("hasRole('USER')")
  public String list(){
    return "Listing all products";
  }

  @PostMapping
  public String create(){
    return "Creating a product";
  }

}

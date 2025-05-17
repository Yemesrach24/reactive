//package com.react.reactive.service;
//
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.admin.client.resource.UsersResource;
//import org.keycloak.representations.idm.CredentialRepresentation;
//import org.keycloak.representations.idm.UserRepresentation;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//import javax.ws.rs.core.Response;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class KeycloakCrud {
//
//    private final Keycloak keycloak;
//    private final String realm;
//
//    public KeycloakCrud(Keycloak keycloak, @Value("${custom.keycloak.realm}") String realm) {
//        this.keycloak = keycloak;
//        this.realm = realm;
//    }
//
//    public Mono<Boolean> createUser(String username, String password) {
//        try {
//            List<UserRepresentation> users = keycloak.realm(realm).users().search(username);
//            UserRepresentation user = new UserRepresentation();
//
//            CredentialRepresentation credential = new CredentialRepresentation();
//            credential.setType(CredentialRepresentation.PASSWORD);
//            credential.setValue(password);
//            user.setCredentials(Collections.singletonList(credential));
//            user.setEmailVerified(true);
//            user.setEnabled(true);
//
//            if (users != null && !users.isEmpty()) {
//                try {
//                    user = users.get(0);
//                    user.setAttributes(Collections.emptyMap());
//                    UsersResource usersResource = keycloak.realm(realm).users();
//                    usersResource.get(user.getId()).update(user);
//                    return Mono.just(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return Mono.just(false);
//                }
//            } else {
//                user.setUsername(username);
//                Response response = keycloak.realm(realm).users().create(user);
//
//                if (response.getStatus() == 201) {
//                    System.out.println("User created successfully");
//                    return Mono.just(true);
//                } else if (response.getStatus() == 409) {
//                    System.out.println("User already exists in Keycloak. Status code: " + response.getStatus());
//                    return Mono.just(false);
//                } else {
//                    System.out.println("Unknown status code: " + response.getStatus());
//                    return Mono.just(false);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error creating user");
//            e.printStackTrace();
//            return Mono.just(false);
//        }
//    }
//}

//package com.react.reactive.service;
//
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.admin.client.KeycloakBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class KeycloakConfiguration {
//
//    @Value("${custom.keycloak.ussd.server-url}")
//    private String serverUrl;
//
//    @Value("${custom.keycloak.realm}")
//    private String realm;
//
//    @Value("${custom.keycloak.ussd.client-id}")
//    private String clientId;
//
//    @Value("${custom.keycloak.ussd.client-secret}")
//    private String clientSecret;
//
//    @Value("${custom.keycloak.ussd.username}")
//    private String username;
//
//    @Value("${custom.keycloak.ussd.password}")
//    private String password;
//
//    @Bean
//    @Primary
//    public Keycloak keycloak() {
//        return KeycloakBuilder.builder()
//            .serverUrl(serverUrl)
//            .realm(realm)
//            .username(username)
//            .password(password)
//            .clientId(clientId)
//            .clientSecret(clientSecret)
//            .build();
//    }
//
//    @Bean(name = "keycloakUssd")
//    public Keycloak keycloakUssd(
//        @Value("${jhipster.custom.keycloak.ussd.server-url}") String ussdServerUrl,
//        @Value("${jhipster.custom.keycloak.ussd.realm}") String ussdRealm,
//        @Value("${jhipster.custom.keycloak.ussd.client-id}") String ussdClientId,
//        @Value("${jhipster.custom.keycloak.ussd.client-secret}") String ussdClientSecret) {
//        return KeycloakBuilder.builder()
//            .serverUrl(ussdServerUrl)
//            .realm(ussdRealm)
//            .clientId(ussdClientId)
//            .clientSecret(ussdClientSecret)
//            .build();
//    }
//}

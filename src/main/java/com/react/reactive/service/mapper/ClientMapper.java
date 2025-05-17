//package com.react.reactive.service.mapper;
//
//import com.react.reactive.domain.Client;
//import com.react.reactive.service.dto.ClientRequestDto;
//import com.react.reactive.service.dto.ClientRecieverDto;
//
//public class ClientMapper {
//
//    public static Client toEntity(ClientRequestDto dto) {
//        Client client = new Client();
//        client.setFirstName(dto.getFirstName());
//        client.setLastName(dto.getLastName());
//        client.setEmail(dto.getEmail());
//        client.setPhoneNumber(dto.getPhoneNumber());
//        return client;
//    }
//
//    public static ClientRequestDto toDto(Client client) {
//        ClientRequestDto dto = new ClientRequestDto();
//        dto.setFirstName(client.getFirstName());
//        dto.setLastName(client.getLastName());
//        dto.setEmail(client.getEmail());
//        dto.setPhoneNumber(client.getPhoneNumber());
//        return dto;
//    }
//
//    public static ClientRecieverDto toRecieverDto(Client client) {
//        ClientRecieverDto dto = new ClientRecieverDto();
//        dto.setFirstName(client.getFirstName());
//        dto.setPhoneNumber(client.getPhoneNumber());
//        return dto;
//    }
//}
package com.react.reactive.service.mapper;

import com.react.reactive.domain.Client;
import com.react.reactive.service.dto.ClientDto;
import com.react.reactive.service.dto.ClientDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    public ClientDtoResponse toDtoResponse(Client entity) {
        ClientDtoResponse dto = new ClientDtoResponse();
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}

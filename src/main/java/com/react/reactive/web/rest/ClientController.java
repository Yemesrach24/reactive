package com.react.reactive.web.rest;

import com.react.reactive.domain.Client;
import com.react.reactive.service.ClientService;
import com.react.reactive.service.dto.ClientDto;
import com.react.reactive.service.dto.ClientDtoResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customer")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //    @PostMapping("/save")
//    public Mono<Client> saveClient(@RequestBody Client client) {
//        return clientService.createClient(client);
//    }
//}
    @PostMapping("/save")
    public Mono<ClientDtoResponse> saveClient(@RequestBody ClientDto client) {
        System.out.println("Incoming DTO: " + client.getFirstName() + " " + client.getLastName());

        return clientService.createClient(client);
    }
    }

package com.react.reactive.service;
import com.react.reactive.domain.Client;
import com.react.reactive.repository.ClientRepository;
import com.react.reactive.service.dto.ClientDto;
import com.react.reactive.service.dto.ClientDtoResponse;
import com.react.reactive.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }
    public Mono<ClientDtoResponse> createClient(ClientDto clientDto) {
       System.out.println("IncomingDTO: "+ clientDto.getFirstName() + " " + clientDto.getFirstName());
        Client client = clientMapper.toEntity(clientDto);
        return clientRepository.save(client)

            .doOnSuccess(saved -> System.out.println("Saved Client Object: " + saved))
            .map(clientMapper::toDtoResponse);

    }
}


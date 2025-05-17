////package com.react.reactive.repository;
////
////import com.react.reactive.domain.Client;
////import org.springframework.data.r2dbc.repository.R2dbcRepository;
////import org.springframework.stereotype.Repository;
////
////@Repository
////public interface ClientRepository extends R2dbcRepository<Client, Long> {
////
////}
//package com.react.reactive.repository;
//
//import com.react.reactive.domain.Client;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.r2dbc.convert.R2dbcConverter;
//import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
//import org.springframework.data.r2dbc.repository.Query;
//import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.r2dbc.core.DatabaseClient;
//import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
///**
// * Spring Data R2DBC repository for the {@link Client} entity.
// */
//@Repository
//public interface ClientRepository extends R2dbcRepository<Client, Long>, ClientRepositoryInternal {
//    Mono<Client> create(Client client);
//}
//
//interface ClientRepositoryInternal {
//    Mono<Client> create(Client client);
//}
package com.react.reactive.repository;

import com.react.reactive.domain.Client;
import com.react.reactive.service.dto.ClientDto;
import com.react.reactive.service.dto.ClientDtoResponse;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends R2dbcRepository<Client, Long> {
    // No need for custom create method as save() is provided by R2dbcRepository
    Mono<ClientDtoResponse> save(ClientDto clientDto0);
}

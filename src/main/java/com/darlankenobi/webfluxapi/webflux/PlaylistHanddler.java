package com.darlankenobi.webfluxapi.webflux;

import com.darlankenobi.webfluxapi.document.Playlist;
import com.darlankenobi.webfluxapi.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Component
@AllArgsConstructor
public class PlaylistHanddler {

    private final PlaylistService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        var id =  request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        var playlist =  request.bodyToMono(Playlist.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlist.flatMap(service::save), Playlist.class);
    }
}

package com.darlankenobi.webfluxapi.controller;

import com.darlankenobi.webfluxapi.document.Playlist;
import com.darlankenobi.webfluxapi.dto.IssNotification;
import com.darlankenobi.webfluxapi.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.time.Duration;

@RestController
@AllArgsConstructor
@RequestMapping("playlists")
public class PlaylistController {
    private final PlaylistService service;

    @GetMapping
    public Flux<Playlist> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Playlist> findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<Playlist> findById(@RequestBody Playlist playlist){
        return service.save(playlist);
    }

    @GetMapping(value = "/events")
    public Flux<Tuple2<Long, IssNotification>> findByEvents() throws InterruptedException {
        Flux<Long> interval =  Flux.interval(Duration.ofSeconds(10));
        Flux<IssNotification> events = service.findNotifications();
        System.out.println("Passsou aqui.");
        return Flux.zip(interval, events);
    }

}

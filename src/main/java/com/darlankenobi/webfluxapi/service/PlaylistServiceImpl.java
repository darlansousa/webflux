package com.darlankenobi.webfluxapi.service;

import com.darlankenobi.webfluxapi.client.ISSClient;
import com.darlankenobi.webfluxapi.document.Playlist;
import com.darlankenobi.webfluxapi.dto.IssNotification;
import com.darlankenobi.webfluxapi.dto.Person;
import com.darlankenobi.webfluxapi.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository repository;
    private final ISSClient issClient;
    private final WebClient client = WebClient.create("http://api.open-notify.org");

    @Override
    public Flux<Playlist> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return repository.save(playlist);
    }

    @Override
    public Flux<IssNotification> findNotifications() {
        Mono<IssNotification> issNotificationMono = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);

        Mono<IssNotification> issNotificationMono2 = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);

        Mono<IssNotification> issNotificationMono3 = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);

        Mono<IssNotification> issNotificationMono4 = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);

        Mono<IssNotification> issNotificationMono5 = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);


        Mono<IssNotification> issNotificationMono6 = client.get().uri("/astros.json")
                .retrieve()
                .bodyToMono(IssNotification.class);


        return Flux.concat(
                issNotificationMono,
                issNotificationMono2,
                issNotificationMono3,
                issNotificationMono4,
                issNotificationMono5,
                issNotificationMono6
        );
    }
}

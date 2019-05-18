package com.example.demo;

import reactor.core.publisher.Mono;

public interface LinkRepository {

    Mono<String> save(Link link);

    Mono<Link> findByKey(String key);
}

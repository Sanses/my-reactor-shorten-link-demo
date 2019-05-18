package com.example.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    Mono<String> shortenLink(String link) {
        String randomKey = RandomStringUtils.randomAlphabetic(6);
        return linkRepository.save(new Link(link, randomKey))
                             .map(result -> result.getKey());
    }

    Mono<Link> getOriginalLink(String key) {
        return linkRepository.findByKey(key);
    }
}

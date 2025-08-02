package com.biblioteca.biblioteca_abc.repository;

import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {
    private AtomicInteger atomic = new AtomicInteger(3);


}

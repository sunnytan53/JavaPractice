package org.sunny.service;

import org.springframework.stereotype.Service;

@Service
public class BookService implements BookServiceInterface {
    @Override
    public void save() {
        System.out.println("service: save()");
    }
}

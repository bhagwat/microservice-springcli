package com.ttnd.feignClient

import org.springframework.beans.factory.annotation.Autowired

class ApplicationController {
    @Autowired
    LibraryClient libraryClient;

    def books() {
        respond libraryClient.getBookList();
    }

    def book(Long id) {
        respond libraryClient.findByIndex(id - 1);
    }

    def employee(Long id) {
        respond libraryClient.getEmployee(id);
    }
}

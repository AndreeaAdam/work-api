package org.example.controller;

import org.example.dto.ListOfPurchasesDto;
import org.example.service.ListOfPurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListOfPurchasesController {
    @Autowired
    private ListOfPurchasesService service;

    @GetMapping("/list")
    public  List<ListOfPurchasesDto> getProductList() {
        return service.getList();
    }
}

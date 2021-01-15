package org.example.service;

import org.example.dto.ListOfPurchasesDto;
import org.example.mapper.ListOfPurchasesMapper;
import org.example.model.ListOfPurchases;
import org.example.repository.ListOfPurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListOfPurchasesService {
    @Autowired
    private ListOfPurchasesRepository repository;
    @Autowired
    private ListOfPurchasesMapper mapper;

    public List<ListOfPurchasesDto> getList() {
        List<ListOfPurchases> list = repository.findAll();
        return list
                .stream()
                .map(listOfPurchases -> mapper.listOfPurchasesToDto(listOfPurchases))
                .collect(Collectors.toList());
    }

}

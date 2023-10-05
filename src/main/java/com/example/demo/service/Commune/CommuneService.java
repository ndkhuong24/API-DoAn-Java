package com.example.demo.service.Commune;

import com.example.demo.model.Commune;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommuneService {
    List<Commune> getAll();
    void add(List<Commune> list);
    void delete(Integer id);
}

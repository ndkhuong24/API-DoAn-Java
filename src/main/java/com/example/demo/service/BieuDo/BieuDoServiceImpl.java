package com.example.demo.service.BieuDo;

import com.example.demo.model.Bieudo;
import com.example.demo.repository.IBieudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BieuDoServiceImpl implements BieuDoService {
    @Autowired
    private IBieudoRepository repository;
    @Override
    public List<Bieudo> getMouthAndPrice(Integer month) {
        return repository.getMouthAndPrice(month);
    }
}

package com.example.demo.service.Voucher;

import com.example.demo.model.Voucher;
import com.example.demo.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private IVoucherRepository repository;

    @Override
    public Page<Voucher> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Voucher voucher) {
        repository.save(voucher);
    }

    @Override
    public void update(Voucher voucher) {
        repository.save(voucher);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Voucher getById(Integer id) {
        return repository.getOne(id);
    }
}

package com.doanjava.nhom9_chdt.service;

import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.entity.Hoadon;
import com.doanjava.nhom9_chdt.repository.DienthoaiRepository;
import com.doanjava.nhom9_chdt.repository.HoadonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class HoadonService {
    private final HoadonRepository hoadonRepository;
    public List<Hoadon> getAllHoadons(Integer pageNo,
                                      Integer pageSize,
                                      String sortBy) {

        return hoadonRepository.findAllHoadons(pageNo, pageSize, sortBy);
    }

}

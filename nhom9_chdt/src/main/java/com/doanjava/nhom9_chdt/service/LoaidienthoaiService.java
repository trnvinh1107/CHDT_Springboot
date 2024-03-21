package com.doanjava.nhom9_chdt.service;

import com.doanjava.nhom9_chdt.entity.Loaidienthoai;
import com.doanjava.nhom9_chdt.repository.LoaidienthoaiRepository;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class LoaidienthoaiService {
    private final LoaidienthoaiRepository loaidienthoaiRepository;

    public List<Loaidienthoai> getAllLoaidienthoais() {

        return loaidienthoaiRepository.findAllLoaidienthoais();
    }
    public List<Loaidienthoai> getAllLoaidienthoais(Integer pageNo,
                                                    Integer pageSize,
                                                    String sortBy) {

        return loaidienthoaiRepository.findAllLoaidienthoais(pageNo, pageSize, sortBy);
    }
    public int countLoaidienthoai() {
        return (int) loaidienthoaiRepository.count();
    }

    public Optional<Loaidienthoai> getLoaidienthoaiById(Long id) {
        return loaidienthoaiRepository.findById(id);
    }

    public void addLoaidienthoai(Loaidienthoai Loaidienthoai) {
        loaidienthoaiRepository.save(Loaidienthoai);
    }

    public void updateLoaidienthoai(@NotNull Loaidienthoai loaidienthoai) {
        Loaidienthoai existingLoaidienthoai = loaidienthoaiRepository.findById(loaidienthoai.getId())
                .orElse(null);
        Objects.requireNonNull(existingLoaidienthoai).setTenLoai(loaidienthoai.getTenLoai());
        existingLoaidienthoai.setTrangThai(loaidienthoai.getTrangThai());;
        loaidienthoaiRepository.save(existingLoaidienthoai);
    }

    public void deleteLoaidienthoaiById(Long id) {
        loaidienthoaiRepository.deleteById(id);
    }

    public List<Loaidienthoai> searchLoaidienthoai(String keyword) {
        return loaidienthoaiRepository.searchLoaidienthoai(keyword);
    }
}
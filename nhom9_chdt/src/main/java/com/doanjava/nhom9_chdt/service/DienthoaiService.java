package com.doanjava.nhom9_chdt.service;

import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.repository.DienthoaiRepository;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class DienthoaiService {
    private final DienthoaiRepository dienthoaiRepository;
    public List<Dienthoai> getAllDienthoais(Integer pageNo,
                                            Integer pageSize,
                                            String sortBy) {

        return dienthoaiRepository.findAllDienthoais(pageNo, pageSize, sortBy);
    }
    public List<Dienthoai> getDienThoaiNoiBat(Boolean showNoiBat, int limit, Boolean checkTrangThai) {
        List<Dienthoai> allDienthoais = dienthoaiRepository.findAll();
        List<Dienthoai> filteredDienthoais = new ArrayList<>();
        int count = 0;
        for (Dienthoai dienthoai : allDienthoais) {
            if (dienthoai.getNoiBat() == showNoiBat && dienthoai.getTrangThai() == checkTrangThai) {
                count++;
                filteredDienthoais.add(dienthoai);
                if(count == limit)  break;
            }
        }
        return filteredDienthoais;
    }
    public List<Dienthoai> getDienThoaiTheoLoai(Boolean showHome,int maLoai, int limit, Boolean checkTrangThai) {
        List<Dienthoai> allDienthoais = dienthoaiRepository.findAll();
        List<Dienthoai> filteredDienthoais = new ArrayList<>();
        int count = 0;
        for (Dienthoai dienthoai : allDienthoais) {
            if (dienthoai.getLoaidienthoai().getId() == maLoai && dienthoai.getHome() == showHome && dienthoai.getTrangThai() == checkTrangThai) {
                count++;
                filteredDienthoais.add(dienthoai);
                if(count == limit)  break;
            }
        }
        return filteredDienthoais;
    }
    public List<Dienthoai> getDienThoaiByMaLoai(int maLoai, Boolean checkTrangThai) {
        List<Dienthoai> danhSachDienThoai = dienthoaiRepository.findAll();
        List<Dienthoai> danhSachTheoMaLoai = new ArrayList<>();
        for (Dienthoai dt : danhSachDienThoai) {
            if (dt.getLoaidienthoai().getId() == maLoai && dt.getTrangThai() == checkTrangThai) {
                danhSachTheoMaLoai.add(dt);
            }
        }

        return danhSachTheoMaLoai;
    }
    public Optional<Dienthoai> getDienthoaiById(Long id) {
        return dienthoaiRepository.findById(id);
    }
    public void addDienthoai(Dienthoai Dienthoai) {
        dienthoaiRepository.save(Dienthoai);
    }

    public void updateDienthoai(@NotNull Dienthoai dienthoai) {
        Dienthoai existingDienthoai = dienthoaiRepository.findById(dienthoai.getId())
                .orElse(null);
        Objects.requireNonNull(existingDienthoai).setTenDienThoai(dienthoai.getTenDienThoai());
        existingDienthoai.setGiaBan(dienthoai.getGiaBan());
        existingDienthoai.setSlTon(dienthoai.getSlTon());
        existingDienthoai.setMoTa(dienthoai.getMoTa());
        existingDienthoai.setTrangThai(dienthoai.getTrangThai());
        existingDienthoai.setHome(dienthoai.getHome());
        existingDienthoai.setNoiBat(dienthoai.getNoiBat());
        existingDienthoai.setLoaidienthoai(dienthoai.getLoaidienthoai());
        dienthoaiRepository.save(existingDienthoai);
    }
    public void deleteDienthoaiById(Long id) {
        dienthoaiRepository.deleteById(id);
    }
    public List<Dienthoai> searchDienthoai(String keyword) {
        return dienthoaiRepository.searchDienthoai(keyword);
    }
}


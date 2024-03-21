package com.doanjava.nhom9_chdt.repository;

import com.doanjava.nhom9_chdt.entity.Cthd;
import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.entity.Hoadon;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoadonRepository extends JpaRepository<Hoadon, Long>{
    default List<Hoadon> findAllHoadons(Integer pageNo,
                                              Integer pageSize,
                                              String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))

                .getContent();
    }
    @Query("SELECT c FROM Hoadon c WHERE c.id = :hoadon_id")
    Hoadon findByHoadonId(Long hoadon_id);
}

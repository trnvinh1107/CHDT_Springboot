package com.doanjava.nhom9_chdt.repository;

import com.doanjava.nhom9_chdt.entity.Dienthoai;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DienthoaiRepository extends
        PagingAndSortingRepository<Dienthoai, Long>, JpaRepository<Dienthoai, Long> {
    default List<Dienthoai> findAllDienthoais(Integer pageNo,
                                              Integer pageSize,
                                              String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))

                .getContent();
    }
    @Query("""
        SELECT dt FROM Dienthoai dt
        WHERE dt.tenDienThoai LIKE %?1%
        """)

    List<Dienthoai> searchDienthoai(String keyword);
}

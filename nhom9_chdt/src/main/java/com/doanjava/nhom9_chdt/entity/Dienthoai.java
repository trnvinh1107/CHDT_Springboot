package com.doanjava.nhom9_chdt.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "dienthoai")
public class Dienthoai{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenDienThoai", length = 50, nullable = false)
    private String tenDienThoai;
    @Column(name = "hinh", length = 200, nullable = false)
    private String hinh;
    @Column(name = "giaNhap")
    private Double giaNhap;
    @Column(name = "giaBan")
    private Double giaBan;
    @Column(name = "slTon")
    private int slTon;
    @Column(name = "moTa", length = 500, nullable = false)
    private String moTa;
    @Column(name = "trangThai", nullable = false)
    private Boolean trangThai;
    @Column(name = "home", nullable = false)
    private Boolean home;
    @Column(name = "noiBat", nullable = false)
    private Boolean noiBat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLoai", referencedColumnName = "id")
    @ToString.Exclude
    private Loaidienthoai loaidienthoai;

    @OneToMany(mappedBy = "dienthoai", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Cthd> itemInvoices = new ArrayList<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Dienthoai dienthoai = (Dienthoai) o;
        return getId() != null && Objects.equals(getId(),
                dienthoai.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

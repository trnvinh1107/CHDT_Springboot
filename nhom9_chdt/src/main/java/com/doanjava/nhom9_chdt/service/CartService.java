package com.doanjava.nhom9_chdt.service;

import com.doanjava.nhom9_chdt.daos.Cart;
import com.doanjava.nhom9_chdt.daos.Item;
import com.doanjava.nhom9_chdt.entity.Cthd;
import com.doanjava.nhom9_chdt.entity.Hoadon;
import com.doanjava.nhom9_chdt.entity.User;
import com.doanjava.nhom9_chdt.repository.CthdRepository;
import com.doanjava.nhom9_chdt.repository.DienthoaiRepository;
import com.doanjava.nhom9_chdt.repository.HoadonRepository;
import com.doanjava.nhom9_chdt.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class CartService {
    private static final String CART_SESSION_KEY = "cart";
    private final HoadonRepository hoadonRepository;
    private final CthdRepository cthdRepository;

    private final UserRepository userRepository;
    private final DienthoaiRepository dienthoaiRepository;
    public Cart getCart(@NotNull HttpSession session) {
        return Optional.ofNullable((Cart)
                        session.getAttribute(CART_SESSION_KEY))
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    session.setAttribute(CART_SESSION_KEY, cart);
                    return cart;
                });
    }
    public void updateCart(@NotNull HttpSession session, Cart cart) {
        session.setAttribute(CART_SESSION_KEY, cart);
    }
    public void removeCart(@NotNull HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);
    }
    public int getSumQuantity(@NotNull HttpSession session) {
        return getCart(session).getCartItems().stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }
    public double getSumPrice(@NotNull HttpSession session) {
        return getCart(session).getCartItems().stream()
                .mapToDouble(item -> item.getPrice() *
                        item.getQuantity())
                .sum();
    }
    public void saveCart(@NotNull HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var cart = getCart(session);
        if (cart.getCartItems().isEmpty()) return;
        var invoice = new Hoadon();
        invoice.setNgayLap(new Date(new Date().getTime()));
        invoice.setDonGia(getSumPrice(session));
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user.setUsername("ADMIN");
        }
        invoice.setUser(user);
        hoadonRepository.save(invoice);
        cart.getCartItems().forEach(item -> {
            var items = new Cthd();
            items.setHoadon(invoice);
            items.setSoLuong(item.getQuantity());
            items.setDienthoai(dienthoaiRepository.findById(item.getDienthoaiId())
                    .orElseThrow());
            cthdRepository.save(items);
            var dienthoai = items.getDienthoai();
            dienthoai.setSlTon(dienthoai.getSlTon() - items.getSoLuong());
            dienthoaiRepository.save(dienthoai);
        });
        removeCart(session);
    }
}



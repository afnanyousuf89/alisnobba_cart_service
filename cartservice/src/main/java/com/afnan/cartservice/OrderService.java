package com.afnan.cartservice;

import java.util.List;

public interface OrderService {
    order saveorder(order order);
    order getorder(Long id);
    order updateorder(order order);
    void deleteorder(Long id);
    List<order> getAllorders();
}

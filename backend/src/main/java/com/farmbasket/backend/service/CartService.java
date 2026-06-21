package com.farmbasket.backend.service;

import com.farmbasket.backend.entity.Cart;
import com.farmbasket.backend.entity.CartItem;
import com.farmbasket.backend.repository.CartItemRepository;
import com.farmbasket.backend.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart != null) {
            cart.setUserId(updatedCart.getUserId());
            return cartRepository.save(cart);
        }

        return null;
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public CartItem addItemToCart(Long cartId, CartItem cartItem) {
        cartItem.setCartId(cartId);
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getItemsByCartId(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem getItemById(Long itemId) {
        return cartItemRepository.findById(itemId).orElse(null);
    }

    public CartItem updateCartItem(Long cartId, Long itemId, CartItem updatedItem) {
        CartItem cartItem = cartItemRepository.findById(itemId).orElse(null);

        if (cartItem != null && cartItem.getCartId().equals(cartId)) {
            cartItem.setProductId(updatedItem.getProductId());
            cartItem.setQuantity(updatedItem.getQuantity());
            return cartItemRepository.save(cartItem);
        }

        return null;
    }

    public void deleteCartItem(Long cartId, Long itemId) {
        CartItem cartItem = cartItemRepository.findById(itemId).orElse(null);

        if (cartItem != null && cartItem.getCartId().equals(cartId)) {
            cartItemRepository.delete(cartItem);
        }
    }
}
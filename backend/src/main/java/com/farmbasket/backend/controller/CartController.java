package com.farmbasket.backend.controller;

import com.farmbasket.backend.entity.Cart;
import com.farmbasket.backend.entity.CartItem;
import com.farmbasket.backend.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/carts", "/cart"})
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id,
                           @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return "Cart deleted successfully";
    }

    @PostMapping({"/{cartId}/items", "/add"})
    public CartItem addItemToCart(@PathVariable(required = false) Long cartId,
                                  @RequestBody CartItem cartItem) {
        Long effectiveCartId = cartId != null ? cartId : cartItem.getCartId();
        return cartService.addItemToCart(effectiveCartId, cartItem);
    }

    @GetMapping("/{cartId}/items")
    public List<CartItem> getItemsByCartId(@PathVariable Long cartId) {
        return cartService.getItemsByCartId(cartId);
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public CartItem updateCartItem(@PathVariable Long cartId,
                                   @PathVariable Long itemId,
                                   @RequestBody CartItem cartItem) {
        return cartService.updateCartItem(cartId, itemId, cartItem);
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public String deleteCartItem(@PathVariable Long cartId,
                                 @PathVariable Long itemId) {
        cartService.deleteCartItem(cartId, itemId);
        return "Cart item deleted successfully";
    }
}
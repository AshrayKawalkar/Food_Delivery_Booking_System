package com.Ashray.food_delivery.Orders.entity;
import com.Ashray.food_delivery.Orders.Enum.OrderStatus;
import com.Ashray.food_delivery.Restaurant.entity.Restaurant;
import com.Ashray.food_delivery.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();

        if(this.status==null) {
            this.status=OrderStatus.PENDING;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt=LocalDateTime.now();

    }

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems=new ArrayList<>();

}

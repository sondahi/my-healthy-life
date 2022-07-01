package com.comert.myhealthylife.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.QueryHints;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NamedQuery(
        name = "FoodCategory.findFoodCategoriesByIdAndName",
        query = "select new com.comert.myhealthylife.model.dto.IdAndName(fg.foodCategoryId,fg.foodCategoryName) from FoodCategory as fg",
        hints = {
                @QueryHint(
                        name = QueryHints.CACHEABLE,
                        value = "true"
                )
        }
)
@Cacheable
@Table(name = "FoodCategory")
@Entity
public class FoodCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodCategoryId;
    @Version
    private int version;

    @Column(name = "foodCategoryName", unique = true)
    private String foodCategoryName;

    @JsonManagedReference
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @Fetch(value = FetchMode.JOIN) // avoiding from lazy-initialization exception
    @OneToMany(
            mappedBy = "foodCategory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Food> foods = new HashSet<>();

    public FoodCategory() {
    }

    public void addFood(Food food) {
        food.setFoodCategory(this);
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FoodCategory that)) return false;

        return new EqualsBuilder()
                .append(getFoodCategoryName(), that.getFoodCategoryName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFoodCategoryName())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("foodCategoryId", foodCategoryId)
                .append("foodCategoryName", foodCategoryName)
                .toString();
    }

}

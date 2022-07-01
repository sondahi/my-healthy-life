package com.comert.myhealthylife.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.QueryHints;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NamedQuery(
        name = "Food.findFoodsByIdAndName",
        query = "select new com.comert.myhealthylife.model.dto.IdAndName(f.foodId,f.foodName) from Food as f",
        hints = {
                @QueryHint(
                        name = QueryHints.CACHEABLE,
                        value = "true"
                )
        }
)
@Cacheable
@Table(name = "Food")
@Entity
public class Food extends Component implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Version
    private int version;

    @Column(name = "foodName", unique = true)
    private String foodName;

    private String logoPath;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "foodCategoryId",
            foreignKey = @ForeignKey(name = "FK_Food_FoodCategory")
    )
    private FoodCategory foodCategory;

    public Food() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Food food)) return false;

        return new EqualsBuilder()
                .append(getFoodName(), food.getFoodName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(foodName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("foodId", foodId)
                .append("foodName", foodName)
                .append("foodCategoryId", foodCategory.getFoodCategoryId())
                .toString();
    }

}

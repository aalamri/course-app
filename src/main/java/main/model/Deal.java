package main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "deals")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Deal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String dealCategory;

    @NotBlank
    private String dealPartner;

    @NotBlank
    private int dealPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealCategory() {
        return dealCategory;
    }

    public String getDealPartner() {
        return dealPartner;
    }

    public int getDealPrice() {
        return dealPrice;
    }

    public void setDealCategory(String dealCategory) {
        this.dealCategory = dealCategory;
    }

    public void setDealPartner(String dealPartner) {
        this.dealPartner = dealPartner;
    }

    public void setDealPrice(int dealPrice) {
        this.dealPrice = dealPrice;
    }

}

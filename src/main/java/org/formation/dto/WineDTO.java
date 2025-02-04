package org.formation.dto;

public class WineDTO {
    private Long id;
    private String name;
    private Integer year;
    private String family;
    private String variety;
    private Double price;

    public WineDTO(Long id, String name, Integer year, String family, String variety, Double price) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.family = family;
        this.variety = variety;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

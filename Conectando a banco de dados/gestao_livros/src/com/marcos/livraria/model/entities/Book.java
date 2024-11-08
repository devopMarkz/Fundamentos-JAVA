package com.marcos.livraria.model.entities;

import java.util.Objects;

public class Book {

    private Integer id;
    private String title;
    private Double price;
    private Autor autor;

    private Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;;
        this.price = builder.price;
        this.autor = builder.autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", autor=" + autor +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static class Builder{
        private Integer id;
        private String title;
        private Double price;
        private Autor autor;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder autor(Autor autor) {
            this.autor = autor;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

}

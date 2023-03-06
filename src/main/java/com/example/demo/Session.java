package com.example.demo;


import jakarta.persistence.Entity; // анотация что класс является сущностбю и относиться к ORM JPA
import jakarta.persistence.GeneratedValue; // автозаполнение айди
import jakarta.persistence.GenerationType; // indentitry
import jakarta.persistence.Id;

//«машина»: ID, Вид техники (например, мультиварка), Группа техники (например, бытовые
//приборы), Дата ввоза на склад, Дата вывоза со склада, ФИО водителя, увозящего технику со склада.
//CREATE TABLE Library (
//        ID int (15) NOT NULL AUTO_INCREMENT,
//        name varchar (255) NOT NULL,
//        publish_house varchar (255) NOT NULL,
//        data_input datetime NOT NULL,
//        FIO datetime NOT NULL,
//        data_output varchar (255),
//        PRIMARY KEY (ID)
//        ) ENGINE=InnODB DEFAULT CHARSET=UTF8
// сущность которую нужно сохранять в базе данных

//Параметры объекта «сеанс»: ID, Название фильма, Киностудия, Дата и время сеанса, Количество билетов на сеанс.
@Entity
public class Session {
    private Long ID;
    private String name;
    private String film_studio;
    private String data;
    private String count_tickets;

    protected Session(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm_studio() {
        return film_studio;
    }

    public void setFilm_studio(String film_studio) {
        this.film_studio = film_studio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCount_tickets() {
        return count_tickets;
    }

    public void setCount_tickets(String count_tickets) {
        this.count_tickets = count_tickets;
    }
}

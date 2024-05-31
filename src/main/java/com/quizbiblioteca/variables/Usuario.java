package com.quizbiblioteca.variables;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String nombre;

	    @ManyToMany
	    @JoinTable(
	        name = "usuario_libro",
	        joinColumns = @JoinColumn(name = "usuario_id"),
	        inverseJoinColumns = @JoinColumn(name = "libro_id")
	    )
	    private Set<Libro> libros = new HashSet<>();

	    // Getters y setters
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public Set<Libro> getLibros() {
	        return libros;
	    }

	    public void setLibros(Set<Libro> libros) {
	        this.libros = libros;
	    }
}

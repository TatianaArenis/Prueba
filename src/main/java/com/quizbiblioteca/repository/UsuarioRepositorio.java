package com.quizbiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizbiblioteca.variables.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}

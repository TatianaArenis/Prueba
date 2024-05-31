package com.quizbiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quizbiblioteca.variables.Usuario;
import com.quizbiblioteca.repository.UsuarioRepositorio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/crear";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuario no válido:" + id));
        model.addAttribute("usuario", usuario);
        return "usuario/crear";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Integer id, @ModelAttribute Usuario usuario) {
        usuario.setId(id);
        usuarioRepositorio.save(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuario no válido:" + id));
        usuarioRepositorio.delete(usuario);
        return "redirect:/usuario/listar";
    }

}

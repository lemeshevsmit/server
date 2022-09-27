package com.example.server.controller;

import com.example.server.model.Message;
import com.example.server.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    private MessageService service;

    @GetMapping("/new")
    @PreAuthorize("hasAuthority('can:write')")
    public String addMessage(@ModelAttribute("message") Message message) {
        return "messages/new";
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('can:write')")
    public String create(@ModelAttribute("message") @Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "messages/new";
        }
        service.saveMessage(message);
        return "redirect:/api/messages";
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('can:read')")
    public String findAllMessages(Model model) {
        model.addAttribute("messages", service.getMessages());
        return "messages/index";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('can:read')")
    public String findMessageById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("message", service.getMessageById(id));
        return "messages/show";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("hasAuthority('can:write')")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("message", service.getMessageById(id));
        return "messages/edit";
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('can:write')")
    public String updateMessage(@ModelAttribute("message") @Valid Message message,
                                BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "messages/edit";
        }
        service.updateMessage(id, message);
        return "redirect:/api/messages/{id}";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('can:delete')")
    public String deleteMessage(@PathVariable Long id) {
        service.deleteMessage(id);
        return "redirect:/api/messages";
    }
}

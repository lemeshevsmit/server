package com.example.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email_from", nullable = false)
    @NonNull
    @Email(message = "Email should be valid")
    private String from;
    @Column(name = "email_to", nullable = false)
    @NonNull
    @Email(message = "Email should be valid")
    private String to;
    @Column(name = "subject", nullable = false)
    @NonNull
    @Size(min = 2, max = 30, message = "Subject should be between 2 and 30 characters")
    private String subject;
    @Column(name = "text", nullable = false)
    @NonNull
    private String text;
    @Column(name = "post_date", nullable = false)
    @NonNull
    private String postDate;
}
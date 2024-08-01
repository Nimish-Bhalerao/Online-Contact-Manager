package com.ocm.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.stream.Collectors;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails{
  @Id
  private String userId;

  @Column(name = "user_name", nullable = false)
  private String name;

  private String email;

  private String password;

  @Column(length = 1000)
  private String about;

  @Column(length = 1000)
  private String profilePic;

  private String phoneNumber;

  private boolean enabled = true;

  @Builder.Default
  private boolean emailVerified = false;

  @Builder.Default
  private boolean phoneVerified = false;

  @Enumerated(value = EnumType.STRING)
  private Providers provider = Providers.SELF;

  private String providerUserId;

  // mapping
  // too many things to keep in mind
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();

  
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());

     return roles;
    }


    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

//email is the username used 
    @Override
    public String getUsername() {
      return this.email;
    }
@Override
public boolean isEnabled() {
  return this.enabled;
}
    
@Override
public String getPassword() {
  return this.password;
}
}
package com.easypick.thunderMan.dto.security;

import com.easypick.thunderMan.dto.DlUserDto;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record UserPrincipal(
        String username,
        String password,
        Collection<? extends GrantedAuthority> authorities,
        String email,
        String nickname
) implements UserDetails {


    public static UserPrincipal of(String username, String password, String email, String nickname) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);

        return new UserPrincipal(
                username,
                password,
                roleTypes.stream()
                        .map(RoleType::getName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet()),

                email,
                nickname
        );
    }

    public static UserPrincipal from(DlUserDto dto) {
        return UserPrincipal.of(
                dto.userId(),
                dto.userPassword(),
                dto.email(),
                dto.nickname()
        );
    }

    public DlUserDto toDto() {
        return DlUserDto.of(
                username,
                password,
                email,
                nickname
        );
    }

    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override public boolean isAccountNonExpired() {
        return true;
    }
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override public boolean isEnabled() {
        return true;
    }

   public enum RoleType{
        USER("ROLE_USER");

        @Getter private final String name;

        RoleType(String name){
            this.name = name;
        }
   }
}

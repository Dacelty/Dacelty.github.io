package com.example.blogbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Kiểm tra cho mỗi request gửi lên
@Component
public class CustomFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Lấy email trong session
        String email = (String) request.getSession().getAttribute("MY_SESSION");

        // Nếu không tồn tại email -> chuyển qua filter tiếp theo để xử lý
        if(email == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lấy ra đối tượng xác thực
        UserDetails user = customUserDetailsService.loadUserByUsername(email);

        // Tạo ra đối tượng đã xác thực chứa các roles để phân quyền request
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());

        // Lưu vào trong context
        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }
}

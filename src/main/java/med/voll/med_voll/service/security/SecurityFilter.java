package med.voll.med_voll.service.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // anotação genérica pro spring carregar a classe autimaticamente
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperToken(request);

        filterChain.doFilter(request, response); // segue o fluxo do filtro

    }

    private String recuperToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization"); // pega o token da requisição
        if(authHeader == null){
            throw new RuntimeException("Token JWT não enviado no cabeçalho!");
        }
        return authHeader.replace("Barer", "");
    }
}

package com.JavaSystem.SpringBBS;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

// @Componentをつけることで、このクラスがSpringのコンテナにBeanとして登録される
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    // テスト用の固定値ユーザー名とパスワード
    private static final String FIXED_USERNAME = "testUser";
    private static final String FIXED_PASSWORD = "testPass123";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // ブラウザから入力したユーザ名・パスワードを取得
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            // 認証成功時は、認証トークン(ユーザ名、パスワード、権限)を作成
            return new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            // 認証失敗は、エラーを返す
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // authentication(認証方式)がUsernamePasswordAuthenticationToken.class(ユーザー名とパスワード認証)か判定
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
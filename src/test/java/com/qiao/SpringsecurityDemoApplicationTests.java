package com.qiao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringsecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        String hashpw = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(hashpw);
        //对密码进行加密
        /**
         * public String encode(CharSequence rawPassword) {
         *         String salt;
         *         if (this.random != null) {
         *             salt = BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
         *         } else {
         *             salt = BCrypt.gensalt(this.version.getVersion(), this.strength);
         *         }
         *
         *         return BCrypt.hashpw(rawPassword.toString(), salt);
         *     }
         *     encode方法本质上还是使用hashpw
         */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode.length());
        System.out.println(encode);
    }

}

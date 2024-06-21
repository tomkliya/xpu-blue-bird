package com_xpu;

import com_xpu.domain.entity.Articles;
import com_xpu.service.impl.ArticlesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class XpuLearnSpringApplicationTests {
@Resource(type = ArticlesServiceImpl.class)
    private ArticlesServiceImpl articlesServiceImpl;
    @Test
    void contextLoads() {
        Articles articles = Articles.builder()
                .articleId("123")
                .title("测试文章")
                .status(Integer.valueOf(2))
                .updateTime(LocalDateTime.now())
                .build();
        articlesServiceImpl.save(articles);

    }

}

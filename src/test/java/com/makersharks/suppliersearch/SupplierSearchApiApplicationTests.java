package com.makersharks.suppliersearch;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SupplierSearchApiApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldLoadModelMapperBean() {
        assertThat(applicationContext.getBean(ModelMapper.class)).isNotNull();
    }
}

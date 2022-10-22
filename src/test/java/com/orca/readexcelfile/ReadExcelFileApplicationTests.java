package com.orca.readexcelfile;

import model.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import service.ReadExcelFileService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReadExcelFileApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String path = "src/test/java/resource/insumo-preco.xls";

        List<Input> expected = new ArrayList<Input>();

        Input input1 = Input.builder()
                .classeDescription("AÇO")
                .type("013")
                .typeDescription("VERGALHÃO")
                .classificationCode("01.02.013.000000026")
                .description("ACO CA-25, 10,0 MM, VERGALHAO ")
                .unity("KG")
                .priceMedium("11.752,26")
                .priceOrigin("AS")
                .macroClass("01 ")
                .macroClasseDescription("MATERIAL")
                .classe("02 ")
                .institution("CAIXA REFERENCIAL                                 ")
                .build();

        expected.add(input1);

        List<Input> actual = ReadExcelFileService.readExcelFile(path);

        Assertions.assertEquals(expected, actual);
    }

}

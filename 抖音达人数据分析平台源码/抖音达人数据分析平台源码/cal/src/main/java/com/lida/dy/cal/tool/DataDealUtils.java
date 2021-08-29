package com.lida.dy.cal.tool;

import com.lida.entity.FTalentUserInfoEntity;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/12 0012 12:50
 * @Version: 1.0
 */
public class DataDealUtils {
    public static List<FTalentUserInfoEntity> getUser(String path) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(path)));
        HeaderColumnNameMappingStrategy<FTalentUserInfoEntity> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(FTalentUserInfoEntity.class);

        CsvToBean<FTalentUserInfoEntity> csvToBean = new CsvToBeanBuilder<FTalentUserInfoEntity>(inputStreamReader)
                .withSeparator(',')
                .withQuoteChar('\"')
                .withMappingStrategy(strategy).build();
        List<FTalentUserInfoEntity> csvBeans = csvToBean.parse();
        inputStreamReader.close();
        return csvBeans;
    }
}

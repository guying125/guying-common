package com.guying.msgcenter.domain.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author QJYou
 * @date 2023-06-04 18:59
 */
public class Main {

    public static void main(String[] args) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setId(0L)
                .setValue("")
                .setLabelNam("")
                .setType("")
                .setDescInf("")
                .setSort(new BigDecimal("0"))
                .setCrtBy("")
                .setCrtTim(new Timestamp(new java.util.Date().getTime()))
                .setLstUpdBy("")
                .setLstUpdTim(new Timestamp(new java.util.Date().getTime()))
                .setRemarks("")
                .setDelFlg("");

        SysConfigDTO sysConfigDTO = new SysConfigDTO();
    }
}

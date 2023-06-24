package com.guying.fourlayer.easycodetest.test1.adapter.ghost;

import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.service.SysConfigService;
import com.guying.fourlayer.infrastructure.commons.global.UniResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置表(SysConfig) Ghost适配器
 *
 * @author Guying
 * @since 2023-06-24 23:27:23
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/sysConfig")
public class SysConfigGhostAdapter {
    private final SysConfigService sysConfigService;

    /**
     * demo
     */
    public UniResponse<String> query() {
        return UniResponse.buildSuccess();
    }
}

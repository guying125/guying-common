package com.guying.msgcenter.domain.entity.controller;

import com.guying.msgcenter.domain.entity.entity.SysDict;
import com.guying.msgcenter.domain.entity.service.SysDictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 字典表(SysDict)表控制层
 *
 * @author Guying
 * @since 2023-06-04 23:56:16
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictService sysDictService;

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SysDict>> queryByPage(SysDict sysDict, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysDictService.queryByPage(sysDict, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysDict> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sysDictService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysDict 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysDict> add(SysDict sysDict) {
        return ResponseEntity.ok(this.sysDictService.insert(sysDict));
    }

    /**
     * 编辑数据
     *
     * @param sysDict 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysDict> edit(SysDict sysDict) {
        return ResponseEntity.ok(this.sysDictService.update(sysDict));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.sysDictService.deleteById(id));
    }

}


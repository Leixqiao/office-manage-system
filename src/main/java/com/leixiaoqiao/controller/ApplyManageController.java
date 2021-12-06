package com.leixiaoqiao.controller;

import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.api.vo.Result;
import com.leixiaoqiao.pojo.Apply;
import com.leixiaoqiao.service.ApplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 物品申请管理的后台控制器
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-12-02 14:12:46
 */
@RestController
@RequestMapping("/apply")
public class ApplyManageController {

    @Autowired
    private ApplyManageService applyManageService;

    @GetMapping("/page/{pageNum}/{pageSize}")
    public Result<?> page(@PathVariable Integer pageNum,
                          @PathVariable Integer pageSize
            , String applyName, String applyDate){

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("applyName",applyName);
        map.put("applyDate", applyDate);
        PageInfo<Apply> pageInfo = applyManageService.getPage(map);

        return Result.ok(pageInfo);
    }

    @PutMapping("/{applyId}/{applyState}")
    public Result<?> updateApplyState(@PathVariable Integer applyId,@PathVariable Integer applyState){

        Boolean tag=applyManageService.updateApplyState(applyId,applyState);
        if (tag){
            return Result.ok("操作成功！");
        }return Result.error("操作失败！");
    }

    @PutMapping("/{state}")
    public Result<?> updateStates(@PathVariable Integer state, @RequestBody List<Integer> ids){

        Boolean tag=applyManageService.updateStates(state,ids);
        if (tag){
            return Result.ok("操作成功！");
        }return Result.error("操作失败！");
    }

    @PostMapping
    public Result<?> addApply(@RequestBody Apply apply){
        System.out.println(apply);
        Boolean tag=applyManageService.addApply(apply);
        if (tag){
            return Result.ok("申请成功，请等待管理员审核！");
        }return Result.error("申请失败，请联系管理员！");
    }

    @GetMapping("/myApply/{pageNum}/{pageSize}")
    public Result<?> myApply(@PathVariable Integer pageNum,
                             @PathVariable Integer pageSize,
                             @RequestParam String articleName,
                             @RequestParam Integer articleType,
                             @RequestParam Integer userId){
        PageInfo<Apply> pageInfo =
                applyManageService.getMyApply(pageNum,pageSize,articleName,articleType,userId);

        return Result.ok(pageInfo);
    }
}

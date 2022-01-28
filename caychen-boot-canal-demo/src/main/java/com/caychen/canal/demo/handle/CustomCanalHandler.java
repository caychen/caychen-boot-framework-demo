package com.caychen.canal.demo.handle;

import com.alibaba.fastjson.JSON;
import com.caychen.boot.canal.handler.AbstractCanalDataHandler;
import com.caychen.boot.canal.model.CanalModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Caychen
 * @Date: 2022/1/28 17:37
 * @Description:
 */
@Component
@Slf4j
public class CustomCanalHandler extends AbstractCanalDataHandler {

    @Override
    public void handleInsert(CanalModel canalModel) {
        log.info("新增数据：" + JSON.toJSONString(canalModel));
    }

    @Override
    public void handleUpdate(CanalModel canalModel) {
        log.info("修改数据：" + JSON.toJSONString(canalModel));
    }

    @Override
    public void handleDelete(CanalModel canalModel) {
        log.info("删除数据：" + JSON.toJSONString(canalModel));
    }

    @Override
    public void handleTruncate(CanalModel canalModel) {
        log.info("清空数据：" + JSON.toJSONString(canalModel));
    }

}

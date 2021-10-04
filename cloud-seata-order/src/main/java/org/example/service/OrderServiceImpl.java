package org.example.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.OrderDao;
import org.example.entities.Order;
import org.example.handler.ServiceException;
import org.example.model.CommonResult;
import org.example.model.OrderRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public void create(OrderRequest orderRequest) {
        Long productId = orderRequest.getProductId();
        Integer count = orderRequest.getCount();
        CommonResult commonResult = storageService.getById(productId);
        if (Optional.ofNullable(commonResult).isPresent() && commonResult.getCode() == 200) {
            JSONObject object = (JSONObject) JSONObject.toJSON(commonResult.getData());
            BigDecimal price = object.getBigDecimal("price");
            if (Optional.ofNullable(price).isPresent()) {
                Long userId = getUserId();
                BigDecimal number = new BigDecimal(count);
                Order order = new Order();
                BeanUtils.copyProperties(orderRequest, order);
                order.setUserId(userId);
                order.setMoney(price.multiply(number));
                order.setCreateTime(new Date());
                log.info("create order");
                orderDao.save(order);
                log.info("decrease storage");
                storageService.decrease(productId, count);
                log.info("decrease account");
                accountService.decrease(userId, order.getMoney());
                log.info("update order status");
                orderDao.updateStatus(order.getId(), userId, 1, 0);
                log.info("done");
                return;
            }
        }
        throw new ServiceException(400, "product not exists");
    }

    // 获取用户ID
    private Long getUserId() {
        return 1l;
    }
}
